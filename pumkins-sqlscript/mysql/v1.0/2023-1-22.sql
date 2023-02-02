--  --------------------------------------
--  pumkins_blog_comment
--
--  -------------------------------------

drop table if exists pumkins_blog_comment;
create table pumkins_blog_comment
(
    id                 int PRIMARY key auto_increment,
    blog_id            int          not null comment 'blog id',
    parent_id          int          not null comment 'parent id',
    comment_content    varchar(255) not null comment 'comment content',
    user_name          varchar(255) not null comment 'username',
    icon               varchar(255) not null comment 'user icon',
    number_of_thumb_up int          not null comment 'number of thumb up',
    create_date        datetime(0)  NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'create date',
    update_date        datetime(0)  NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT 'update date'
) comment 'pumkins_blog_comment table' charset = utf8mb4;

