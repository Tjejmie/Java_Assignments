package se.miun.jasv2000.dt187g.jpaint;

import java.util.ArrayList;

public class Car {
    private double maxPassengersWeight = 400;
    private double milage;
    private boolean carRunning;
    private Engine engine;
    private Person driver;

    //Eftersom passagerare inte måste finnas så nyas den ej upp i konstruktorn
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public Car(double milage, double maxWeight, Engine engine, Person driver) {
        this.engine = engine;
        this.driver = driver;
        this.milage = milage;
    }

    public Car(double maxWeight){ 
        super();
    }

    // Get remaining weight from maxPassengersWeight
    public double getRemainingWeight(){
        double remainingWeight = 0;
        double passWeight = 0;
        for (Passenger pass : passengers) 
        { 
            passWeight += pass.getWeight();
        }
        remainingWeight = maxPassengersWeight - passWeight;
        return remainingWeight;
    }

    // Add passenger if passenger weight is not to much
    public void addPass(Passenger passenger){
        double remainingWeight = getRemainingWeight();
        double passWeight = passenger.getWeight();
        System.out.println("Adding passenger...");
        if ((remainingWeight - passWeight) > 0){
            passengers.add(passenger);
            System.out.println("Passenger added.");
        }
        else{
            System.out.println("Total weight is to much to add that passenger");
        }
    }

    public double getMilage(){
        return milage;
    }

    public double getMaxPassengersWeight(){
        return maxPassengersWeight; 
    }

    public void startCar(){
        carRunning = true;
        engine.startEngine();
    }

    public void stopCar(){
        carRunning = false;
        engine.stopEngine();
    }

    public boolean drive(double distance){
        if (carRunning == true && driver.getName() != null && distance != 0){
            milage += distance;
            return true;
        }
        return false;
    }
    
}
