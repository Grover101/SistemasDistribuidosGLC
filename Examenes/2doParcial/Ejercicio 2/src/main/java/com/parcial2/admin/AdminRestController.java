package com.parcial2.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

import com.parcial2.Tarea.Tarea;
import com.parcial2.Tarea.TareaRepository;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminRestController {

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

    @RequestMapping(method = RequestMethod.POST)
    public Tarea add(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Tarea update(@RequestBody Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{tareaId}")
    public void delete(@PathVariable Long tareaId) {
        tareaRepository.delete(tareaId);
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/{tareaId}")
    public void patch(@PathVariable Long tareaId, @RequestBody Map<String, Object> re) {
        // tareaRepository.update
    }

}
