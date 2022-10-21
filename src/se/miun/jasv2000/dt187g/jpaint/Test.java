package se.miun.jasv2000.dt187g.jpaint;


public class Test {
    public static void main(String[] args){
        Car();
    }

    private static void Car(){
        Engine engine = new Engine();
        Person driver = new Person(null);
        Car car2 = new Car(0);
        Car car = new Car(14500, car2.getMaxPassengersWeight(), engine, driver);

        System.out.println("Total milage = " + car.getMilage());
        System.out.println("Trying to start car...");
        car.startCar();
        System.out.println("Is engine on? " + engine.isEngineRunning());

        System.out.println("Set driver and drive 20 KM");
        driver.setName("Susanne");
        car.drive(20);
        System.out.println("Total milage = " + car.getMilage());


        System.out.println("Picking up passengers:");
        System.out.println("Max weight for passengers: " + car.getMaxPassengersWeight());
        Passenger pass1= new Passenger("Marie", 75);
        car.addPass(pass1);
        System.out.println("Weight left from total = " + car.getRemainingWeight());
        Passenger pass2= new Passenger("Sofie", 56);
        car.addPass(pass2);
        System.out.println("Weight left from total = " + car.getRemainingWeight());
        Passenger pass3= new Passenger("Kalle", 270);
        car.addPass(pass3);
        System.out.println("Weight left from total = " + car.getRemainingWeight());
        

        System.out.println("Drive 150 KM");
        car.drive(150);
        System.out.println("Total milage = " + car.getMilage());

        System.out.println("Turning car off...");
        car.stopCar();
        System.out.println("Is engine on? " + engine.isEngineRunning());
    }
}
