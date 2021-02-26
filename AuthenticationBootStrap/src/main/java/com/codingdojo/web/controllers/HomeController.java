package com.codingdojo.web.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.web.authentication.validator.UserValidator;
import com.codingdojo.web.models.User;
import com.codingdojo.web.services.UserService;


@Controller
public class HomeController {
    private final UserService userService;
    
 // NUEVO
    private final UserValidator userValidator;
    
    public HomeController(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }
    
    @RequestMapping("/registration")
    public String registerForm(@ModelAttribute("user") User user) {
        return "registrationPage.jsp";
    }
    @RequestMapping("/login")
    public String login() {
        return "loginPage.jsp";
    }
    
    @RequestMapping(value="/registration", method=RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    //si el resultado tiene errores, retornar a la página de registro (no se preocupe por las validaciones por ahora)
    //si no, guarde el usuario en la base de datos, guarde el id del usuario en el objeto Session y redirija a /home
    	userValidator.validate(user, result);
    	if (result.hasErrors()) {
    		return "registrationPage.jsp";
    	}
    	else
    	{
    		User userR = userService.registerUser(user);
    		session.setAttribute("userId",userR.getId().toString() );
    		return "redirect:/home";
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
			return "redirect:/home";
		}
    	else
    	{
    		model.addAttribute("error", "Error: Usuario y/o Contraseña no válida. ");
    		return "loginPage.jsp";
    	}
		   	
    }
    
    @RequestMapping("/home")
    public String home(HttpSession session, Model model) {
        //Obtener el usuario desde session, guardarlo en el modelo y retornar a la página principal
    	if (session.getAttribute("userId")==null ) { session.setAttribute("userId", ""); }
    	
    	
    	if (!session.getAttribute("userId").equals("") ) { 
	    	String userId = (String) session.getAttribute("userId");
	    	Long userIdL = Long.parseLong(userId);
	    	User user = userService.findUserById(userIdL);
	    	model.addAttribute("user", user);
	    	return "homePage.jsp";
    	}
    	else
    	{
    		return "redirect:/login";
    	}
    	
    }
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        // invalidar la sesión
        // redireccionar a la página de inicio de sesión.
    	session.setAttribute("userId", "");
    	return "redirect:/login";
    }
}