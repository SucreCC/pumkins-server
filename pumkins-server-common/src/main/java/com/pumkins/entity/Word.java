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
 * @date: 2022/02/14 11:02
 * @description:
 */

@Entity
@Table(name = "pumkins_word")
@Data
@Accessors(chain = true)
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "word_name", nullable = false)
    private String wordName;

    @Column(name = "word_content", nullable = false)
    private String wordContent;

    @Column(name = "create_date", nullable = false)
    private String createDate;

    @Column(name = "the_day", nullable = false)
    private Integer theDay;
}
