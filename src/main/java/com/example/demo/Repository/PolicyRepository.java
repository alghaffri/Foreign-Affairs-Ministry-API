package com.example.demo.Repository;

import com.example.demo.Models.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    List<Policy> findByCountry(String country);
}
