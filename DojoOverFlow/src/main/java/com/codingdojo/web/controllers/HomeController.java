package com.codingdojo.web.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.web.models.Answer;
import com.codingdojo.web.models.Question;
import com.codingdojo.web.models.Tag;
import com.codingdojo.web.models.TagQuestion;
import com.codingdojo.web.repositories.TagsQuestionsRepository;
import com.codingdojo.web.services.QuestionsServices;
import com.codingdojo.web.services.TagsQuestionsServices;
import com.codingdojo.web.services.TagsServices;
import com.sun.net.httpserver.Authenticator.Result;
import com.codingdojo.web.services.AnswersServices;


@Controller
public class HomeController {

	
	private final QuestionsServices questionsServices;
	private final TagsQuestionsServices tagsquestionsServices;
	private final TagsServices tagsServices;
	private final AnswersServices answersServices;
	
	
	public HomeController(QuestionsServices questionsServices, TagsQuestionsServices tagsquestionsServices, TagsServices tagsServices, AnswersServices answersServices)
	{
		this.questionsServices = questionsServices;
		this.tagsquestionsServices = tagsquestionsServices;
		this.tagsServices = tagsServices;
		this.answersServices = answersServices;
	}
	
	
	@RequestMapping(value= "/questions" , method = RequestMethod.GET)
	public String index(Model model) {
		
		/*
		List<Question> q 		= questionsServices.all();
		List<Tag>  t				= tagsServices.all();
		List<TagQuestion> tq 	= tagsquestionsServices.all();
		List<Answer> a  			= answersServices.all();
		*/
		//String newt= t.toString().replaceAll("\\[|\\]", "").replaceAll(", ",", ");
		
		/*
		 * String newT = "";
		
		for (int i=0; i< tq.size(); i++) {
			newT = newT +  tq.get(i); 
		}
		*/
		String newQ = "";
		
		ArrayList<String>  ListaQ  = new ArrayList<String>();
		ArrayList<String>  ListaT  = new ArrayList<String>();
		
		List<Question> q 		= questionsServices.all();
		List<TagQuestion> tq 	= tagsquestionsServices.all();
		String palabrasT = "";
		String palabraQ = "";
		for (int i=0;i<tq.size();i++)
		{
			palabraQ = tq.get(i).getQuestion().getQuestion();
			
			if (!ListaQ.contains(palabraQ)) {
				System.out.println(palabraQ);
				ListaQ.add(palabraQ);
				ListaT.add(palabrasT);
				System.out.println(palabrasT);
				palabrasT = "";
				
			}
			
			palabrasT  += tq.get(i).getTag().getSubjet();
			

		}
		ListaT.add(palabrasT);
		
		model.addAttribute("questions", ListaQ.toString());
		model.addAttribute("tags", ListaT.toString());
		
		return "tagsquestions.jsp";
	}
	
	@GetMapping(value= "/questions/new" )
	public String indexNewGet() {
		//model.addAttribute("person", new Form() );
		
		return "new.jsp";
	}
	
	@RequestMapping(value= "/questions/new" , method = RequestMethod.POST)
	public String indexNewPost(@RequestParam(name = "question") String question,@RequestParam(name = "subjet") String subjet,RedirectAttributes redirectAttributes  ) {
		
		
		if (question.equals(null) && subjet.equals(null)) { question=""; subjet=""; }
		
		
		if (question.equals("") && subjet.equals(""))
		{
			redirectAttributes.addFlashAttribute("msg", "Parámetros Vacíos");
			return "redirect:/questions/new";
		}
		else {
			tagsquestionsServices.createQT2(question, subjet);
			redirectAttributes.addFlashAttribute("msg", "Creado");
			return "redirect:/questions/new";
		}
			
		
	}
	
	@RequestMapping(value= "/questions/{id}" , method = RequestMethod.GET)
	public String indexId() {
		
		return "questionsid.jsp";
	}
	
	@RequestMapping(value= "/questions/borrar" , method = RequestMethod.GET)
	public String indexBorrar() {
		tagsquestionsServices.borrar();
		return "questionsid.jsp";
	}
	
	
	
	
}
