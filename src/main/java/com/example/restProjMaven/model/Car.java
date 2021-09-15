package com.example.restProjMaven.model;

import com.example.restProjMaven.entity.CarEntity;

public class Car {
    private int id;
    private double coordX;
    private double coordY;

    public static Car toModel(CarEntity carEntity){
        Car carModel = new Car();
        carModel.setId(carEntity.getId());
        carModel.setCoordX(carEntity.getCoordX());
        carModel.setCoordY(carEntity.getCoordY());
        return carModel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
}
