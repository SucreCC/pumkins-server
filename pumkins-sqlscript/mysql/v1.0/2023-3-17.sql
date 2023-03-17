--  --------------------------------------
--  pumkins_time_node
--
--  -------------------------------------

drop table if exists pumkins_time_node;
create table pumkins_time_node
(
    id                 int PRIMARY key auto_increment,
    title              varchar(255) not null comment 'title',
    create_date        datetime(0)  not null comment 'create date',
    update_date        datetime(0)  not null comment 'update_date',
    time_description   varchar(255) not null comment 'time node description',
    latitude           double       not null comment 'latitude',
    longitude          double       not null comment 'longitude',
    username           varchar(255) not null comment 'username',
    user_id            int          not null comment 'user id'
) comment 'pumkins_time_node table' charset = utf8mb4;


--  --------------------------------------
--  pumkins_time_node_tags
--
--  -------------------------------------


drop table if exists pumkins_time_node_tags;
create table pumkins_time_node_tags
(
    id                 int PRIMARY key auto_increment,
    time_node_id       int          not null comment 'time node id',
    tag_name           varchar(255)      not null comment 'tag name',
    create_date        datetime(0)  not null comment 'create date',
    update_date        datetime(0)  not null comment 'update_date'
) comment 'pumkins_time_node_tags table' charset = utf8mb4;


--  --------------------------------------
--  pumkins_time_node_tags
--
--  -------------------------------------


drop table if exists pumkins_time_node_link_blog;
create table pumkins_time_node_link_blog
(
    id                 int PRIMARY key auto_increment,
    time_node_id       int          not null comment 'time node id',
    blog_id            int          not null comment 'blog id',
    blog_title         varchar(255)      not null comment 'blog title',
    create_date        datetime(0)  not null comment 'create date',
    update_date        datetime(0)  not null comment 'update_date'
) comment 'pumkins_time_node_link_blog table' charset = utf8mb4;