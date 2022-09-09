package se.miun.jasv2000.dt187g.jpaint;

/**
* <h1>DrawingException</h1>
* Klass som ärver från Exception. Klassen representerar fel som uppstår vid körning av klassen Drawing
* 
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/


public class DrawingException extends Exception {

    public DrawingException(String errorMsg) {
        super(errorMsg);
    }
    
}
