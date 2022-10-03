package se.miun.jasv2000.dt187g.jpaint;

import java.awt.*;
import java.awt.event.*;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private Drawing drawing;
    private Shape shape;
    private ArrayList<CoordinatesListener> listeners = new ArrayList<>();
    JPanel drawingPanel;
    int mouseX;
    int mouseY;

    double x, y;
    JPaintFrame jpant;
 
    String color;


    public DrawingPanel() {
  
        addMouseListener(this);
        addMouseMotionListener(this);
        drawing = new Drawing();
        
    }
    
    public DrawingPanel(Drawing drawing) {
       

    }
   

    public void addCoordinatesListener(CoordinatesListener listener) {
        listeners.add(listener);
    }

    public void setDrawing(Drawing drawing){
        this.drawing = drawing;
        drawing = new Drawing();
        
        repaint();

    }

  

    

    public void addShapesFromDrawing(Drawing drawing){
        drawing = new Drawing();
    }
    public Drawing getDrawing(){
        return drawing;
    }

 
    Rectangle rectangle;
    @Override
    protected void paintComponent(Graphics g) {
        jpant = new JPaintFrame();
        rectangle = new Rectangle(x, y, color);
        super.paintComponent(g);
        setBackground(Color.white);

        // drawing.author = jpant.author;

        // drawing.setAuthor(author);
        // drawing.setName(name);
        
      
        // När man klickar på lode ska detta ske
        for(Shape shape : drawing.shapes){ 
            
             shape.draw(g);
        }
        drawing.draw(g); 
        

    }


    @Override
    public void mouseMoved(MouseEvent e) { // Print coordinates from mouse movement

        if (e.getSource() == this){
            mouseX = e.getX();
            mouseY = e.getY();
            for (CoordinatesListener coordinatesListener : listeners) {
                coordinatesListener.setCoordinates();
            }
        }
    }
    @Override
    public void mouseExited(MouseEvent e) { // Set coordinates to 0.0 when mouse exit center
        if (e.getSource() == this){
        
            for (CoordinatesListener coordinatesListener : listeners) {
                coordinatesListener.removeCoordinates();
                 
            }
        }
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
          
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

   


}
