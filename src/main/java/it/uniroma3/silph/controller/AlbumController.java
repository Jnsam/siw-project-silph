package it.uniroma3.silph.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.silph.model.Album;
import it.uniroma3.silph.service.AlbumService;

@Controller
public class AlbumController {
	
	@Autowired
	private AlbumService albumService;

    @RequestMapping("/albums")
    public String albums(Model model) {
        model.addAttribute("albums", this.albumService.findAll());
        return "albumList";
    }
    
    @RequestMapping("/addAlbum")
    public String addCustomer(Model model) {
        model.addAttribute("album", new Album());
        return "albumForm";
    }

    @RequestMapping(value = "/album/{id}", method = RequestMethod.GET)
    public String getAlbum(@PathVariable("id") Long id, Model model) {
        model.addAttribute("album", this.albumService.findById(id));
    	return "showAlbum";
    }
}
