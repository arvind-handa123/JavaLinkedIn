package com.example.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.model.LinkedInProfile;

public interface LinkedInProfileService {
	
	public List<LinkedInProfile> getAllLinkedInProfiles();
	public List<LinkedInProfile> getBestRecommendationLinkedInProfiles();
	public List<LinkedInProfile> getBestConnectionsLinkedInProfiles();
	public List<LinkedInProfile> getBestCountryLinkedInProfiles();
	public List<LinkedInProfile> getProfilesWithTNPossibility();
	public LinkedInProfile getLinkedInProfileById(long id);
	
	public LinkedInProfile saveLinkedInProfile(LinkedInProfile linkedInProfile);
	public void deleteAllLinkedInProfiles();
	public int saveProfilesFromFile(MultipartFile file) throws IOException;

}
