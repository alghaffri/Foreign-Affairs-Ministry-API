package com.example.demo.Controller;

import com.example.demo.Models.Policy;
import com.example.demo.RequestObjects.RequestPolicy;
import com.example.demo.Service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    @Autowired
    PolicyService policyService;



    @PostMapping
    public ResponseEntity<Policy> addPolicy(@RequestBody Policy policy) {
        Policy newPolicy = policyService.addPolicy(policy);
        return new ResponseEntity<>(newPolicy, HttpStatus.CREATED);
    }



    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }
    @GetMapping("/country/{country}")
    public ResponseEntity<List<Policy>> getPoliciesByCountry(@PathVariable String country) {
        List<Policy> policies = policyService.getPoliciesByCountry(country);
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/region/{region}")
    public ResponseEntity<List<Policy>> getPoliciesByRegion(@PathVariable String region) {
        List<Policy> policies = policyService.getPoliciesByRegion(region);
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    @GetMapping("/topic/{topic}")
    public ResponseEntity<List<Policy>> getPoliciesByTopic(@PathVariable String topic) {
        List<Policy> policies = policyService.getPoliciesByTopic(topic);
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

    public void createPolicy(RequestPolicy requestPolicy){
        Policy policy = new Policy();
        policy.setCountry(requestPolicy.getCountry());
        policy.setRegion(requestPolicy.getRegion());
        policy.setTopic(requestPolicy.getTopic());
        policy.setDetails(requestPolicy.getDetails());
        policy.setIsActive(true);
        policy.setCreatedDate(new Date());
        policyService.saveAccount(account);



    }
    @RequestMapping("policy/create")
    public void savePolicy()
    {
        createPolicy();
    }
}