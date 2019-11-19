package com.snail.booklist.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Snail
 * @date 2019/11/17 7:56
 */
@Entity
@Setter
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reader;
    private String isbn;
    private String title;
    private String author;
    private String description;
//    private Date createTime;
//    private Date updateTime;
//
//    @PrePersist
//    public void createDate() {
//        this.createTime = new Date();
//        this.updateTime = new Date();
//    }
//
//    @PreUpdate
//    public void updateTime() {
//        this.updateTime = new Date();
//    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
