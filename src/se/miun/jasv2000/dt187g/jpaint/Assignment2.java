package se.miun.jasv2000.dt187g.jpaint;

/**
* <h1>Assignment 2</h1>
* This application creates a <code>Drawing</code> with a name,
* author and different shapes in it. It then calls various
* methods to print total circumference and area. 
*
* @author Your Name (studentid)
* @version 1.0
*/
public class Assignment2 {

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create an empty drawing and print info about it.
		System.out.println("Creating a new empty drawing...");
		
		Drawing monaLisa = new Drawing();
		
		System.out.println(monaLisa);
		
		// Set name and author.
		System.out.println("\nSetting name and author...");
		
		monaLisa.setName("Mona Lisa");
		monaLisa.setAuthor("L. da Vincis");
		
		System.out.println(monaLisa);
		
		// Add five shapes with no end points
		System.out.println("\nAdding 5 shapes with no end points...");
		
		Shape face = new Circle(100,100, "#ffe0bd"); // RGB(255,224,189)
		Shape leftEye = new Circle(75, 75, "#0000ff"); // RGB(0, 0, 255)
		Shape rightEye = new Circle(125, 75, "#0000ff"); // RGB(0, 0, 255)
		Shape nose = new Rectangle(95, 100, "#000000"); // RGB(0, 0, 0)
		Shape mouth = new Rectangle(55, 130, "#ff0000"); // RGB(255, 0, 0)
		
		monaLisa.addShape(face);
		monaLisa.addShape(leftEye);
		monaLisa.addShape(rightEye);
		monaLisa.addShape(nose);
		monaLisa.addShape(mouth);
		
		System.out.println(monaLisa);
		
		// Add a null shape (size should not increase!).
		System.out.println("\nSize is: " + monaLisa.getSize());
		System.out.println("Adding a null shape...");
		
		monaLisa.addShape(null);
		
		System.out.println("Size is: " + monaLisa.getSize());
		
		// Add end point to all shapes
		System.out.println("\nAdding end point to all shapes...");
		face.addPoint(175, 100);
		leftEye.addPoint(85, 75);
		rightEye.addPoint(135, 75);
		nose.addPoint(105, 115);
		mouth.addPoint(145, 140);
		System.out.println("Total circumference is: " + monaLisa.getTotalCircumference());
		System.out.println("Total area is: " + monaLisa.getTotalArea());
		
		// Draw the entire drawing
		System.out.println("\nDraw the drawing...");
		monaLisa.draw();

		// Print area of nose
		System.out.println("\nArea of nose=" + nose.getArea());
		
		// Change end point of nose and print area again
		Point p = new Point(100, 110);
		System.out.println("Changing end point of nose to " + p);
		nose.addPoint(p);
		System.out.println("Area of nose=" + nose.getArea());
	}
}