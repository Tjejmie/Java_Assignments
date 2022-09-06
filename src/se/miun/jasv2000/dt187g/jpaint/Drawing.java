package se.miun.jasv2000.dt187g.jpaint;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.synth.SynthGraphicsUtils;

public class Drawing implements Drawable {

    protected String name;
    protected String author;

    private Rectangle rectangle;
    //shapes av någon klass som implementerar gränssnittet List<E>
    List<Shape> shapes = new ArrayList<>();
    
    public Drawing() {
        this.shapes = new ArrayList<>();
    }

    public Drawing(String name, String author) {
        this.name = name;
        this.author = author;
        
    }


  

    public void addShape(Shape shape) {

        if(shape != null){
            shapes.add(shape);
        }
        else{
            
        }
    }

    //Get metoder
    public String getName(){
        if(name == null){
            return "";
        }
        return name;
    }
    public String getAuthor(){
        if(author == null){
            return "";
        }
        return author;
    }

    //Set metoder
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    

    public double getSize() {
        return shapes.size(); 
    }
    
    public double getTotalCircumference() {
        if (shapes.size() != 0){
            for(int i = 0; i < shapes.size(); i++){
                
        }

        
    }
        else{
            return 0;
        }

        return 1;

    }

    public double getTotalArea() {
        return 0;
    }

    @Override
    public void draw() {
        System.out.println(toString());
        
    }

    @Override
    public void draw(Graphics g) {
        //Lämnas tom
        
    }

    public String toString(){
        return ("Drawing[name=" + getName() + " author=" + getAuthor() +  "; size= " + getSize() + "; circumference= "+ getTotalCircumference() + " area="+ getTotalArea() + "]");
    }

    

    

    
    
}
