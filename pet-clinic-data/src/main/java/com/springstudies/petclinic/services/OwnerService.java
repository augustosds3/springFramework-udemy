package com.springstudies.petclinic.services;

import com.springstudies.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}
