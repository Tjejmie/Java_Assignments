package se.miun.jasv2000.dt187g.jpaint;

public class Engine {

    private boolean engineRunning;

    public Engine() {
        super();
    }

    public void startEngine(){
        engineRunning = true;
    }

    public void stopEngine(){
        engineRunning = false;
    }

    public boolean isEngineRunning(){
  
        if (engineRunning == true){
            return true; 
        }
        return false;
    }
    
}
