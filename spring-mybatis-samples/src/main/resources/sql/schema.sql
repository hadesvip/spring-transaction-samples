create table if not exists t_user(
    user_id      INTEGER PRIMARY KEY auto_increment,
    user_no      VARCHAR(64),
    state        VARCHAR(32),
    user_name    VARCHAR(32),
    phone_number VARCHAR(11),
    email        VARCHAR(64)
);

create table if not exists t_trade(
    trade_id        INTEGER PRIMARY KEY auto_increment,
    trade_no        VARCHAR(64),
    user_id         INTEGER,
    state           VARCHAR(32),
    trade_amount    decimal(10, 2),
    trade_date_time datetime
);