package com.douglas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douglas.repository.CicloFaturaRepository;


@Service
public class CicloFaturaService {

    @Autowired
    private CicloFaturaRepository cicloFaturaRepository;

}
