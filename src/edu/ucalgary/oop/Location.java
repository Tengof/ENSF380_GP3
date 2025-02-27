package edu.ucalgary.oop;

import java.util.ArrayList;

public class Location {
    private String name;
    private String address;
    private ArrayList<DisasterVictim> occupants;
    private ArrayList<Supply> supplies;
    
    public Location(String name, String address) {
        this.name = name;
        this.address = address;
        this.occupants = new ArrayList<>();
        this.supplies = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public ArrayList<DisasterVictim> getOccupants() {
        return occupants;
    }
    
    public void setOccupants(ArrayList<DisasterVictim> occupants) {
        this.occupants = occupants;
    }
    
    public void addOccupant(DisasterVictim occupant) {
        if (occupant != null) {
            occupants.add(occupant);
        }
    }
    
    public void removeOccupant(DisasterVictim occupant) {
        if (occupant != null) {
            occupants.remove(occupant);
        }
    }
    
    public ArrayList<Supply> getSupplies() {
        return supplies;
    }
    
    public void setSupplies(ArrayList<Supply> supplies) {
        this.supplies = supplies;
    }
    
    public void addSupply(Supply supply) {
        if (supply != null) {
            supplies.add(supply);
        }
    }
    
    public void removeSupply(Supply supply) {
        if (supply != null) {
            supplies.remove(supply);
        }
    }
}
