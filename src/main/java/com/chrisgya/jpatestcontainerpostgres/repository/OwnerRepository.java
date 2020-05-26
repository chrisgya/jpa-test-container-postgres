package com.chrisgya.jpatestcontainerpostgres.repository;

import com.chrisgya.jpatestcontainerpostgres.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@RestResource
@Repository
public interface OwnerRepository  extends JpaRepository<Owner, Long> {
    Owner findByFirstName(String firstName);
}
