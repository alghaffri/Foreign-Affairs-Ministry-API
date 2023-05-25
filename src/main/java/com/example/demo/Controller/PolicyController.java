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

public class PolicyController {
    @Autowired
    PolicyService policyService;


    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
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
        policyService.addPolicy(policy);




    }

    @PostMapping("policy/create")
    public void savePolicy(@RequestBody RequestPolicy requestPolicy)
    {
        createPolicy(requestPolicy);
    }
}