package com.example.demo.Models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@Entity
@Data
public class Policy extends BaseEntity{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    private String country;
    private String region;
    private String topic;
    private String details;

    // No-args constructor, required by JPA
    public Policy() {
    }

    public Policy(String country, String region, String topic, String details) {
        this.country = country;
        this.region = region;
        this.topic = topic;
        this.details = details;
    }

}
