package com.codingdojo.web.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.web.models.Tag;
import com.codingdojo.web.repositories.TagsRepository;

@Service
public class TagsServices {

private final TagsRepository tagsRepository;
	
	public TagsServices(TagsRepository tagsRepository) {
		this.tagsRepository = tagsRepository;
	}
	
	public List<Tag> all() {
        return tagsRepository.findAll();
    }
}
