package com.driver.models;

import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "blog_info")

public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String content;
    @CreationTimestamp
    Date date;

    @ManyToOne
    @JoinColumn
    User user;

    @OneToMany(mappedBy = "image",cascade = CascadeType.ALL)
    List<Image>imageList=new ArrayList<>();

    public Blog(int id, String title, String content, Date date, User user, List<Image> imageList) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.user = user;
        this.imageList = imageList;
    }

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }
}