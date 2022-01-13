package com.parcial2.Tarea;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarea")
public class TareaRestController {

    @Autowired
    private TareaRepository tareaRepository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Tarea> findAll() {
        return tareaRepository.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{tareaId}")
    public Tarea findOne(@PathVariable Long tareaId) {
        return tareaRepository.findOne(tareaId);
    }

}
