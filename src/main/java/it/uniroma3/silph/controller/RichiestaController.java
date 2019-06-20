package it.uniroma3.silph.controller;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import it.uniroma3.silph.controller.validator.RichiestaValidator;
import it.uniroma3.silph.model.Foto;
import it.uniroma3.silph.model.Richiesta;
import it.uniroma3.silph.service.FotoService;
import it.uniroma3.silph.service.RichiestaService;

@Controller
@SessionAttributes("carrello")
public class RichiestaController {

	@Autowired
	private RichiestaService richiestaService;
	
	@Autowired
	private FotoService fotoService;

	@Autowired
	private RichiestaValidator validator;
	
	@ModelAttribute("carrello")
	public List<Foto> cart(Model model) {
		return new LinkedList<Foto>();
	}


	@RequestMapping("/richieste")
	public String richieste(Model model) {
		model.addAttribute("richieste", this.richiestaService.findAll());
		return "richiestaList";
	}

	@RequestMapping("/addRichiesta")
	public String addRichiesta(Model model) {
		model.addAttribute("richiesta", new Richiesta());
		return "richiestaForm";
	}
	

	@RequestMapping(value = "/addCarrello", method = RequestMethod.POST)
	public String addCarrello(@ModelAttribute("carrello") List<Foto> carrello,
			@RequestParam(value = "idfotos", required = false) Long[] idfotos, BindingResult bindingResult,
			Model model) {
		System.out.println(idfotos.length);
		if (idfotos != null) {
			Foto foto = null;
			for (int i = 0; i < idfotos.length; i++) {
					foto = fotoService.findById(idfotos[i]);
				if (foto != null && !carrello.contains(foto)) {
					carrello.add(foto);
				}
			}
			System.out.println(carrello.size());
			for (int i = 0; i < carrello.size(); i++) {
				System.out.println(carrello.get(i).getTitolo());
			}

		}

		return "showCarrello";
	}
	
	@RequestMapping(value = "/removeCarrello", method = RequestMethod.POST)
	public String removeCarrello(@ModelAttribute("carrello") List<Foto> carrello,
			@RequestParam(value = "idfotos", required = false) Long[] idfotos,
			Model model) {
		if (idfotos != null) {
			Foto foto = null;
			for (int i = 0; i < idfotos.length; i++) {
				if (fotoService.findById(idfotos[i]) != null) {
					foto = fotoService.findById(idfotos[i]);
					carrello.remove(foto);
				}
			}
		}
		return "showCarrello";
	}


	@RequestMapping(value = "/richiesta/{id}", method = RequestMethod.GET)
	public String getRichiesta(@PathVariable("id") Long id, Model model) {
		model.addAttribute("richiesta", this.richiestaService.findById(id));
		return "showRichiesta";
	}

	@RequestMapping(value = "/richiesta", method = RequestMethod.POST)
	public String newRichiesta(@Valid @ModelAttribute("richiesta") Richiesta richiesta, BindingResult bindingResultRichiesta, @ModelAttribute("carrello") List<Foto> carrello, Model model, HttpServletRequest request,
		    SessionStatus status) {
		System.out.println(richiesta.getEmail()+richiesta.getCognome()+richiesta.getNome());
		this.validator.validate(richiesta, bindingResultRichiesta);
		if (!bindingResultRichiesta.hasErrors()) {
			richiesta.setFotos(carrello);
			this.richiestaService.save(richiesta);

			status.setComplete();
			 
			model.addAttribute("richieste", this.richiestaService.findAll());
			
			return "richiestaList";
		}

		return "richiestaForm";
	}
}
