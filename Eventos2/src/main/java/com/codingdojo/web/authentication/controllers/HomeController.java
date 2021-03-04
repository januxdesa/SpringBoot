package com.codingdojo.web.authentication.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.web.authentication.models.User;
import com.codingdojo.web.authentication.services.UserService;
import com.codingdojo.web.authentication.validator.UserValidator;
import com.codingdojo.web.models.Event;
import com.codingdojo.web.models.State;
import com.codingdojo.web.models.UserHasEvent;
import com.codingdojo.web.repositories.UserHasEventRepository;
import com.codingdojo.web.service.EventService;
import com.codingdojo.web.service.StateService;
import com.codingdojo.web.service.UserHasEventService;


@Controller
public class HomeController {
    private final UserService userService;
    
 // NUEVO
    private final UserValidator userValidator;
    
    private final StateService stateService;
    
    private final EventService eventService;
    
    private final UserHasEventService userhaseventService;
    
    
    
    
    public HomeController(UserService userService, UserValidator userValidator,StateService stateService, EventService eventService, UserHasEventService userhaseventService) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.stateService = stateService;
        this.eventService = eventService;
        this.userhaseventService = userhaseventService;
    }
    
    /*
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    */
    
    @RequestMapping("/")
    public String loginRegister(@ModelAttribute("user") User user, BindingResult result,HttpSession session, Model model) {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }
 	
    	List<State> states = stateService.findAll();
    	model.addAttribute("states", states);
    	
    	
    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User  u = userService.findUserById(userIdL);
	    	model.addAttribute("user", u);
	    	
	       	
	    	return "redirect:/events";
    	}
    	else
    	{
    		
    		return "loginRegister.jsp";
    	}
    	
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
    //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "loginRegister.jsp";
    	}
    	else
    	{
    		User userR = userService.registerUser(user);
    		session.setAttribute("userId",userR.getId().toString() );
    		return "redirect:/events";
    	}
    	
    	
    }
    
    @RequestMapping(value="/login", method=RequestMethod.POST)
    public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
    //Si el usuario está autenticado, guarde su id de usuario en el objeto Session
    //sino agregue un mensaje de error y retorne a la página de inicio de sesión.
    
    	
    	
    	if (userService.authenticateUser(email,password))
		{
			User user = userService.findByEmail(email);
			session.setAttribute("userId",user.getId().toString() );
			return "redirect:/events";
		}
    	else
    	{
    		model.addAttribute("error", "Error: Usuario y/o Contraseña no válida. ");
    		return "loginRegister.jsp";
    	}
		   	
    }
    
    @RequestMapping("/events")
    public String home(@ModelAttribute("event") Event event, BindingResult result,HttpSession session, Model model) {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }
    	
    	
    	
    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User us = userService.findUserById(userIdL);
	    	model.addAttribute("user", us);
	    	
	    	List<State> st = stateService.findAll();
	    	model.addAttribute("states", st);
	    
	    	List<Event> eventos = eventService.findAll();
	    	model.addAttribute("eventos", eventos);
	    	
	    	//List<UserHasEvent> uhe = (List<UserHasEvent>) userhaseventService.findUserById(userIdL);
	    	
	    	List<UserHasEvent> uhe = userhaseventService.findAll();
	    	model.addAttribute("uhe", uhe);
	    	
	    	//uhe.get(0).getJoining().getUserEvent().getId()
	    	//uhe.get(0).getAsistente().getId()
	    	//uhe.get(0).getJoining().getId()
	    	
	    	return "homePage.jsp";
    	}
    	else
    	{
    		return "redirect:/";
    	}
    	
    }
    
    @RequestMapping(value="/events", method = RequestMethod.POST)
    public String eventPOST(@ModelAttribute("event") Event event, BindingResult result,HttpSession session, Model model) throws ParseException {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }
    	
    	
    	
    	
    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User user = userService.findUserById(userIdL);
	    	model.addAttribute("user", user);
	    	
	    	event.setUserEvent(user);
	    	
	    	//String fecha  = event.getDateEvent();
	    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    	
	    	//event.setDateEvent(dateFormat.parse(dateFormat.format(dateE)));
	    	Date d = dateFormat.parse( dateFormat.format( event.getDateEvent()));
	    	//Date d = 
	    	event.setDateEvent(d);
	    	eventService.Guardar(event);
	    	UserHasEvent uhe = new UserHasEvent();
	    	uhe.setAsistente(user);
	    	uhe.setJoining(event);
	    	userhaseventService.guardar(uhe);
	    	
	    	//System.out.println(event.getDateEvent());
	    	return "redirect:/events";
    	}
    	else
    	{
    		return "redirect:/";
    	}
    	
    }
    
    @RequestMapping("/events/{id}")
    public String eventId(@PathVariable("id") Long id,HttpSession session, Model model) throws ParseException {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }

    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User user = userService.findUserById(userIdL);
	    	model.addAttribute("user", user);
	    	
	    	List<Event> eventos  = eventService.findByEvent(id);
	    	model.addAttribute("eventos", eventos);
	    	
	    	
	    	List<UserHasEvent> uhe = userhaseventService.findByEvent(id);
	    	model.addAttribute("uhe", uhe.size());
	    	
	    	List<UserHasEvent> uhe2 = userhaseventService.findByEvent(id);
	    	model.addAttribute("uhe2", uhe2);
	    	
	    	
	    	
	    	//UserHasEvent uhe2 = new UserHasEvent();
	    	
	    	//uhe2.getAsistente().
	    		//uhe2.getJoining().getName().
	    	//uhe.size();
	    	//uhe.get(0).getAsistente().getEvents().size()
	    	
	    	return "show.jsp";
    	}
    	else
    	{
    		return "redirect:/";
    	}
    	
    }
    
    @RequestMapping("/events/{id}/join")
    public String eventIdJoin(@PathVariable("id") Long id,HttpSession session, Model model) throws ParseException {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }

    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User user = userService.findUserById(userIdL);
	    	model.addAttribute("user", user);
	    	
	    	
	    	Event evento = new Event();
	    	evento.setId(id);
	    	
	    	UserHasEvent uhe = new UserHasEvent();
	    	
	    	uhe.setAsistente(user);
	    	uhe.setJoining(evento);
	    	 
	    	
	    	
	    	userhaseventService.guardar(uhe);
	    	
	    	session.setAttribute("join", 1);
	    	
	    	
	    	return "redirect:/events";
    	}
    	else
    	{
    		return "redirect:/";
    	}
    	
    }
    
    
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
    	session.setAttribute("userId", "");
    	return "redirect:/";
    }
}