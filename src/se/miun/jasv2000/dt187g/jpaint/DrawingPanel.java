package se.miun.jasv2000.dt187g.jpaint;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Graphics;
import javax.swing.JPanel;
/**
 * Klass som ärver från JPanel och är den klass som hanterar själva ritytan i programmet.
 * I denna klass hanteras teckningen (drawing) och hanterar aktuell teckning som ritas upp genom att överskugga
 * metoden paintComponent som anropar andra klassers draw-metod
 * 
 * @author jasv2000 | Jamie Svanberg
 * @version 1.0
 */
public class DrawingPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

    private Drawing drawing;
    private Shape shape;
    private ArrayList<CoordinatesListener> listeners = new ArrayList<>();
    int mouseX;
    int mouseY;

    public DrawingPanel() {
        drawing = new Drawing();
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
        repaint();
    }

    public void addShapesFromDrawing(Drawing drawing){ // ?????????????????
        
    }

    public Drawing getDrawing(){
        return drawing;
    }
   
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        setBackground(Color.white);
        
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
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}
    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {}
}
