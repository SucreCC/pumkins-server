--  --------------------------------------
--  pumkins_blog_comment
--
--  -------------------------------------

drop table if exists pumkins_blog_comment;
create table pumkins_blog_comment
(
    id           int PRIMARY key auto_increment,
    blog_id      int          not null comment 'blog id',
    parent_id    int          not null comment 'parent id',
    children_id  int          not null comment 'children id',
    blog_comment varchar(255) not null comment 'blog comment',
    create_date  datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'create date',
    update_date  datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP (0) COMMENT 'update date'
) comment 'pumkins_blog_category table' charset = utf8mb4;

