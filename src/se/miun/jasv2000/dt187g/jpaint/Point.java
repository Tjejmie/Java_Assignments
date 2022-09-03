package se.miun.jasv2000.dt187g.jpaint;
/**
* <h1>Point</h1>
* 
* Klass för att representera punkter i kordinatsystemet (X,Y). 
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

public class Point {

    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point() { //Tom konstruktor för att sätta defaultvärde till (0,0)
        
    }

    //Get-metoder för att hämta X värdet och Y-värdet
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    //Set-metoder för att sätta värdet X och Y
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    //Metod som retunerar värdet på X och Y som en sträng
    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
