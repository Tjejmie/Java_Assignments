package se.miun.jasv2000.dt187g.jpaint;

import java.awt.Graphics;
import java.lang.reflect.Array;

import javax.print.event.PrintEvent;


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
        

        // double xValue = (double) Array.get(points, 0);

        // System.out.println(xValue); // 5.0
        // return xValue;
        return 0;
        
      
        
        
	}

   


    private double parseDouble(Point point) {
        return 0;
    }

    public Double getHeight() {
        return Math.abs(x);
        // return null;
    }

    @Override
    public void draw() {
      
        System.out.println("Rectangle[start=" + points[0] + " end=" + points[1] + " width=N/A height=" +  "color=" + color + "]");
        
    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public double getCircumference() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getArea() {

        
        boolean hasValue = false;
        double area = getWidth() * getHeight();
 
        if(hasValue == true){
            return area;
        }
        else{
            return -1;
        }
       
 
    }

    @Override
    public boolean hasEndpoint() {

        // String endpoint;

        // if (points[1] != null){
            
        //     return true;
        // }
        // else{
        //     endpoint = "N/A";
        //     return false;
        // }
        return true;
    }

    

}
