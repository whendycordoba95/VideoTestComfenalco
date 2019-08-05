package co.com.prueba.sorteo.services;

import co.com.prueba.sorteo.model.entity.Personas;
import co.com.prueba.sorteo.model.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonasServices {

    @Autowired
    public PersonasRepository personasRepository;

    public List<Personas> getAll() { return personasRepository.findAll(); }

    public Personas getAllByNumeroDocumento (String numeroDocumento)
    { return personasRepository.findAllByNumeroDocumento(numeroDocumento);}

    public Optional<Personas> findById(String id){ return personasRepository.findById(id);}

    public Personas create (Personas newPersona) { return personasRepository.save(newPersona); }

    public Personas update (Personas upPersona, String numeroDocumento)
    { Personas persona = personasRepository.findAllByNumeroDocumento(numeroDocumento);
         if (persona != null)
         {
             upPersona.setNumeroDocumento(persona.getNumeroDocumento());
             persona =create(upPersona);
         }

         return persona;
    }

    public String delete(String id) {

        String msg;
        Optional<Personas> delTecnologias = findById(id);
        if (delTecnologias != null) {
            personasRepository.deleteById(id);
            msg= "Se ha eliminado con éxito";
        }else {
            msg="No se encuentra el registro";
        }
        return msg;
    }



}
