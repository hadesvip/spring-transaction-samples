package com.kevin.jdbc.samples.modules.transaction.service.impl;

import com.kevin.jdbc.samples.modules.transaction.domain.entity.TransactionEntity;
import com.kevin.jdbc.samples.modules.transaction.service.PropagationRequiresNewAService;
import com.kevin.jdbc.samples.modules.transaction.service.PropagationRequiresNewBService;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 执行流程：
 * 1. 线程执行到PropagationNewA.payA()方法是,其实执行的是PropagationNewA的代理对象的payA方法.
 * 2. 执行PropagationNewA代理对象payA方法
 *  2.1 执行payA方法的增强逻辑->事务增强器(环绕增强)
 *  2.2 事务增强器:提取事务标签属性
 *  2.3 检查当前线程有没有绑定数据库connection数据廉洁资源,
 *      发现当前线程未绑定(TransactionSynchronizationManager#resources字段:ThreadLocal<Map<Object,Object>,检查key:datasource有没有数据)
 *  2.4 因为未绑定connection资源,所以线程下一步就是到Datasource.getConnection()获取资源.
 *  2.5 因为新获取的connection资源是autocommit是true,所以这一步修改autocommit=false,表示手动提交事务(开启事务)
 *  2.6 绑定资源(TransactionSynchronizationManager#resources字段:ThreadLocal<Map<Object,Object>)
 * 3. 执行事务增强器后面的增强...
 * 4. 最后一个device调用target的目标方法的payA()方法
 *   4.1 假设target的目标方法的payA()方法需要访问数据库执行SQL,应用程序需要获取一个connection资源,
 *        DatasourceUtils.getConnection()这一步最终会拿到事务增强器前置增强逻辑,
 *        存放在TransactionSynchronizationManager#resources内的Connction资源.
 *   4.2 执行方法payA()方法逻辑可能会执行一些SQL语句...
 * 5. 线程执行到PropagationNewB#payB()方法
 *    PropagationNewB是一个代理对象,因为它使用了@tranaction注解,spring会自动为它创建代理.
 * 6. 执行PropagationNewB代理对象的payB()方法
 *   6.1 执行payB()方法的增强逻辑->事务增强强(环绕增强)
 *   6.2 事务增强器:提取事务标签属性
 *   6.3 检查当前线程是否绑定connection连接,发现当前线程已经绑定了connection数据库连接资源
 *   6.4 检查当前事务注解属性:发现是Propagation.REQUIRED,所以共享connection数据库连接资源
 * 7.执行事务增强器后面的增强器...
 * 8.最后一个device调用target(PropagationNewBService)的目标方法payB()方法
 *   8.1 如果PropagationNewBService#payB()方法需要访问数据库执行SQL,程序就需要获取一个connection资源,从哪里获取?
 *        调用DatasourceUtils.getConnection获取,这个方法里面会拿到代理对象PropagationNewAService存放在
 *        TransactionSynchronizationManager#resources内的connection资源.
 *   8.2 执行PropagationNewBService#payB方法逻辑..可能涉及到SQL
 * 9. 执行PropagationNewBService的payB方法的后置逻辑(代理对象的后置增强)
 * 10. 线程回到目标PropagationNewAService方法内,继续执行
 *   10.1 执行payA()方法的内的逻辑,可能还会涉及到一些SQL.
 * 11. 线程继续回到代理PropagationNewAService#payA()内,继续执行
 *   11.1 执行payA方法的增强逻辑->事务增强器(环绕增强-后置增强)
 *   11.2 提交事务/回滚事务
 *   12.3 恢复连接状态(connection#autocommit=true)
 *   12.4 将connection资源从TransactionSynchronizationManager#resources移除
 *   12.5 connection 关闭(归还给datasource)
 *
 * @author wangyong
 */
@Service
public class PropagationRequiresNewAServiceImpl implements PropagationRequiresNewAService {

  private final PropagationRequiresNewBService propagationRequiresNewBService;

  public PropagationRequiresNewAServiceImpl(
      PropagationRequiresNewBService propagationRequiresNewBService) {
    this.propagationRequiresNewBService = propagationRequiresNewBService;
  }

  @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
  @Override
  public void payA() {
    TransactionEntity transactionEntity = new TransactionEntity();
    transactionEntity.setTransactionId(UUID.randomUUID().toString());
    transactionEntity.setName("测试");
    propagationRequiresNewBService.payB(transactionEntity);
    //一些业务逻辑
  }
}
