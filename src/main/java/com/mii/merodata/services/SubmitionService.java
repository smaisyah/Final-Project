package com.mii.merodata.services;

import org.springframework.stereotype.Service;

import com.mii.merodata.repositories.SubmitionRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SubmitionService {
    private SubmitionRepository submitionRepository;
    
}
