package it.uniroma3.silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.silph.model.Richiesta;
import it.uniroma3.silph.service.RichiestaService;

@Controller
public class RichiestaController {
	
	@Autowired
	private RichiestaService richiestaService;

    @RequestMapping("/richieste")
    public String richieste(Model model) {
        model.addAttribute("richieste", this.richiestaService.findAll());
        return "richiestaList";
    }
    
    @RequestMapping("/addRichiesta")
    public String addCustomer(Model model) {
        model.addAttribute("richiesta", new Richiesta());
        return "richiestaForm";
    }

    @RequestMapping(value = "/richiesta/{id}", method = RequestMethod.GET)
    public String getRichiesta(@PathVariable("id") Long id, Model model) {
        model.addAttribute("richiesta", this.richiestaService.findById(id));
    	return "showRichiesta";
    }
}
