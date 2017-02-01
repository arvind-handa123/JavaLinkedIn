package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.LinkedInProfile;

@Repository("linkedInProfileRepository")
public interface LinkedInProfileRepository extends JpaRepository<LinkedInProfile, Long>{
	
	public List<LinkedInProfile> findTop15ByOrderByNumberOfRecommendationsDesc();
	public List<LinkedInProfile> findTop15ByOrderByNumberOfConnectionsDesc();
	@Query("select p from linkedinprofile p where TRIM(p.country) <> 'United States'")
	public List<LinkedInProfile> findNoUSCitizens();
	@Query("select p from linkedinprofile p where TRIM(p.country) = 'Canada' OR  TRIM(p.country) = 'Mexico'")
	public List<LinkedInProfile> findProfilesWithTNPossibility();


}
