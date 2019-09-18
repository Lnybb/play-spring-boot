CREATE TABLE account
(
    id          VARCHAR(50)    NOT NULL,
    user_id     VARCHAR(50)    NOT NULL,
    balance     DECIMAL(38, 6) NOT NULL DEFAULT 0,
    create_time DATETIME       NOT NULL default current_timestamp,
    update_time DATETIME       NOT NULL default current_timestamp on update current_timestamp,
    PRIMARY KEY (id)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT 'account';

insert account (id, user_id) value ('1', '1');

select id, user_id, balance from account;

update account
set balance = balance + 1
where user_id = 1;

set session transaction isolation level read uncommitted
