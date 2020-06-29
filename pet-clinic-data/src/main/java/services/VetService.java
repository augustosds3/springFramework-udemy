package services;

import com.springstudies.petclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById(Vet id);

    Vet save(Vet vet);

    Set<Vet> findAll();


}
