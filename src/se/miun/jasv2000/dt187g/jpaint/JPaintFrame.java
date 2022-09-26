package se.miun.jasv2000.dt187g.jpaint;
import java.awt.*;
import java.awt.event.*;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.util.*;

/**
 * Klass som ärver ifrån JFrame och som används för att skapa ett grafiskt användargränssnitt.
 * 
 * 
 * @author jasv2000 | Jamie Svanberg
 * @version 1.0
 */
public class JPaintFrame extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;

    // Menu
    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem i1, i2, i3, i4, i5, i6, i7; 

    // Top panel
    private JPanel color1JPanel, color2JPanel, color3JPanel, color4JPanel, color5JPanel;
    private JPanel colors, topJPanel, combo;
    private JComboBox<String> comboBox;
    private String[] figures = {"Rectangle", "Circle"};

    // Center panel
    private JPanel center;

    // Bot panel
    private JLabel botLeftText, botRightText;
    private JPanel botColorBox, botJPanel, botLeft, botRight; 

    String name;
    String author;

	public JPaintFrame() {
        setTitle();


        // What should happen when the user closes the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Using null centers the window on the screen
		// setLocationRelativeTo(null);

        //Call methods
        setIcon();
        createMenu();
        createTopPanel();
        createCenterPanel();
        createBottomPanel();

        // sizes this window to fit the preferred size and layouts of its subcomponents
        pack(); 

        //Set size on the window
        setSize(800,600); 
	}
    public boolean nameExist(String name){ //Metod som returnerar true ifall name inte är null eller är en string som ej är tom
        this.name = name;
        if (name == null ||name == ""){
            return false;
        }
        else{
            return true; 
        }
    }
    public boolean authorExist(String author){ //Metod som returnerar true ifall author inte är null eller är en tom string
        return author != null && author != "";
    }

    private void setTitle(){
        // Set the title of this JFrame (window)

		if(authorExist(author) == true && nameExist(name) == true){
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

        // Add categories to menu-option1 
        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
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

        //Registrerar lyssnare på menyalternativen
        i6.addActionListener(this);
        i7.addActionListener(this);



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

        // Add topJPanel with all components to the window
        add(topJPanel, BorderLayout.PAGE_START);
    }

    //Method to create center panel
    private void createCenterPanel(){
        //Create center and set bg white
        center = new JPanel();
        center.setBackground(Color.WHITE);

        //Add center to the window
        add(center, BorderLayout.CENTER);
    }

    //Method to create bottom panel
    private void createBottomPanel(){
        //Create labels and bot panel components
        botLeftText = new JLabel("Coordinates: 127, 103");
        botRightText = new JLabel("Selected color:");
        botColorBox = new JPanel();
        botColorBox.setBackground(Color.GREEN);
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
        setIconImage(new ImageIcon(
                "C:/Users/Jamie Lannister/Desktop/Java_Assignments/Assignments/src/se/miun/jasv2000/dt187g/jpaint/paint.png").getImage());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = new JFrame();
        if (e.getSource() == i6){
            name = (String)JOptionPane.showInputDialog(
                frame,
                "Enter name of the drawing:", 
                "Indata",            
                JOptionPane.QUESTION_MESSAGE,
                null,            
                null, 
                null);
        }
        else if(e.getSource() == i7){
            author = (String)JOptionPane.showInputDialog(
                frame,
                "Enter name of the author:", 
                "Indata",            
                JOptionPane.QUESTION_MESSAGE,
                null,            
                null, 
                null);
               
        }
        setTitle();
    }

}