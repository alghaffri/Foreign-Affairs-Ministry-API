package com.example.demo.Service;

import com.example.demo.Models.Policy;
import com.example.demo.Repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    @Autowired
    PolicyRepository policyRepository;




    public void addPolicy(Policy policy) {
        policyRepository.save(policy);
    }




    public List<Policy> getPolicyByCountry(String country) {
        return policyRepository.findByCountry(country);
    }
}
