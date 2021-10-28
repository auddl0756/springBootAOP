package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {
    @Override
    public int add(String num1, String num2) throws Exception {
        return Integer.parseInt(num1) + Integer.parseInt(num2);
    }
}
