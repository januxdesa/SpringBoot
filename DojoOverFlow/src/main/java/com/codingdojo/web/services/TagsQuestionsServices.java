package com.codingdojo.web.services;


import java.util.List;

import org.springframework.stereotype.Service;
import com.codingdojo.web.models.Question;
import com.codingdojo.web.models.Tag;
import com.codingdojo.web.models.TagQuestion;
import com.codingdojo.web.repositories.QuestionsRepository;
import com.codingdojo.web.repositories.TagsQuestionsRepository;
import com.codingdojo.web.repositories.TagsRepository;

@Service
public class TagsQuestionsServices {
	
	private final TagsQuestionsRepository tagsquestionsRepository;
	private final QuestionsRepository questionsRepository;
	private final TagsRepository tagsRepository;
	
	
	
	public TagsQuestionsServices(TagsQuestionsRepository tagsquestionsRepository, 
			QuestionsRepository questionsRepository,
			TagsRepository tagsRepository) {
		this.tagsquestionsRepository = tagsquestionsRepository;
		this.questionsRepository = questionsRepository;
		this.tagsRepository = tagsRepository;
	}
	
	public List<TagQuestion> all() {
        return tagsquestionsRepository.findAll();
    }
	
	public void createQT(String questionIn, String subjetIn) {
		// TODO Auto-generated method stub
		Question question = new Question(questionIn);
		
		questionsRepository.save(question);

		String[] newtags =  subjetIn.split(",");
		
		for (int i=0;i< newtags.length;i++ )
		{
			Tag tag = new Tag(newtags[i]);
			tagsRepository.save(tag);
			
			TagQuestion tagquestion =  new TagQuestion();
			
			tagquestion.setQuestion(question);
			tagquestion.setTag(tag);
			
			tagsquestionsRepository.save(tagquestion);
			
		}
		
		
		
	}
	
	public void createQT2(String questionIn, String subjetIn) {
		// TODO Auto-generated method stub
		Question question = new Question(questionIn);
			
		String[] newtags =  subjetIn.split(",");
		
		for (int i=0; i<newtags.length;i++) {
		   
			Tag tag = new Tag(newtags[i]);	
			tagsRepository.save(tag);
			
		}
	    List<Tag> ListTmp = tagsRepository.findAll(); 
		ListTmp.clear();
		ListTmp  = newTags(newtags, ListTmp);
		question.setTag(ListTmp);
		questionsRepository.save(question);
	
	}
	
	public void borrar() {
		questionsRepository.deleteAll();
		tagsquestionsRepository.deleteAll();
		tagsRepository.deleteAll();
		
	}
	
	public String findbyT(Long id1) {
		
		Long size  = tagsquestionsRepository.count();
		TagQuestion tq = new TagQuestion();
		
		tq.getQuestion().getQuestion();
		tq.getTag().getId();
			
		return null;
	}

	
	public List<Tag> newTags(String[] newTags, List<Tag> ListTmp) {
		
		List<Tag> allList  =  tagsRepository.findAll();
  		
  		if (allList.size()!=0) {	
  			
  			for (int i= allList.size()- newTags.length ; i < allList.size();i++) {	
  	  			ListTmp.add(allList.get(i));
  	  		}	
  			
  		}
		
  		return ListTmp; 
	}
	
}
