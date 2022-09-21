package se.miun.jasv2000.dt187g.jpaint;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


/**
 * Example how to create and show a GUI with some basic components.
 * Use this as a skeleton when creating your own GUIs.
 * 
 * @author jasv2000 | Jamie Svanberg
 * @version 1.0
 */
public class JPaintFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JMenuBar menuBar;
    private JMenu menu1, menu2;
    private JMenuItem i1, i2, i3, i4, i5, i6, i7; 
    private JPanel color1JPanel, color2JPanel, color3JPanel, color4JPanel, color5JPanel;
    private JPanel colors, topJPanel, combo;
    private JComboBox<String> comboBox;
    private String[] figures = {"Rectangle", "Circle"};

    private JLabel botLeftText, botRightText;
    private JPanel botColorBox, botJPanel, botLeft, botRight; 
    private JPanel center;
    

	public JPaintFrame() {
        
		setTitle("JPaint");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
        setIcon();
        createMenu();
        createTopPanel();
        createCenterPanel();
        createBottomPanel();
        pack(); 
       
        setSize(800,600); 
        setVisible(true);
	}


  
	private void createMenu() {
        menuBar = new JMenuBar();
        menu1 = new JMenu("File");
        i1 = new JMenuItem("New...");
        i2 = new JMenuItem("Save as...");
        i3 = new JMenuItem("Load...");
        i4 = new JMenuItem("Exit");

        menu1.add(i1);
        menu1.add(i2);
        menu1.add(i3);
        menu1.addSeparator();
        menu1.add(i4);

        menu2 = new JMenu("Edit");
        i5 = new JMenuItem("Undo");
        i6 = new JMenuItem("Name...");
        i7 = new JMenuItem("Author...");

        menu2.add(i5);
        menu2.add(i6);
        menu2.add(i7);
        menuBar.add(menu1);
        menuBar.add(menu2);
        setJMenuBar(menuBar);
	}

    private void createTopPanel(){

        topJPanel = new JPanel(new BorderLayout());
        colors = new JPanel(new GridLayout(1,5));
        colors.setPreferredSize(new Dimension(80, 80)); //Ändra dimensions

        color1JPanel = new JPanel();
        color2JPanel = new JPanel();
        color3JPanel = new JPanel();
        color4JPanel = new JPanel();
        color5JPanel = new JPanel();
        
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

        colors.add(color1JPanel);
        colors.add(color2JPanel);
		colors.add(color3JPanel);
		colors.add(color4JPanel);
        colors.add(color5JPanel);
    
        combo = new JPanel(new BorderLayout());
        comboBox = new JComboBox<>(figures);
        comboBox.setPreferredSize(new Dimension(120, 80));
        combo.add(comboBox);

        topJPanel.add(colors, BorderLayout.CENTER);
        topJPanel.add(combo, BorderLayout.LINE_END);

        add(topJPanel, BorderLayout.PAGE_START);
    }

    private void createCenterPanel(){

        center = new JPanel();
        center.setBackground(Color.WHITE);
        add(center, BorderLayout.CENTER);
    }

    private void createBottomPanel(){

        botLeftText = new JLabel("Coordinates: 127, 103");
        botRightText = new JLabel("Selected color:");
        botColorBox = new JPanel();
        botColorBox.setBackground(Color.GREEN);
        botColorBox.setOpaque(true);

        botJPanel = new JPanel(new BorderLayout());
        botRight = new JPanel();
        botLeft = new JPanel();

        botRight.add(botRightText);
        botRight.add(botColorBox);
        botLeft.add(botLeftText);

        botJPanel.add(botLeft, BorderLayout.LINE_START);
        botJPanel.add(botRight, BorderLayout.LINE_END);
    
        add (botJPanel, BorderLayout.PAGE_END);
    }

    private void setIcon(){  //Sätter ikon
        setIconImage(new ImageIcon(
                "C:/Users/jamie/OneDrive/Skrivbord/Java_assignment/Java_Assignments/src/se/miun/jasv2000/dt187g/jpaint/assets/paint.png").getImage());
    }

	public static void main(String args[]) {
		// Always make sure GUI is created on the event dispatching thread.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JPaintFrame();
			}
		});
    }
}