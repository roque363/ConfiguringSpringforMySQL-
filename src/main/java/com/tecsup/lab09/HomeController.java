package com.tecsup.lab09;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tecsup.lab09.crud.bean.Usuario;
import com.tecsup.lab09.crud.dao.UsuarioDAO;
import com.tecsup.lab09.crud.dao.UsuarioDAOImpl;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	//Lista la tabla Usuarios de la base de datos FindBank
	@RequestMapping(value = "/lista", method = RequestMethod.POST)
	public void listUsuario(@ModelAttribute("SpringWeb") Usuario usuario, ModelMap model) {
		UsuarioDAO dao = new UsuarioDAOImpl();
		for (Usuario item : dao.findAll()) {
			System.out.println(item.getCod()+" Nombre: "+item.getNombre()+" Correo: "+item.getCorreo()+" Password: "+item.getPass()); 
		};		
	}
	
}
