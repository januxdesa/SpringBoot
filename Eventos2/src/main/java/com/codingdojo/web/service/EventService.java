package com.codingdojo.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Event;
import com.codingdojo.web.models.UserHasEvent;
import com.codingdojo.web.repositories.EventRepository;

@Service
public class EventService {

	private final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public void Guardar(Event event) {
		// TODO Auto-generated method stub
		eventRepository.save(event);
	}

	public List<Event> findAll() {
		// TODO Auto-generated method stub
		return eventRepository.findAll();
	}

	public List<Event> findStateAll(String stateUser) {
		// TODO Auto-generated method stub
		List<Event> listEvent = eventRepository.findAll();
		List<Event> listTemp = eventRepository.findAll();
		listTemp.clear();
		for (var i =0 ; i < listEvent.size() ; i++)
		{
			if (stateUser.equals(listEvent.get(i).getStateEvent().toString())) {
				listTemp.add(listEvent.get(i));
			}
		}
		
		return listTemp;
	}

	public List<Event> findNotStateAll(String stateUser) {
		// TODO Auto-generated method stub
		List<Event> listEvent = eventRepository.findAll();
		List<Event> listTemp = eventRepository.findAll();
		listTemp.clear();
		for (var i =0 ; i < listEvent.size() ; i++)
		{
			if (!stateUser.equals(listEvent.get(i).getStateEvent().toString())) {
				listTemp.add(listEvent.get(i));
			}
		}
		
		return listTemp;
	}

	public List<Event> findByEvent(Long id) {
		// TODO Auto-generated method stub
	// TODO Auto-generated method stub
		
		List<Event> listFull = eventRepository.findAll();
		
		List<Event> listId =  eventRepository.findAll();
		listId.clear();
		
		
		for (var i=0; i<listFull.size();i++) {
			
			if (listFull.get(i).getId()== id) {
				
				listId.add(listFull.get(i));
			
			}
			
		}
		
		return listId;
	}

	

	

	

}
