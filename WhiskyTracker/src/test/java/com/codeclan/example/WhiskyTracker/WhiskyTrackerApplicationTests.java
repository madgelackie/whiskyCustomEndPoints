package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canFindWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findByYear(1991);
		assertEquals(1, found.size());
	}

	@Test
	public void canFindDistilleriesByRegion(){
		List<Distillery> found = distilleryRepository.findByRegion("Speyside");
		assertEquals("Speyside", found.get(0).getRegion());
	}

	@Test
	public void canFindWhiskyByDistilleryAndAge(){
		List<Whisky> found = whiskyRepository.findByAgeAndDistilleryName(12, "Old Pulteney");
		assertEquals(1, found.size());
	}

	@Test
	public void canFindWhiskyByDistilleryRegion(){
		List<Whisky> found = whiskyRepository.findByDistilleryRegion("Speyside");
		assertEquals("Speyside", found.get(0).getDistillery().getRegion());
	}

	@Test
	public void canFindDistilleryByWhiskysAge(){
		List<Distillery> found = distilleryRepository.findByWhiskiesAge(12);
		assertEquals(6, found.size());
	}

}
