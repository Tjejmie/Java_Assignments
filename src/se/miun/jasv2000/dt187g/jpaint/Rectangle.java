package se.miun.jasv2000.dt187g.jpaint;
import java.awt.Color;
import java.awt.Graphics;
/**
* <h1>Rectangle</h1>
* Klass som skapar en rektangel baserat på koordinaternas start- och slutpunkt.
* Olika metoder är skapade för att räkna ut rektangelns höjd, bredd, area och omkrets.
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

public class Rectangle extends Shape { 


    public Rectangle(double x, double y, String color) {
        super(x, y, color);

    }

    public Rectangle(Point point, String color) {
        super(point, color); 
        

    }

	public double getWidth() { //Metod för att räkna ut rektangelns bredd. 
        double width;
        try {
            points.get(1);
            width = points.get(0).x - points.get(1).x;
            return Math.abs(width); //Metod som hanterar när koordinaterna är inlagda tvärtom. Ändrar talet från negativt till positivt
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
	}

    public double getHeight() { //Metod för att räkna ut rektangelns bredd. 
        double height;
        try {
            points.get(1);
            height = points.get(0).y - points.get(1).y;
            return Math.abs(height); //Metod som hanterar när koordinaterna är inlagda tvärtom. Ändrar talet från negativt till positivt
        } catch (IndexOutOfBoundsException e) {
            return -1;
        }
    }

    @Override
    public void draw() {
        System.out.println(toString());
    }

    @Override
    public void draw(Graphics g) {

        double height = getHeight();
        double width = getWidth();
       

        g.setColor(Color.decode(color));
        g.fillRect((int)points.get(0).x, (int)points.get(0).y, (int)width,(int)height);
        g.drawRect((int)points.get(0).x, (int)points.get(0).y, (int)width,(int)height);
    }

    @Override
    public double getCircumference() { //Metod för att beräkna omkrets

        double getWidth = getWidth() * 2;
        double getHeight = getHeight() * 2;
        double result = getWidth + getHeight;

        try {
            points.get(0);
            points.get(1);
            return result; 
        } catch (IndexOutOfBoundsException e) {
            return -1; //Ifall värdet är null returneras -1
        }

    }

    @Override
    public double getArea() { //Metod för att räkna arean på trianglen

        double area = getWidth() * getHeight(); //Bredden gånger höjden för att räkna ut arean
        try {
            points.get(0);
            points.get(1);
            return area; 
        } catch (IndexOutOfBoundsException e) {
            return -1; //Ifall värdet är null returneras -1
        }
    }

    
    @Override
    public boolean hasEndpoint() { //Metod för att kontrollera ifall slutvärdet är null
        try {
            points.get(1);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }
    

    public String toString(){
        if(hasEndpoint() == false){
            return "Drawing a Rectangle [start="  + points.get(0) + ", " + getEndpointAsString() + "; " + "end=" + "N/A"  + "; " + "width=" + "N/A" + "; " + "height=" + "N/A" + "; " + "color=" + color + "]"; 
        }
        else{
            return "Drawing a Rectangle [start=" + points.get(0) + " end=" + getEndpointAsString() +  "; width= "+ getWidth() +  "; height= " + getHeight() +   " color=" + color + "]";
        }
        
    }
}
