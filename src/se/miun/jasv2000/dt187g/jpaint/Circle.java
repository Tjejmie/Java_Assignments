package se.miun.jasv2000.dt187g.jpaint;

import java.awt.Graphics;

public class Circle extends Shape {
    
    final double pi = 3.14;

    public Circle(double x, double y, String color) {
        super(x, y, color);
    }

    public Circle(Point p, String color) {
        super(p, color);
    }


public double getRadius() {
    return 0;
}

@Override
public void draw() {
    // TODO Auto-generated method stub
    
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
    // TODO Auto-generated method stub
    return 0;
}

@Override
public boolean hasEndpoint() {
    // TODO Auto-generated method stub
    return false;
}

}
