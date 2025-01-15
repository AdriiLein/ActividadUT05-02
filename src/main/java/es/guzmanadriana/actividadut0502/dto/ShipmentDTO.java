package es.guzmanadriana.actividadut0502.dto;

import java.sql.Timestamp;

public class ShipmentDTO {
    private Integer shipmentId;
    private Timestamp shipmentDate;
    private String address;
    private String city;
    private String country;
    private String state;
    private String zipCode;

    public ShipmentDTO(Integer shipmentId, Timestamp shipmentDate, String address, String city, String country, String state, String zipCode) {
        this.shipmentId = shipmentId;
        this.shipmentDate = shipmentDate;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Integer getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Integer shipmentId) {
        this.shipmentId = shipmentId;
    }

    public Timestamp getShipmentDate() {
        return shipmentDate;
    }

    public void setShipmentDate(Timestamp shipmentDate) {
        this.shipmentDate = shipmentDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}