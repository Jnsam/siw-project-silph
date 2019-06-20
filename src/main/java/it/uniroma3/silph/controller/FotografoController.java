package it.uniroma3.silph.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.silph.controller.validator.FotoValidator;
import it.uniroma3.silph.model.Fotografo;
import it.uniroma3.silph.service.FotografoService;

@Controller
public class FotografoController {
	
	@Autowired
	private FotografoService fotografoService;
	
	@Autowired
	private FotoValidator validator;
	
    @RequestMapping("/fotografi")
    public String fotografi(Model model) {
        model.addAttribute("fotografi", this.fotografoService.findAll());
        return "fotografoList";
    }
    
    @RequestMapping("/addFotografo")
    public String addFotografo(Model model) {
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

    @RequestMapping(value = "/admin/fotografo", method = RequestMethod.POST)
    public String newFotografo(@Valid @ModelAttribute("fotografo") Fotografo fotografo,  BindingResult bindingResult,
    									Model model) {
        this.validator.validate(fotografo, bindingResult);
        
        if (this.fotografoService.alreadyExists(fotografo)) {
            model.addAttribute("exists", "Fotografo already exists");
            return "fotografoForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.fotografoService.save(fotografo);
                model.addAttribute("fotografos", this.fotografoService.findAll());
                return "fotografoList";
            }
        }
        return "fotografoForm";
    }
}
