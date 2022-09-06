package se.miun.jasv2000.dt187g.jpaint;
/**
* <h1>Shape</h1>
* 
* En superklass som Rectangle och Circle ärver av. Abstrakt klass då subklasserna representeras på olika sätt.
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

import java.util.ArrayList;

public abstract class Shape implements Drawable {
    protected String color;
    protected ArrayList<Point> points;
    protected double x;
    protected double y;

    public Shape(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.points = new ArrayList<>();
    }

    public Shape(Point point, String color) {
        // points = new Point[2]; //points skapas och tilldelas en värde av två
        this.points = new ArrayList<>();
        points.add(0, point);
        // this.points[0] = point; //Index 0 i arrayen tilldelas värdet point som är argument för konstruktorn (startpunkt)
        this.color = color;
    }

    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public abstract double getCircumference(); 

    public abstract double getArea(); 

    public Point addPoint(double x, double y){ 

        Point point = new Point(x,y); //Metodens argument sätts som index1 i arrayen, vilket är slutpunkt för koordinaterna.
        points.add(1, point);
        // this.points[1] = point;
        return point;
    }

    public Point addPoint(Point p) { //Metod som tar Point-objekt som argument.
        points.add(1, p);
        // this.points[1] = p; //metodens argument tilldelas index1 arrayen vilket representerar slutpunkt
        return p;
    }


    public abstract boolean hasEndpoint();
    
    public String getEndpoint() { //Metod som sätter endpoint för rectangle och circle
        String message = "N/A";
        
        if(hasEndpoint() == true){
            return points.get(1).toString();
        }
        else{
            return message;
        }
    }

   
        
}
