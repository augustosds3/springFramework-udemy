package services;

import com.springstudies.petclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Pet id);

    Pet save(Pet pet);

    Set<Pet> findAll();


}
