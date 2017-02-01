package com.example.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.model.LinkedInProfile;
import com.example.service.LinkedInProfileService;

@Controller
public class LinkedInProfileController {

	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(LinkedInProfileController.class);
	private final String FAIL_UPLOAD_MESSAGE = "The file was not uploaded correctly, please verify your input file or contact the admin site";
	private final String NO_VALID_RECORDS  = "The file does't include valid record, please verify the input file";
		
	@Autowired
	private LinkedInProfileService linkedInProfileService;

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView goHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "");
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public ModelAndView uploadFile(@RequestParam("file") MultipartFile file) {
		logger.info("File name:" + file.getOriginalFilename());
		logger.info("File size:" + file.getSize());
		ModelAndView modelAndView = new ModelAndView();
		try {
			//Remove the current information stored in the database
			linkedInProfileService.deleteAllLinkedInProfiles();
			
			//Save the new informaton from the file uploaded
			int profilesUploaded = linkedInProfileService.saveProfilesFromFile(file);
			
			if (profilesUploaded >0){
				//Get the information from the database
				List<LinkedInProfile> bestNatonalityLinkedInProfiles = linkedInProfileService.getBestCountryLinkedInProfiles();
				List<LinkedInProfile> bestRecommendationsLinkedInProfiles = linkedInProfileService.getBestRecommendationLinkedInProfiles();
				List<LinkedInProfile> bestConnectionsLinkedInProfiles = linkedInProfileService.getBestConnectionsLinkedInProfiles();
				List<LinkedInProfile> allLinkedInProfiles = linkedInProfileService.getAllLinkedInProfiles();
				List<LinkedInProfile> profilesWithTNPossibility = linkedInProfileService.getProfilesWithTNPossibility();
	
				//Set the object in the view
				modelAndView.addObject("bestNatonalityLinkedInProfiles", bestNatonalityLinkedInProfiles);
				modelAndView.addObject("bestRecommendationsLinkedInProfiles", bestRecommendationsLinkedInProfiles);
				modelAndView.addObject("bestConnectionsLinkedInProfiles", bestConnectionsLinkedInProfiles);
				modelAndView.addObject("allLinkedInProfiles", allLinkedInProfiles);
				modelAndView.addObject("profilesWithTNPossibility", profilesWithTNPossibility);
				
				//Set the view where the information will be displayed
				modelAndView.setViewName("profiles");
			}else{
				modelAndView.setViewName("index");
				modelAndView.addObject("message", NO_VALID_RECORDS);
			}
			
		} catch (IOException e) {
			modelAndView.setViewName("index");
			modelAndView.addObject("message", FAIL_UPLOAD_MESSAGE);
			logger.error(e.getMessage());
		}
		
		

		

		return modelAndView;
	}
	
	
}
