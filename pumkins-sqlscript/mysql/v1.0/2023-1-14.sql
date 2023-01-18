--  --------------------------------------
--  pumkins_img
--
--  -------------------------------------


drop table if exists pumkins_img;
create table pumkins_img
(
    id          BIGINT PRIMARY key auto_increment,
    md5         VARCHAR(255) not null comment '文件md5码',
    size        BIGINT       not null comment '文件大小',
    suffix      VARCHAR(10)  not null comment '后缀名',
    img_name    varchar(50)  not null comment '图片名',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'img table' charset = utf8mb4;




drop table if exists pumkins_blog_img;
create table pumkins_blog_img
(
    id          BIGINT PRIMARY key auto_increment,
    blog_id     int          not null comment 'blog id',
    img_id      int          not null comment  'img id',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'pumkins_blog_img' charset = utf8mb4;



drop table if exists pumkins_tags;
create table pumkins_tags
(
    id          int PRIMARY key auto_increment,
    tag_name    VARCHAR (255)  not null comment 'tag name',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'tags table' charset = utf8mb4;


drop table if exists pumkins_blog_tags;
create table pumkins_blog_tags
(
    id          int PRIMARY key auto_increment,
    blog_id     int          not null comment 'blog id',
    tag_id      int          not null comment  'tag id',
    create_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'pumkins_blog_tags table' charset = utf8mb4;