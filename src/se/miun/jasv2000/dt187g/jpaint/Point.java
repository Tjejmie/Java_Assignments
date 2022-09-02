package se.miun.jasv2000.dt187g.jpaint;
public class Point {

    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    
    }

    public Point() {
        // Ha en tom/default konstruktor som sätter värdet till (0, 0) för punkten
    }

    //Get-metoder
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }

    //Set-metoder
    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }

    @Override
    public String toString(){
        return "(" + x + ", " + y + ")";
    }
}
