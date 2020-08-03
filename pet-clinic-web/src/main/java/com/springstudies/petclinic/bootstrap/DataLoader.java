package com.springstudies.petclinic.bootstrap;

import com.springstudies.petclinic.model.*;
import com.springstudies.petclinic.services.PetTypeService;
import com.springstudies.petclinic.services.SpecialityService;
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
    private final SpecialityService specialityService;


    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(dog);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");

        Speciality savedSurgery = specialityService.save(surgery);
        ;

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentistry");

        Speciality saveDentistry= specialityService.save(dentistry);


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
        vet1.getSpecialities().add(savedRadiology);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Charllote");
        vet2.setLastName("Lynlin");
        vet2.getSpecialities().add(savedSurgery);

        vetService.save(vet2);

        System.out.println("Vets Loaded");
    }

}
