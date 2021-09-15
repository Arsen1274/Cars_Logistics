package com.example.restProjMaven.controller;

import com.example.restProjMaven.entity.CarEntity;
import com.example.restProjMaven.exception.CarAlreadyExistException;
import com.example.restProjMaven.exception.CarNotFoundException;
import com.example.restProjMaven.model.Car;
import com.example.restProjMaven.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping()
    public ResponseEntity getCars(){
        try{
            return ResponseEntity.ok(carService.getCarsService());
        }catch(CarNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Some error have happened");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getCar(@PathVariable int id){
        try{
            Car findCar = carService.getCarService(id);
            return ResponseEntity.ok("Car have been found\n" + findCar);
        }catch(CarNotFoundException e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Some error have happened, while searching Car with id " + id);
        }
    }

    @PostMapping
    public ResponseEntity postCar(@RequestBody CarEntity newCar){
        try{
            Car addedCar = carService.postCarService(newCar);
            return ResponseEntity.ok("Add new car " + addedCar);
        }catch(CarAlreadyExistException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Some error have happened, while adding new Car");
        }
    }

    @DeleteMapping()
    public ResponseEntity deleteCar(@RequestParam int id){
        try{
            Car deletedCar = carService.deleteCarService(id);
            return ResponseEntity.ok("Delete car "+ deletedCar);
        }catch(CarNotFoundException e ){
            return ResponseEntity.badRequest().body(e.getMessage());
        }catch(Exception e ){
            return ResponseEntity.badRequest().body("Some error have happened, while deleting Car");
        }
    }

}
