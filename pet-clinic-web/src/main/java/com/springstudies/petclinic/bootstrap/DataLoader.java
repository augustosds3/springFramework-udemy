package com.springstudies.petclinic.bootstrap;

import com.springstudies.petclinic.model.Owner;
import com.springstudies.petclinic.model.Pet;
import com.springstudies.petclinic.model.PetType;
import com.springstudies.petclinic.model.Vet;
import com.springstudies.petclinic.services.PetTypeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.springstudies.petclinic.services.OwnerService;
import com.springstudies.petclinic.services.VetService;

import java.time.LocalDate;

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
        owner1.setAddress("RR Tapajos 586");
        owner1.setCity("Contagem");
        owner1.setTelephone("34587798890");

        Pet mikkelPet = new Pet();
        mikkelPet.setPetType(savedDogPetType);
        mikkelPet.setOwner(owner1);
        mikkelPet.setBirthDate(LocalDate.now());
        mikkelPet.setName("Teddy");

        owner1.getPets().add(mikkelPet);


        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Michael");
        owner2.setLastName("Past");
        owner2.setAddress("RR Madeira 123");
        owner2.setCity("Contagem");
        owner2.setTelephone("0987654355");

        Pet michaelPet = new Pet();
        michaelPet.setPetType(savedCatPetType);
        michaelPet.setOwner(owner2);
        michaelPet.setBirthDate(LocalDate.now());
        michaelPet.setName("Meow");

        owner2.getPets().add(michaelPet);

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
