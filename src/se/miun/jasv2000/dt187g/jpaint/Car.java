package se.miun.jasv2000.dt187g.jpaint;

import java.util.ArrayList;

public class Car {
    private double maxPassengersWeight = 400;
    private double milage;
    private boolean carRunning;
    private Engine engine;
    private double maxWeight;
    private double carWeight = 1200;

    // Kan vara 0 och finns därför inte i konstruktorn
    public Person driver = new Person(null);
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();

    public Car(double milage, double maxWeight, Engine engine) {
        this.milage = milage;
        this.maxWeight = maxWeight;
        this.engine = engine;
        
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

        // Lite oklart i uppgiften ifall passagerare ska mätas efter maxPassengerWeight eller
        // att det inte överstiger bilens totala maxvikt, så gör en kombination av båda fast
        // de räknar ut exakt samma sak i slutändan
        

        if ((remainingWeight - passWeight) > 0 && (passWeight + carWeight) < maxWeight){
            passengers.add(passenger);
            carWeight = carWeight += passWeight;
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
        else{
            System.out.println("Wasn't possible to drive car");
            return false;
        }
        
    }
    
}
