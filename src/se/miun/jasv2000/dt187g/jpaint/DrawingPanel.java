package se.miun.jasv2000.dt187g.jpaint;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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

    public DrawingPanel() {

        addMouseListener(this);
        addMouseMotionListener(this);

    }
    
    public DrawingPanel(Drawing drawing) {
        this.drawing = drawing;
        
    }

    public void addCoordinatesListener(CoordinatesListener listener) {
        listeners.add(listener);
    }

    public void setDrawing(Drawing drawing){
        this.drawing = drawing;

    }
    public void addShapesFromDrawing(Drawing drawing){
        drawing.addShape(shape);
    }
    public Drawing getDrawing(){
        return drawing;
    }



    @Override
    protected void paintComponent(Graphics g) {
   
        super.paintComponent(g);
        setBackground(Color.white);
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // TODO Auto-generated method stub
        
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
    JPaintFrame jpant;
    
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
      
    }

   


}
