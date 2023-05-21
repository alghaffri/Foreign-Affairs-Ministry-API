package com.example.demo.Service;

import com.example.demo.Models.Policy;
import com.example.demo.Repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    @Autowired
    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public Policy addPolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Optional<Policy> getPolicyById(Long id) {
        return policyRepository.findById(id);
    }

    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }

    public List<Policy> getPoliciesByCountry(String country) {
        return policyRepository.findByCountry(country);
    }

    public List<Policy> getPoliciesByRegion(String region) {
        return policyRepository.findByRegion(region);
    }

    public List<Policy> getPoliciesByTopic(String topic) {
        return policyRepository.findByTopic(topic);
    }
}
