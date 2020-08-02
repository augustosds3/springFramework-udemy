package com.springstudies.petclinic.services.map;

import com.springstudies.petclinic.model.Pet;
import org.springframework.stereotype.Service;
import com.springstudies.petclinic.services.CrudService;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements CrudService<Pet,Long> {
    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(Pet object) {
        return super.save(object);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
