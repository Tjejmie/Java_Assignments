package se.miun.jasv2000.dt187g.jpaint;
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
        Point point = new Point(x,y);
        // points = new Point[2]; //Skapar en ny array av Points med två indexvärden
        points.add(0, point);
        // points[0] = new Point(x, y); //x och y sätts som index0 i points
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
        // Ska vara tom än så länge
    }

    @Override
    public double getCircumference() { //Metod för att beräkna omkrets

        double getWidth = getWidth() * 2;
        double getHeight = getHeight() * 2;
        double result = getWidth + getHeight;

        if(points.get(1) != null && points.get(0) != null){
            return result;
        }
        else{
            return -1; //Om slutvärdet inte existerar presenteras -1
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

    // @Override
    // public boolean hasEndpoint() { //Metod för att kontrollera ifall slutvärdet är null

    //     if (points.get(1) != null){
    //         return true;
    //     }
    //     else{
    //         return false;
    //     }
    // }
    
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
        // return ("Rectangle[start=" + points.get(0) + " end=" + getEndpoint() + "; width= "+ getWidth() + "; height= " + getHeight() +  " color=" + color + "]");
        return ("Rectangle[start=" + points.get(0) + " end=" + getEndpoint() +  "; width= "+ getWidth() +  "; height= " + getHeight() +   " color=" + color + "]");
    }
}
