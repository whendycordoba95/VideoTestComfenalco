package co.com.prueba.sorteo.model.repository;

import co.com.prueba.sorteo.model.entity.Personas;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonasRepository extends MongoRepository<Personas, String> {

    Personas findAllByNumeroDocumento(String numeroDocumento);

    Optional<Personas> findById(String id);

}
