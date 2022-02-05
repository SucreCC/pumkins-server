package com.pumkins.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author: dengKai
 * @date: 2022/02/05 23:23
 * @description:
 */

@Entity
@Table(name = "pumkins_blog")
@Data
@Accessors(chain = true)
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "img", nullable = false)
    private String img;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "blog_describe", nullable = false)
    private String blogDescribe;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "update_date")
    private String updateDate;
}
