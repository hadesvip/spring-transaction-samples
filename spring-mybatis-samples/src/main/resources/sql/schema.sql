DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user
(
    user_id      INTEGER PRIMARY KEY,
    user_no      VARCHAR(64),
    state        VARCHAR(32),
    user_name    VARCHAR(32),
    phone_number VARCHAR(11),
    email        VARCHAR(64)
);


CREATE TABLE t_trade(
    trade_id        INTEGER PRIMARY KEY,
    trade_no        VARCHAR(64),
    user_id         INTEGER,
    state           VARCHAR(32),
    trade_amount    decimal(10, 2),
    trade_date_time datetime
);