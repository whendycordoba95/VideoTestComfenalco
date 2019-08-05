package co.com.prueba.sorteo.controller;

import co.com.prueba.sorteo.model.entity.Personas;
import co.com.prueba.sorteo.services.PersonasServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class PersonaController {

    @Autowired
    public PersonasServices personasServices;

    @GetMapping(value = "/personas")
    public List<Personas> getAll() { return  personasServices.getAll();}

    @GetMapping(value ="/personas/{numeroDocumento}")
    public Personas getAllByNumeroDocumento(@PathVariable String numeroDocumento) {
        return personasServices.getAllByNumeroDocumento(numeroDocumento);
    }

    @PostMapping(value ="/personas")
    public Personas create(@RequestBody Personas newPersonas)
    {
        newPersonas = personasServices.create(newPersonas);
        return newPersonas;
    }

    @PutMapping(value = "/personas/{numeroDocumento}")
    public Personas update(@RequestBody Personas upPersona, @PathVariable String numeroDocumento)
    {
        Personas persona = personasServices.update(upPersona, numeroDocumento);

        return persona;
    }

    @DeleteMapping(value = "personas/{numeroDocumento}")
    public String delete(String numeroDocumento)
    {
        String response;
         response =personasServices.delete(numeroDocumento);
         return  response;
    }





}
