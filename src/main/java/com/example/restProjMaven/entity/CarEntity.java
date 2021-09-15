package com.example.restProjMaven.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CarEntity {
    @Id
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private int id;
    private String licensePlate;
    private double coordX;
    private double coordY;

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", coordX=" + coordX +
                ", coordY=" + coordY +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }
}
