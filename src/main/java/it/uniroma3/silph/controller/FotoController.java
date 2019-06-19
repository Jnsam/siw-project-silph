package it.uniroma3.silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.uniroma3.silph.service.FotoService;

@Controller
public class FotoController {
	@Autowired
	private FotoService fotoService;
	
    @RequestMapping("/fotos")
    public String fotos(Model model) {
        model.addAttribute("fotos", this.fotoService.findAll());
        return "fotoList";
    }
    
}
