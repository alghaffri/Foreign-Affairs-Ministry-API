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
    Long id;

    String country;
    String region;
    String topic;
    String details;




}
