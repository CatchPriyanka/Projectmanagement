package com.project.managment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


@SpringBootApplication
public class ProjectmanagmentApplication {

	public static void main(String[] args) throws ParseException {

		SpringApplication.run(ProjectmanagmentApplication.class, args);
		ProjectmanagmentApplication obj =new ProjectmanagmentApplication();
		String date1 = "23/08/2022";
		int estimation = 1;
		String response =obj.validateProjectDate(date1,estimation);
		System.out.println(response);
	}

	public String validateProjectDate(String inputDate,int estimatedDuration) throws ParseException {

		String output =null;
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		Date today = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(today);
		cal.add(Calendar.MONTH, estimatedDuration);
		String modifiedDate = DateFor.format(cal.getTime());
		Date actualEstimatedDate = DateFor.parse(modifiedDate);
		Date input = DateFor.parse(inputDate);
		if (actualEstimatedDate.compareTo(input) < 0 || actualEstimatedDate.compareTo(input) == 0) {
			output = "The Project Could be Completed with in the SpecifiedTimeLine";
		} else {
			output = "The Project Could not  be Completed with in the SpecifiedTimeLine,Please Increase the timeline!!!";
		}
		return output;
	}
}




