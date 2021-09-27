package com.example.restProjMaven.repository;

import com.example.restProjMaven.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CarRepo extends JpaRepository<CarEntity, Integer> {
    CarEntity findCarEntityByLicensePlate(String licensePlate);
}
