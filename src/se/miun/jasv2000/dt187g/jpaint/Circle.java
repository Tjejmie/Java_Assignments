package se.miun.jasv2000.dt187g.jpaint;
import java.awt.Graphics;

/**
* <h1>Circle</h1>
* Klass som skapar en cirkel baserat på koordinaternas start- och slutpunkt.
* Olika metoder är skapade för att räkna ut cirkelns radie, omkrets och area.
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

public class Circle extends Shape {
    
    final double pi = Math.PI; //Inbyggd klass som hämtar PI

    public Circle(double x, double y, String color) {
        super(x, y, color);
        points = new Point[2]; //Skapar en ny array av Points med två indexvärden
        points[0] = new Point(x, y); //x och y sätts som index0 i points
    }

    public Circle(Point p, String color) {
        super(p, color);
    }

public double getRadius() { //Räknar ut cirkelns radie

    double xValue;
    double yValue;
    double result = 0;
    if(points[1] != null){
        xValue = (points[1].x - points[0].x); //Avståndsformeln används för att räkna ut distansen mellan koordinaterna
        xValue = Math.pow(xValue, 2); //upphöjt till 2
        yValue = points[1].y - points[0].y;
        yValue = Math.pow(yValue, 2); //upphöjt till 2
        result = xValue + yValue;
        result = Math.sqrt(result); //Roten ur
        return result;
    }
    else{
        return -1; //Om slutvärdet inte existerar presenteras -1
    }
}

@Override
public void draw() {
    System.out.println(toString());
}

@Override
public void draw(Graphics g) {
    // Ska lämnas tom
}

@Override
public double getCircumference() { //Metod för att beräkna omkrets

    double circumference = (getRadius() * 2) * pi;
    if (points[1] != null && points[0] != null){
        return circumference;
    }
    else{
        return -1;
    }
}

@Override
public double getArea() { //Metod för att beräkna area
    double area = getRadius() * getRadius() * pi;

    if (points[1] != null && points[0] != null){
        return area;
    }
    else{
        return -1;
    }
}

@Override
public boolean hasEndpoint() {
    if (points[1] != null){
        return true;
    }
    else{
        return false;
    }
}

public String toString(){
    return ("Circle[start=" + points[0] + " end=" + getEndpoint() + " radius=" + getRadius()  + " color=" + color + "]");
}

}
