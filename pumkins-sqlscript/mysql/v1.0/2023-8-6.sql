--  --------------------------------------
--  pumkins_news
--
--  -------------------------------------

drop table if exists pumkins_news;
create table pumkins_news
(
    id                 int PRIMARY key auto_increment,
    title              varchar(255) not null comment 'news title',
    url                varchar(255) not null comment 'news url'
) comment 'pumkins_news table' charset = utf8mb4;

