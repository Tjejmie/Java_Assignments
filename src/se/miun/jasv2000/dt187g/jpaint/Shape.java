package se.miun.jasv2000.dt187g.jpaint;



public abstract class Shape implements Drawable {
    protected String color;
  
    protected double x;
    protected double y;

    protected Point[] points;



    
    public Shape(double x, double y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
        // points = new Point[2];
        // points[0] = new Point(x, y);
        
       
    }

    public Shape(Point point, String color) {
        points = new Point[2];
        this.points[0] = point;
        
        this.color = color;
        // points[0] = new Point(x, y);
        // System.out.println(point);
        
        
    }
   
       


    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }

    public abstract double getCircumference(); //returnera figurens omkrets

    public abstract double getArea(); // returnera figurens area

    public Point addPoint(double x, double y){ //Objekt av x,y. Dessa objekts läggs sedan in i array plats2
        Point point = new Point(x,y);
        this.points[1] = point;
        return point;
    }
    

    public Point addPoint(Point p) {
        this.points[1] = p;
        return p;
    }

    
    

 

    public abstract boolean hasEndpoint(); //Returnerar true eller false

        
}
