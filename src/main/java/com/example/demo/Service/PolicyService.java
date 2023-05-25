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

    public Policy updatePolicy(Long id, Policy updatedPolicy) {
        Optional<Policy> optionalPolicy = policyRepository.findById(id);
        if (optionalPolicy.isPresent()) {
            Policy existingPolicy = optionalPolicy.get();
            existingPolicy.setCountry(updatedPolicy.getCountry());
            existingPolicy.setRegion(updatedPolicy.getRegion());
            existingPolicy.setTopic(updatedPolicy.getTopic());
            existingPolicy.setDetails(updatedPolicy.getDetails());
            return policyRepository.save(existingPolicy);
        } else {
            throw new ResourceNotFoundException("Policy not found with id: " + id);
        }
    }

}
