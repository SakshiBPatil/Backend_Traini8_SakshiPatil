package com.example.TrainingCenterProject.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TrainingCenterProject.Entity.TrainingCenter;
import com.example.TrainingCenterProject.Repository.TrainingCenterRepository;

@Service
public class TrainingCenterService {
	
	@Autowired
	private TrainingCenterRepository trainingCenterRepository;
	
	//To add new training center 
	public TrainingCenter createTrainingCenter(TrainingCenter trainingCenter) {
		 return trainingCenterRepository.save(trainingCenter);
	}
	
	//To get all Training centers list
	public List<TrainingCenter> getAllTrainingCenters(){
		return trainingCenterRepository.findAll();
	}

}
