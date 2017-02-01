package com.example.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.model.LinkedInProfile;
import com.example.repository.LinkedInProfileRepository;

@Service("linkedInProfileService")
public class LinkedInProfileServiceImpl implements LinkedInProfileService {
	
	private final static org.slf4j.Logger logger = LoggerFactory
			.getLogger(LinkedInProfileServiceImpl.class);
	
	@Autowired
	private LinkedInProfileRepository linkedInProfileRepository;
	

	@Override
	public LinkedInProfile saveLinkedInProfile(LinkedInProfile linkedInProfile) {
		return linkedInProfileRepository.save(linkedInProfile);
		
	}

	@Override
	public List<LinkedInProfile> getAllLinkedInProfiles() {
		return linkedInProfileRepository.findAll();
	}

	@Override
	public LinkedInProfile getLinkedInProfileById(long id) {
		return linkedInProfileRepository.findOne(id);
	}

	@Override
	public void deleteAllLinkedInProfiles() {
		linkedInProfileRepository.deleteAll();
		
	}

	@Override
	public int saveProfilesFromFile(MultipartFile file) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
		String line = null;
		int count = 0;
		while ((line = br.readLine()) != null) {
			String[] values = line.split("\\|");
			if (values.length == 10){
				logger.info("Saving in the database: " + line);
				int recommendations = values[5].trim().length()>0?Integer.parseInt(values[5].trim()):0;
				int connections = values[6].trim().length()>0?Integer.parseInt(values[6].trim()):0;
				LinkedInProfile linkedInProfile = new LinkedInProfile(values[0], values[1], values[2], values[3], values[4], recommendations, connections, values[7], values[8], values[9]);
				linkedInProfileRepository.save(linkedInProfile);
				count++;
			}
		}
	 
		br.close();
		return count;
	}

	@Override
	public List<LinkedInProfile> getBestRecommendationLinkedInProfiles() {
		return linkedInProfileRepository.findTop15ByOrderByNumberOfRecommendationsDesc();
	}

	@Override
	public List<LinkedInProfile> getBestConnectionsLinkedInProfiles() {
		return linkedInProfileRepository.findTop15ByOrderByNumberOfConnectionsDesc();
	}

	@Override
	public List<LinkedInProfile> getBestCountryLinkedInProfiles() {
		return linkedInProfileRepository.findNoUSCitizens();
	}

	@Override
	public List<LinkedInProfile> getProfilesWithTNPossibility() {
		return linkedInProfileRepository.findProfilesWithTNPossibility();
	}

}
