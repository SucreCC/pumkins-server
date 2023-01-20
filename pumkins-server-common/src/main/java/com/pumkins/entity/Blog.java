package com.pumkins.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

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

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "markdown", nullable = false)
    private String markdown;

    @Column(name = "blog_description")
    private String blogDescription;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "is_visible", nullable = false)
    private Boolean isVisible;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "work_or_life", nullable = false)
    private Boolean workOrLife;

    @Column(name = "is_draft", nullable = false)
    private Boolean isDraft;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "number_of_thumb_up ")
    private Integer numberOfThumbUp;

    @Column(name = "number_of_view")
    private Integer numberOfView;

    @Column(name = "number_of_comment")
    private Integer numberOfComment;

    @Column(name = "number_of_favorite")
    private Integer numberOfFavorite;

}
