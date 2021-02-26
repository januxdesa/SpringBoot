package com.codingdojo.web.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.codingdojo.web.models.License;
import com.codingdojo.web.models.Person;
import com.codingdojo.web.repositories.LicenseRepository;

@Service
public class LicenseServices {

	private final LicenseRepository licenseRepository;

	
	public LicenseServices(LicenseRepository licenseRepository) {
		this.licenseRepository = licenseRepository;
	}

	public void createlicense(License license) {
		// TODO Auto-generated method stub
		String numberF = String.format("%06d", Contar());
		license.setNumber(numberF);
		
		licenseRepository.save(license);
		
	}
	
	public Long Contar() {
		return licenseRepository.count();
	}
	
	public boolean findPerson(Person person) {
		List<License> existe = licenseRepository.findByPerson(person);
		
		if (existe.isEmpty())
		return true;
		else
		return false;
	}
	
	//public String findLicense(License license) {
		
	//	findPerson(license.getPerson())
	
	//	return 
	//}
	

	
	
	 

	 
}
