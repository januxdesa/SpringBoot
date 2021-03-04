package com.codingdojo.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.web.authentication.models.User;
import com.codingdojo.web.authentication.repositories.UserRepository;
import com.codingdojo.web.models.Event;
import com.codingdojo.web.models.UserHasEvent;
import com.codingdojo.web.repositories.EventRepository;
import com.codingdojo.web.repositories.UserHasEventRepository;

@Service
public class UserHasEventService {
	
	private final UserHasEventRepository userhaseventRepository;
	private final EventRepository eventRepository;
	private final UserRepository userRepository;
	
	
	public UserHasEventService(UserHasEventRepository userhaseventRepository, EventRepository eventRepository, UserRepository userRepository) {
		this.userhaseventRepository = userhaseventRepository;
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
	}

	public void guardar(UserHasEvent uhe) {
		// TODO Auto-generated method stub
		userhaseventRepository.save(uhe);
	}

	public List<UserHasEvent> findAll() {
		// TODO Auto-generated method stub
		return (List<UserHasEvent>) userhaseventRepository.findAll();
	}

	public List<UserHasEvent> findByEvent(Long id) {
		// TODO Auto-generated method stub
		List<UserHasEvent> listFull = (List<UserHasEvent>) userhaseventRepository.findAll();
		
		List<UserHasEvent> listId =  (List<UserHasEvent>) userhaseventRepository.findAll();
		listId.clear();
		
		
		for (var i=0; i<listFull.size();i++) {
			
			if (listFull.get(i).getJoining().getId() == id) {
				
				listId.add(listFull.get(i));
			
			}
			
		}
		
		return listId;
	}

	public boolean findUserExist(Long id, Long ide) {
		// TODO Auto-generated method stub
		
		 List<UserHasEvent> listUhe = (List<UserHasEvent>) userhaseventRepository.findAll() ;
		 List<UserHasEvent> listTmp = (List<UserHasEvent>) userhaseventRepository.findAll() ;
		 listTmp.clear();
		 
		 
		 
		 for(var i=0; i < listUhe.size();i++) {
			 if (listUhe.get(i).getAsistente().getId()== id && listUhe.get(i).getJoining().getId()==ide) {
				 //listTmp.add(listUhe.get(i));
				 return true;
			 }
		 }
		 
		return false;
	}



	public List<UserHasEvent> findUserById(Long userIdL) {
		// TODO Auto-generated method stub
		List<UserHasEvent> listUhe = (List<UserHasEvent>) userhaseventRepository.findAll();
		List<UserHasEvent> listTmp = (List<UserHasEvent>) userhaseventRepository.findAll();
		listTmp.clear();
		
		//UserHasEvent uhe = userhaseventService.findUserById(userIdL);
		
		
		for(var i=0; i < listUhe.size();i++) {
			 if (listUhe.get(i).getAsistente().getId()  == userIdL ) {
				 listTmp.add(listUhe.get(i));
			 }
		 }
		
		return listTmp;
	}

	
	//public List<UserHasEvent> findById (Event event){
		
		//List<UserHasEvent>  listuhe = userhaseventRepository.findByEventId(event);
		
	//	return listuhe;
	//}
	
	

}
