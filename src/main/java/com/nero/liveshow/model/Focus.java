package com.nero.liveshow.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Focus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String imgUrl;

    private String redirectUrl;

    @CreatedDate
    private Long GMT_CREATE;

    @LastModifiedDate
    private Long GMT_MODIFIED;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getRedirectUrl() {
        return redirectUrl;
    }

    public void setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
    }

    public Long getGMT_CREATE() {
        return GMT_CREATE;
    }

    public void setGMT_CREATE(Long GMT_CREATE) {
        this.GMT_CREATE = GMT_CREATE;
    }

    public Long getGMT_MODIFIED() {
        return GMT_MODIFIED;
    }

    public void setGMT_MODIFIED(Long GMT_MODIFIED) {
        this.GMT_MODIFIED = GMT_MODIFIED;
    }
}
