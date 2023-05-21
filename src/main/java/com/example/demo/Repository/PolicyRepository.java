package com.example.demo.Repository;

import com.example.demo.Models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByCountry(String country);
    List<Policy> findByRegion(String region);
    List<Policy> findByTopic(String topic);

}
