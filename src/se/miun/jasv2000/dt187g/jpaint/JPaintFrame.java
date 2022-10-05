package se.miun.jasv2000.dt187g.jpaint;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Klass som ärver ifrån JFrame och som används för att skapa ett grafiskt användargränssnitt.
 * 
 * 
 * @author jasv2000 | Jamie Svanberg
 * @version 1.0
 */
public class JPaintFrame extends JFrame implements ActionListener, MouseListener, MouseMotionListener, CoordinatesListener {

    private static final long serialVersionUID = 1L;

    // Menu
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem i1, i2, i3, i4, i5, i6, i7, i8; 

    // Top panel
    private JPanel color1JPanel, color2JPanel, color3JPanel, color4JPanel, color5JPanel;
    private JPanel colors, topJPanel, combo;
    private JComboBox<String> comboBox;
    private String[] figures = {"Rectangle", "Circle"};

    // Bot panel
    public JLabel botLeftText, botRightText;
    private JPanel botColorBox, botJPanel, botLeft, botRight; 

    public String name = "";
    public String author = "";
    
    String dialogInfo;
    String dialogMessage;
    String shapeMessage;
    String title;
    Color actualColor = Color.GREEN;
    int mouseX;
    int mouseY;
    DrawingPanel drawingPanel;
    Drawing drawing = new Drawing();
    private ArrayList<CoordinatesListener> listeners = new ArrayList<>();

    public void addCoordinatesListener(CoordinatesListener listener) {
        listeners.add(listener);
    }

	public JPaintFrame() {
        setTitle();
        
        // What should happen when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        drawingPanel = new DrawingPanel();

        drawingPanel.addCoordinatesListener(this);
      
        //Call methods
        setIcon();
        createMenu();
        createTopPanel();
        createBottomPanel();
        add(drawingPanel, BorderLayout.CENTER);
        // sizes this window to fit the preferred size and layouts of its subcomponents
        pack(); 

        //Set size on the window
        setSize(800,600); 
        // Using null centers the window on the screen
        setLocationRelativeTo(null);
	}
   
    public boolean nameExist(String name){ //Check if name exist
        return name != null && !name.isEmpty();
      
        

    }
    public boolean authorExist(String author){ // Check if author exist
        return author != null && !author.isEmpty();
    }

    // Set the title of this JFrame (window)
    private void setTitle(){ 
        if(nameExist(name) == true && authorExist(author) == true){
            setTitle("JPaint" + " - " + name + " by " + author);
        }
        else if(authorExist(author) == true){
            setTitle("JPaint" + " - " + author);
        }
		else if(nameExist(name) == true){
            setTitle("JPaint" + " - " + name);
        }
        else{
            setTitle("JPaint");
        }
    }

    //Method to create menu
	private void createMenu() {

        // Create menubar and menu-option1 with categories
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        i1 = new JMenuItem("New...");
        i2 = new JMenuItem("Save as...");
        i3 = new JMenuItem("Load...");
        i4 = new JMenuItem("Exit");
        i8 = new JMenuItem("Info");

        // Add categories to menu-option1 
        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu1.add(i8);
        menu1.addSeparator();
        menu1.add(i4);

        // Create menu-option2 with cateogies
        menu2 = new JMenu("Edit");
        i5 = new JMenuItem("Undo");
        i6 = new JMenuItem("Name...");
        i7 = new JMenuItem("Author...");

        // Add cateogies to menu-option2
        menu2.add(i5);
        menu2.add(i6);
        menu2.add(i7);
        menuBar.add(menu1);
        menuBar.add(menu2);

        // Add actionlistener on menu-options
        i6.addActionListener(this);
        i7.addActionListener(this);
        i2.addActionListener(this);
        i3.addActionListener(this);
        i8.addActionListener(this);
        i1.addActionListener(this);
        i4.addActionListener(this);
        i5.addActionListener(this);

        setJMenuBar(menuBar);
	}

    //Method to create top panel
    private void createTopPanel(){
        // Create JPanels and set gridlayout on colors to make them flexible
        topJPanel = new JPanel(new BorderLayout());
        colors = new JPanel(new GridLayout(1,5));

        color1JPanel = new JPanel();
        color2JPanel = new JPanel();
        color3JPanel = new JPanel();
        color4JPanel = new JPanel();
        color5JPanel = new JPanel();
        
        // Set different background colour for each JPanel and make them opaque
        color1JPanel.setBackground(Color.CYAN);
        color1JPanel.setOpaque(true);
        color2JPanel.setBackground(Color.black);
        color2JPanel.setOpaque(true);
        color3JPanel.setBackground(Color.magenta);
        color3JPanel.setOpaque(true);
        color4JPanel.setBackground(Color.yellow);
        color4JPanel.setOpaque(true);
        color5JPanel.setBackground(Color.green);
        color5JPanel.setOpaque(true);

        // Add all JPanel-colours to colors
        colors.add(color1JPanel);
        colors.add(color2JPanel);
		colors.add(color3JPanel);
		colors.add(color4JPanel);
        colors.add(color5JPanel);

        // Set borderlayout on combo and set preffered size. Add figures(JComboBox) to combo(JPanel)
        combo = new JPanel(new BorderLayout());
        comboBox = new JComboBox<>(figures);
        comboBox.setPreferredSize(new Dimension(120, 80));
        combo.add(comboBox);

        // Add colors and combo to one JPanel and set layout
        topJPanel.add(colors, BorderLayout.CENTER);
        topJPanel.add(combo, BorderLayout.LINE_END);

        // Add mouseListener on colorJPanel
        color1JPanel.addMouseListener(this);
        color2JPanel.addMouseListener(this);
        color3JPanel.addMouseListener(this);
        color4JPanel.addMouseListener(this);
        color5JPanel.addMouseListener(this);


        // Add topJPanel with all components to the window
        add(topJPanel, BorderLayout.PAGE_START);
    }


    //Method to create bottom panel
    private void createBottomPanel(){
      
        //Create labels and bot panel components
        botLeftText = new JLabel("Coordinates: 0,0");
        botRightText = new JLabel("Selected color:");
        botColorBox = new JPanel();
        botColorBox.setBackground(actualColor);
        botColorBox.setOpaque(true);
        
        botJPanel = new JPanel(new BorderLayout());
        botRight = new JPanel();
        botLeft = new JPanel();
        
        //Add bot components to JPanels
        botRight.add(botRightText);
        botRight.add(botColorBox);
        botLeft.add(botLeftText);

        //Add panels to one botJPanels and set layout
        botJPanel.add(botLeft, BorderLayout.LINE_START);
        botJPanel.add(botRight, BorderLayout.LINE_END);

        // Add botpanel to the window
        add (botJPanel, BorderLayout.PAGE_END);
    }

    private void setIcon(){  //Method to set icon on window
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("paint.png")));
    }

    public String setDialog(String dialogInfo){ // Method to set information for the dialog
        JFrame frame = new JFrame();
        dialogInfo = (String)JOptionPane.showInputDialog(
                frame,
                dialogMessage, 
                "Indata",            
                JOptionPane.QUESTION_MESSAGE,
                null,            
                null, 
                shapeMessage);
                return dialogInfo;
    }

    // Create drawing
    public Drawing draw(Drawing drawing){

        Shape face = new Circle(100,100, "#ffe0bd");
        Shape leftEye = new Circle(75, 75, "#0000ff");
        Shape rightEye = new Circle(125, 75, "#0000ff");
        Shape nose = new Rectangle(95, 100, "#000000");
        Shape mouth = new Rectangle(55, 130, "#ff0000");
        face.addPoint(175, 100);
		leftEye.addPoint(85, 75);
		rightEye.addPoint(135, 75);
		nose.addPoint(105, 115);
		mouth.addPoint(145, 140);
        nose.addPoint(105, 115);
		mouth.addPoint(145, 140);
        drawing.addShape(face);
		drawing.addShape(leftEye);
		drawing.addShape(rightEye);
		drawing.addShape(nose);
		drawing.addShape(mouth);
        name = "Mona Lisa";
        author = "Da Vinci";
        drawing.setAuthor(author);
        drawing.setName(name);
   
        setTitle();
        return drawing;
    }
  
    @Override
    public void actionPerformed(ActionEvent e) { // Actions on menu
        
        if (e.getSource() == i6){ // Menu-option "Name..."
            dialogMessage = "Enter name of the drawing:";
            shapeMessage = null;
            name = setDialog(dialogInfo);
            if (name != null){
                drawing.setName(name);
                setTitle();
            }
        }

        else if(e.getSource() == i7){ // Menu-option "Author..."
            dialogMessage = "Enter name of the author:";
            shapeMessage = null;
            author = setDialog(dialogInfo);
            if (author != null){
                drawing.setAuthor(author);
                setTitle();
            }
            
        }

        else if(e.getSource() == i1){ // Menu-option "New..."
            drawing = new Drawing();
            shapeMessage = null;
            dialogMessage = "Enter name of the drawing:";
            name = setDialog(dialogInfo);
            dialogMessage = "Enter name of the author:";
            author = setDialog(dialogInfo);

            if(author != null && name != null){
                drawing.setName(name);
                drawing.setAuthor(author);
                setTitle();
            }
  
            drawingPanel.newDrawing(drawing); 
            
        }
        
        else if(e.getSource() == i2){ // Menu-option "Save as..."
    
            dialogMessage = "Save drawing to:";
            setInfoAndSaveMessage();
                shapeMessage = shapeMessage + ".shape";
            setDialog(dialogInfo);
        }

        else if(e.getSource() == i3){ // Menu-option "Load..."
            
            draw(drawing);
            drawingPanel.setDrawing(drawing); 
            
        }

        else if(e.getSource() == i5){ // Menu-option "Undo"
            int index = drawing.shapes.size() - 1; // Get last item from lost
            if (drawing.shapes.size() > 0){ // Check if list size is bigger than 0
                drawing.shapes.remove(index); //Remove last item from list
                repaint();
            }   
        }

        else if(e.getSource() == i8){ //Menu-option "Info"
            JFrame frame = new JFrame();
            double size = drawing.getSize();
            double circumference = drawing.getTotalCircumference();
            double area = drawing.getTotalArea();
            name = drawing.getName();
            author = drawing.getAuthor();
            setInfoAndSaveMessage();
      
            JOptionPane.showMessageDialog(frame, shapeMessage  + "\nNumber of shapes: " + size + "\nTotal area: " 
            + area + "\nTotal circumference: " + circumference, 
            "Info", JOptionPane.INFORMATION_MESSAGE);
        }

        else if(e.getSource() == i4){ // Menu-option "Exit"
            System.exit(0);
        }
    }

    // Metod that take titel and remove 'JPaint -' from it
    public void setInfoAndSaveMessage(){ 
        title = getTitle();
        shapeMessage = title;
        while (shapeMessage.contains("JPaint")){
            shapeMessage = shapeMessage.replace("JPaint", "");
            while (shapeMessage.contains(" - ")){
                shapeMessage = shapeMessage.replace(" - ", ""); 
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) { // Get colour on click from JPanels
        if (e.getSource() == color1JPanel){ // JPanel cyan
            actualColor = color1JPanel.getBackground();
            setActualColor(actualColor);
        }
        else if (e.getSource() == color2JPanel){ // JPanel black
            actualColor = color2JPanel.getBackground();
            setActualColor(actualColor);
        }
        else if (e.getSource() == color3JPanel){ // JPanel magenta
            actualColor = color3JPanel.getBackground();
            setActualColor(actualColor);
        }
        else if (e.getSource() == color4JPanel){ // JPanel yellow
            actualColor = color4JPanel.getBackground();
            setActualColor(actualColor);
        }
        else if (e.getSource() == color5JPanel){ // JPanel green
            actualColor = color5JPanel.getBackground();
            setActualColor(actualColor);
        }
    }

    private void setActualColor(Color color){
        botColorBox.setBackground(color);
    }

    @Override
	public void setCoordinates() {
        mouseX = drawingPanel.mouseX;
        mouseY = drawingPanel.mouseY;
		botLeftText.setText("Coordinates: " + mouseX + ", " + mouseY); 
	}

	@Override
	public void removeCoordinates() {
		botLeftText.setText("Coordinates: 0,0"); 
	}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {}
}