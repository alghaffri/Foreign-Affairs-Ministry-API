package com.example.demo.Controller;

import com.example.demo.Models.Policy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
    private final PolicyService policyService;

    @Autowired
    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

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

