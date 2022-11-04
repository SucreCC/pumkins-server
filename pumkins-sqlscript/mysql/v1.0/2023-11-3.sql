--  --------------------------------------
--  pumkins_user单词表
--
--  -------------------------------------


drop table if exists pumkins_user;
drop table if exists pumkins_user;
create table pumkins_user
(
    id          int auto_increment comment 'primary key' primary key,
    username    varchar(50)  not null comment 'user name',
    password    varchar(255) not null comment 'password',
    email       varchar(255) not null comment 'email',
    icon        varchar(255) not null comment 'icon',
    role        varchar(20)  not null comment '0:host, 1:user, 2:normal',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'user table' charset = utf8mb4;

