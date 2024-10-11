package com.example.TrainingCenterProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TrainingCenterProject.Entity.TrainingCenter;
import com.example.TrainingCenterProject.Service.TrainingCenterService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/trainingCenters")
public class TrainingCenterController {
	
	@Autowired
	private TrainingCenterService trainingCenterService;

	//To add new training center in database
	@PostMapping
	public ResponseEntity<?> createTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
		return new ResponseEntity<>(trainingCenterService.createTrainingCenter(trainingCenter),HttpStatus.CREATED);
	}
	
	//To get all list og training centers
	@GetMapping
	public ResponseEntity<?> getAllTrainingCenters(){
		return new ResponseEntity<>(trainingCenterService.getAllTrainingCenters(),HttpStatus.OK);
	}
}
