package se.miun.jasv2000.dt187g.jpaint;

import java.awt.Graphics;
import java.util.ArrayList;

/**
* <h1>Drawing</h1>
* En klass som hanterar en samling av Shape-objekt. Implementerar grässnittet Drawable då Drawing är en klass som är "ritbar".
* 
*
* @author jasv2000 | Jamie Svanberg
* @version 1.0
*/

public class Drawing implements Drawable {

    private String name;
    private String author;
    public ArrayList<Shape> shapes;
    
    public Drawing() {
        this.shapes = new ArrayList<>(); 
    }

    public Drawing(String name, String author) {
        this.name = name;
        this.author = author;
        this.shapes = new ArrayList<>(); 
    }

    public boolean nameExist(String name){ //Metod som returnerar true ifall name inte är null eller är en string som ej är tom
        return name != null && name != "";
    }
    public boolean authorExist(String author){ //Metod som returnerar true ifall author inte är null eller är en tom string
        return author != null && author != "";
    }
    
    public boolean save(String filename) throws DrawingException{ //Metod som kontrollerar och kastar DrawingExceptions ifall name/author saknas
        if(authorExist(author) == false && nameExist(name) == false){
            throw new DrawingException("The drawing is missing author and name");
        }
        if(authorExist(author) == false){
            throw new DrawingException("The drawing is missing author");
        }
        if(nameExist(name) == false){
            throw new DrawingException("The drawing is missing name");
        }
        
        return true;
    }


    //Set metoder
    public void setName(String name){
        this.name = name;
    }
    public void setAuthor(String author){
        this.author = author;
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

    public void addShape(Shape shape) { //metod som tar in ett shapeobjekt och lägger in i listan shapes

        if(shape != null){
            shapes.add(shape); 
        }
    }

    public double getSize() {
        return shapes.size();  //Returnerar listans storlek
    }
    
    public double getTotalCircumference(){ //metod som returnerar omkretsen av alla figurer
        double circumference = 0;
        for (Shape shape : shapes) {
            if(shape.hasEndpoint()){ //Omkretsen räknas enbart ut om det finns en endpoint
                circumference += shape.getCircumference();
            }
        }
        return circumference;
    }

    public double getTotalArea(){ //metod som returnerar arean för alla figurer
        double area = 0;
        for (Shape shape : shapes) {
            if(shape.hasEndpoint()){
                area += shape.getArea(); //arean hämtas från getArea metoden i shape. arean läggs till i variabeln area.
            }
        }
        return area; 
    }


    @Override
    public void draw() {
        System.out.println("A drawing by " + author + " called " + name);
        for(Shape shape : shapes){ //returnerar figurernas toString
            System.out.println(shape);
        }
    }
    
    @Override
    public void draw(Graphics g) {
        for(Shape shape : shapes){ 
            shape.draw(g);
        }
    }

    public String toString(){
        return ("Drawing[name=" + getName() + "; author=" + getAuthor() +  "; size= " + getSize() + "; circumference= "+ getTotalCircumference() + "; area="+ getTotalArea() + ";]");
    }

    

    

    
    
}
