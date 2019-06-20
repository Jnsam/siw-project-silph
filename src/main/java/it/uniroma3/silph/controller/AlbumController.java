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

import it.uniroma3.silph.controller.validator.AlbumValidator;
import it.uniroma3.silph.model.Album;
import it.uniroma3.silph.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;
	
	@Autowired
	private AlbumValidator validator;

    @RequestMapping("/albums")
    public String albums(Model model) {
        model.addAttribute("albums", this.albumService.findAll());
        return "albumList";
    }
    
    @RequestMapping("/addAlbum")
    public String addAlbum(Model model) {
        model.addAttribute("album", new Album());
        return "albumForm";
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public String getAlbum(@PathVariable("id") Long id, Model model) {
        model.addAttribute("album", this.albumService.findById(id));
    	return "showAlbum";
    }
    
    @RequestMapping(value = "/admin/album", method = RequestMethod.POST)
    public String newAlbum(@Valid @ModelAttribute("album") Album album, BindingResult bindingResult, 
    									Model model) {
        this.validator.validate(album, bindingResult);
        
        if (this.albumService.alreadyExists(album)) {
            model.addAttribute("exists", "Album already exists");
            return "albumForm";
        }
        else {
            if (!bindingResult.hasErrors()) {
                this.albumService.save(album);
                model.addAttribute("albums", this.albumService.findAll());
                return "albumList";
            }
        }
        return "albumForm";
    }
}
