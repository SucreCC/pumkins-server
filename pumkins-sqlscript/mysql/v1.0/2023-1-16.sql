--  --------------------------------------
--  pumkins_blog_category
--
--  -------------------------------------

drop table if exists pumkins_blog_category;
create table pumkins_blog_category
(
    id          BIGINT PRIMARY key auto_increment,
    label       varchar(50) not null comment '类目',
    value       int(50)     not null comment '值',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'update date'
) comment 'img table' charset = utf8mb4;


