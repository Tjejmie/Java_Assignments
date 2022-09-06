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
    }

    public Rectangle(Point point, String color) {
        super(point, color); 
    }

	public double getWidth() { //Metod för att räkna ut rektangelns bredd. 
        double width;
        if(points[1] != null){ 
            width = points[0].x - points[1].x;
            return Math.abs(width); //Metod som hanterar när koordinaterna är inlagda tvärtom. Ändrar talet från negativt till positivt
        }
        else{
            return -1; //Om slutvärdet inte existerar returnerar -1
        }
	}

    public double getHeight() { //Metod för att räkna ut rektangelns bredd. 
        double height;
        if(points[1] != null){
            height = points[0].y - points[1].y;
            return Math.abs(height); //Metod som hanterar när koordinaterna är inlagda tvärtom. Ändrar talet från negativt till positivt
        }
        else{
            return -1; //Om slutvärdet inte existerar returnerar -1
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

        if(points[1] != null && points[0] != null){
            return result;
        }
        else{
            return 1; //Om slutvärdet inte existerar presenteras -1
        }
    }


    @Override
    public double getArea() { //Metod för att räkna arean på trianglen

        double area = getWidth() * getHeight(); //Bredden gånger höjden för att räkna ut arean

        if(points[1] != null && points[0] != null){ //Om start/slutvärdet inte är null returneras arean
            return area;
        }
        else{
            return -1; //Ifall värdet är null returneras -1
        }
    }

    @Override
    public boolean hasEndpoint() { //Metod för att kontrollera ifall slutvärdet är null

        if (points[1] != null){
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        if(hasEndpoint() == false){
            return "Drawing a Rectangle [start=" +  points[0].x + ", " + points[0].y + "; " + "end=" + "N/A"  + "; " + "width=" + "N/A" + "; " + "height=" + "N/A" + "; " + "color=" + color + "]"; 
        }
        else{
            return "Drawing a Rectangle[start=" + points[0] + " end=" + getEndpointAsString() + "; width= "+ getWidth() + "; height= " + getHeight() +  " color=" + color + "]";
        }
        
    }
}
