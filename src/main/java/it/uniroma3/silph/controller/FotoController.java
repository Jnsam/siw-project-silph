package it.uniroma3.silph.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import it.uniroma3.silph.model.Foto;
import it.uniroma3.silph.service.FotoService;

@Controller
@SessionAttributes("carrello")
public class FotoController {

	@Autowired
	private FotoService fotoService;

	@ModelAttribute("carrello")
	public List<Foto> cart(Model model) {
		return new LinkedList<Foto>();
	}

	@RequestMapping("/fotos")
	public String fotos(Model model) {
		model.addAttribute("fotos", this.fotoService.findAll());
		return "fotoList";
	}

	@RequestMapping("/addFoto")
	public String addCustomer(Model model) {
		model.addAttribute("foto", new Foto());
		return "fotoForm";
	}

	@RequestMapping(value = "/addCarrello", method = RequestMethod.POST)
	public String addCarrello(@ModelAttribute("carrello") List<Foto> carrello,
			@RequestParam(value = "idfotos", required = false) Long[] idfotos, BindingResult bindingResult,
			Model model) {
		System.out.println(idfotos.length);
		if (idfotos != null) {
			Foto foto = null;
			for (int i = 0; i < idfotos.length; i++) {

				if (fotoService.findById(idfotos[i]) != null) {
					foto = fotoService.findById(idfotos[i]);
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
			@RequestParam(value = "idfotos", required = false) Long[] idfotos, BindingResult bindingResult,
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

}
