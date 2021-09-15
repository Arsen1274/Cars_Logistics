package com.example.restProjMaven.service;

import com.example.restProjMaven.entity.CarEntity;
import com.example.restProjMaven.exception.CarAlreadyExistException;
import com.example.restProjMaven.exception.CarNotFoundException;
import com.example.restProjMaven.model.Car;
import com.example.restProjMaven.repository.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {

    @Autowired
    CarRepo carRepo;

    public String getCarsService() throws CarNotFoundException {
        Iterable<CarEntity> cars = carRepo.findAll();
        if(cars != null){
            String response = "Cars have found:\n";
            for(CarEntity car : cars){
                response += Car.toModel(car) + "\n";
            }
            return response;
        }else{
            throw new CarNotFoundException("No registered cars");
        }
    }

    public Car postCarService(CarEntity newCar) throws CarAlreadyExistException {
        String carLicancePlate = newCar.getLicensePlate();
        if (carRepo.findCarEntityByLicensePlate(carLicancePlate) != null){
            throw new CarAlreadyExistException("Car with license plate " + carLicancePlate + " already exist");
        }else{

            return Car.toModel(carRepo.save(newCar));
        }
    }

    public Car getCarService(int id) throws CarNotFoundException {
        Optional<CarEntity> searchedCarOpt = carRepo.findById(id);
        if (searchedCarOpt.isPresent()){
            return Car.toModel(searchedCarOpt.get());
        }else{
            throw new CarNotFoundException("Sorry, car with id "+ id+" don't exist");
        }
    }

    public Car deleteCarService(int id) throws CarNotFoundException {
        Optional<CarEntity> carToDelOpt = carRepo.findById(id);
        if(carToDelOpt.isPresent() ){
            carRepo.delete(carToDelOpt.get());
            return Car.toModel(carToDelOpt.get());
        }else{
            throw new CarNotFoundException("Sorry, car with id "+ id+" don't exist");
        }

    }
}
