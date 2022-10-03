package se.miun.jasv2000.dt187g.jpaint;
import java.awt.Graphics;
import java.awt.Color;
/**
* <h1>Circle</h1>
* Klass som skapar en cirkel baserat på koordinaternas start- och slutpunkt.
* Olika metoder är skapade för att räkna ut cirkelns radie, omkrets och area.
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

public class Circle extends Shape {
    
    final double pi = 3.14; 
    double x;
    double y;
    public Circle(double x, double y, String color) {
        super(x, y, color);
        this.x = x;
        this.y = y;
    }

    public Circle(Point p, String color) {
        super(p, color);
    }

    public double getRadius() { //Räknar ut cirkelns radie

        double xValue;
        double yValue;
        double result = 0;
        try {
            points.get(1);
            xValue = (points.get(1).x - points.get(0).x); //Avståndsformeln används för att räkna ut distansen mellan koordinaterna
            xValue = Math.pow(xValue, 2); //upphöjt till 2
            yValue = points.get(1).y - points.get(0).y;
            yValue = Math.pow(yValue, 2); //upphöjt till 2
            result = xValue + yValue;
            result = Math.sqrt(result); //Roten ur
            return result; 
        } catch (IndexOutOfBoundsException e) {
            return -1; //Om slutvärdet inte existerar presenteras -1
        }
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }
 
    @Override
    public void draw(Graphics g) {
       
        double r = getRadius();
        double xValue = points.get(0).x;
        double yValue =points.get(0).y;

        xValue = xValue-(r);
        yValue = yValue-(r);

        g.setColor(Color.decode(color));
        g.fillOval((int)xValue,(int)yValue, (int)r*2, (int)r*2);
        g.drawOval((int)xValue,(int)yValue, (int)r*2, (int)r*2);
        

    }

    @Override
    public double getCircumference() { //Metod för att beräkna omkrets

        double circumference = (getRadius() * 2) * pi;
        try {
            points.get(0);
            points.get(1);
            return circumference; 
        } catch (IndexOutOfBoundsException e) {
            return -1; //Ifall värdet är null returneras -1
        }
    }

    @Override
    public double getArea() { //Metod för att beräkna area
        double area = getRadius() * getRadius() * pi;

        try {
            points.get(0);
            points.get(1);
            return area; 
        } catch (IndexOutOfBoundsException e) {
            return -1; //Ifall värdet är null returneras -1
        }
    }

    @Override
    public boolean hasEndpoint() {

        try {
            points.get(1);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false; //Ifall värdet är null returneras -1
        }
    }

    public String toString(){

        if(hasEndpoint() == false){
            return "Drawing a Circle[start=" +  points.get(0) + ", " + getEndpointAsString() + "; " + "end=" + "N/A"  + "; " + "radius=" + "N/A" + "; " + "color=" + color + "]"; 
        }
        else{
            return "Drawing a Circle[start=" + points.get(0) + " end=" + getEndpointAsString() + " radius=" + getRadius()  + " color=" + color + "]";
        }
    }

}
