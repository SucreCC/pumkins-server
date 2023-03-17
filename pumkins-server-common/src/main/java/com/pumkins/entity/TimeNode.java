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
 * @date: 2023/03/17 15:15
 * @description: TODO
 */
@Data
@Accessors(chain = true)
@Entity
@Table(name="pumkins_time_node")
public class TimeNode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "update_date", nullable = false)
    private Date updateDate;

    @Column(name = "time_description", nullable = false)
    private String timeDescription;

    @Column(name = "latitude", nullable = false)
    private Double latitude;

    @Column(name = "longitude", nullable = false)
    private Double longitude;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "user_id", nullable = false)
    private Integer userId;
}
