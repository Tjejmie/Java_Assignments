package se.miun.jasv2000.dt187g.jpaint;

public class Passenger extends Person {

    private double weight;
    public Passenger(String name, double weight) {
        super(name);
        this.name = name;
        this.weight = weight;

    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public double getWeight(){
        return weight;
    }


    
}
