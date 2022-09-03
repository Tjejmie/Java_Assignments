package se.miun.jasv2000.dt187g.jpaint;

import java.awt.Graphics;


public class Rectangle extends Shape { 

    public Rectangle(double x, double y, String color) {
        super(x, y, color);
    
        points = new Point[2];
        points[0] = new Point(x, y);
 
    }

    public Rectangle(Point point, String color) {
        super(point, color);
        
    }

	public double getWidth() {
        double asd;
        if(points[1] != null){
            asd = points[0].x - points[1].x;
            return Math.abs(asd);

        }
        else{
            return -1;
        }
        
	}


    public double getHeight() {
        double asd;
        if(points[1] != null){
            asd = points[0].y - points[1].y;
            return Math.abs(asd);
           
        }
        else{
            return -1;
        }
    }


    public String getEnd() {
        String message = "N/A";
        
        if(hasEndpoint() == true){
            return points[1].toString();
        }
        else{
            return message;
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
    public double getCircumference() {

        double getWidth = getWidth() * 2;
        double getHeight = getHeight() * 2;
        double result = getWidth + getHeight;

        if(points[1] != null && points[0] != null){
            return result;
        }
        else{
            return -1;
        }
    }

    @Override
    public double getArea() { //Metod för att räkna arean på trianglen

        double area = getWidth() * getHeight();

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
        return ("Rectangle[start=" + points[0] + " end=" + getEnd() + "; width= "+ getWidth() + "; height= " + getHeight() +  " color=" + color + "]");
    }

    

}
