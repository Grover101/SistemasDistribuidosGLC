package com.biblioteca.libro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/libro")
public class LibroRestController {

    @Autowired
    private LibroRepository libroRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{libroId}")
    public Libro findOne(@PathVariable Long libroId) {
        return libroRepository.findOne(libroId);
    }
    
	// @RequestMapping(method = RequestMethod.POST)
    // public Libro add(@RequestBody Libro libro) {
    //     return libroRepository.save(libro);
    // }

	// @RequestMapping(method = RequestMethod.PUT)
    // public Libro update(@RequestBody Libro libro) {
    //     return libroRepository.save(libro);
    // }
	
	// @RequestMapping(method = RequestMethod.DELETE, value = "/{libroId}")
    // public void delete(@PathVariable Long libroId) {
    //     libroRepository.delete(libroId);
    // }
	
}

