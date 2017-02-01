package com.example;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.model.LinkedInProfile;
import com.example.repository.LinkedInProfileRepository;
import com.example.service.LinkedInProfileServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class LinkedInProfileServiceTest {

	@Mock
	private LinkedInProfileRepository linkedInProfileRepository;

	@InjectMocks
	private LinkedInProfileServiceImpl linkedInProfileService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllLinkedInProfiles() {
		List<LinkedInProfile> linkedInProfiles = new ArrayList<LinkedInProfile>();
		linkedInProfiles.add(new LinkedInProfile("www.google.com", "name1", "lastName1", "title1", "geographic area1", 55, 78, "role1", "industry1", "country1"));
		linkedInProfiles.add(new LinkedInProfile("www.google.com", "name2", "lastName2", "title2", "geographic area2", 55, 78, "role2", "industry2", "country2"));
		linkedInProfiles.add(new LinkedInProfile("www.google.com", "name3", "lastName3", "title3", "geographic area3", 55, 78, "role3", "industry3", "country3"));
		when(linkedInProfileRepository.findAll()).thenReturn(linkedInProfiles);
		List<LinkedInProfile> result = linkedInProfileService.getAllLinkedInProfiles();
		assertEquals(3, result.size());
	}
	
	@Test
	public void testSaveLinkedInProfile(){
		LinkedInProfile linkedInProfile = new LinkedInProfile("www.google.com", "name1", "lastName1", "title1", "geographic area1", 55, 78, "role1", "industry1", "country1");
		when(linkedInProfileRepository.save(linkedInProfile)).thenReturn(linkedInProfile);
		LinkedInProfile result = linkedInProfileService.saveLinkedInProfile(linkedInProfile);
		assertEquals("www.google.com", result.getPublicProfileURL());
		assertEquals("name1", result.getName());
		assertEquals("lastName1", result.getLastName());
		assertEquals("title1", result.getTitle());
		assertEquals("geographic area1", result.getGeographicArea());
		assertEquals(55, result.getNumberOfRecommendations());
		assertEquals(78, result.getNumberOfConnections());
		assertEquals("role1", result.getCurrentRole());
		assertEquals("industry1", result.getIndustry());
		assertEquals("country1", result.getCountry());
	}
	
	@Test
	public void testGetLinkedInProfileById(){
		LinkedInProfile linkedInProfile = new LinkedInProfile(1, "www.google.com", "name1", "lastName1", "title1", "geographic area1", 55, 78, "role1", "industry1", "country1");
		when(linkedInProfileRepository.findOne(1L)).thenReturn(linkedInProfile);
		LinkedInProfile result = linkedInProfileService.getLinkedInProfileById(1);
		assertEquals(1, result.getId());
		assertEquals("www.google.com", result.getPublicProfileURL());
		assertEquals("name1", result.getName());
		assertEquals("lastName1", result.getLastName());
		assertEquals("title1", result.getTitle());
		assertEquals("geographic area1", result.getGeographicArea());
		assertEquals(55, result.getNumberOfRecommendations());
		assertEquals(78, result.getNumberOfConnections());
		assertEquals("role1", result.getCurrentRole());
		assertEquals("industry1", result.getIndustry());
		assertEquals("country1", result.getCountry());
	}
}
