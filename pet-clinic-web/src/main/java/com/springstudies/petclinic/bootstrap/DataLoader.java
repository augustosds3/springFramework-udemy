package com.springstudies.petclinic.bootstrap;

import com.springstudies.petclinic.model.Owner;
import com.springstudies.petclinic.model.PetType;
import com.springstudies.petclinic.model.Vet;
import com.springstudies.petclinic.services.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springstudies.petclinic.services.OwnerService;
import com.springstudies.petclinic.services.VetService;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Owner owner1 = new Owner();
        owner1.setFirstName("Mikkel");
        owner1.setLastName("Future");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Past");

        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Vet vet1 = new Vet();
        vet1.setFirstName("Robesvaldo");
        vet1.setLastName("Raflws");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Charllote");
        vet2.setLastName("Lynlin");

        vetService.save(vet2);

        System.out.println("Vets Loaded");

    }

}
