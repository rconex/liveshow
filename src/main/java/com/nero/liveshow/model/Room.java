package com.nero.liveshow.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private int type;

    private String cover;

    @CreatedDate
    private Long GMT_CREATE;

    @LastModifiedDate
    private Long GME_MODIFIED;
}
