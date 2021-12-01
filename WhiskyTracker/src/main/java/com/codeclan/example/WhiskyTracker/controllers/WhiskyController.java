package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

//    @GetMapping(value="/whiskies")
//    public ResponseEntity<List<Whisky>> findByYear(
//            @RequestParam(name="year", required = false) Integer year){
//        if (year != null){
//            return new ResponseEntity<>(whiskyRepository.findByYear(year), HttpStatus.OK);
//    }
//        return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
//    }

    @GetMapping(value="/whiskies")
    public ResponseEntity<List<Whisky>> findByAgeAndDistilleryName(
            @RequestParam(name="age") Integer year, @RequestParam(name="distillery") String distillery){
        return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(year, distillery), HttpStatus.OK);
    }




}
