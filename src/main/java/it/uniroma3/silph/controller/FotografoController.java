package it.uniroma3.silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.silph.model.Fotografo;
import it.uniroma3.silph.service.FotografoService;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
    @RequestMapping("/fotografi")
    public String fotografi(Model model) {
        model.addAttribute("fotografi", this.fotografoService.findAll());
        return "fotografoList";
    }
    
    @RequestMapping("/addFotografo")
    public String addCustomer(Model model) {
        model.addAttribute("fotografo", new Fotografo());
        return "fotografoForm";
    }

    @RequestMapping(value = "/fotografo/{id}", method = RequestMethod.GET)
    public String getFotografo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("fotografo", this.fotografoService.findById(id));
    	return "showFotografo";
    }
    
	@RequestMapping("/fotografo/fotos/{id}")
	public String fotografoFotos(@PathVariable("id") Long id, Model model) {
		model.addAttribute("fotos", this.fotografoService.findById(id).getFotos());
		return "fotoList";
	}

}
