import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class mainUI implements ActionListener
{
    public JFrame frame;
    public JPanel mainPanel,top_panel, mid_panel, bottom_panel;
    public JButton newGame, name;
    public JMenuBar menubar;
    public JTextField firstname;
    public String input;
    
    public mainUI(JFrame UIframe, JPanel UIpanel)
    {
        //Creating the frame attributes
        frame = UIframe;
        frame.setTitle("ROCK,PAPER,SCISSOR");
        frame.setSize(600,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
        frame.setResizable(true);
        
        //Creating the panels for the game 
        mainPanel = UIpanel;
        mainPanel.removeAll();
        mainPanel.revalidate();
        mainPanel.repaint();
        
        
        //Setting out the layout
        mainPanel.setLayout (new GridLayout(3,1));
        
        //Creating the MenuBar and all the other attributes
        menubar = new JMenuBar();
        JMenu menu_help = new JMenu("Help");
        menubar.add(menu_help);
        
        /*
        //Creating
        firstname = new JTextField();
        final JComponent[] input
        */
       
        //Creating the buttons
        name = new JButton("Enter Your Name");
        mainPanel.add(name).setLocation(1,1);
        name.setSize(40, 40);
        name.setOpaque(false);
        name.setContentAreaFilled(false);
        name.setBorderPainted(false);
        name.addActionListener(new ActionListener() {         
            public void actionPerformed(ActionEvent aActionEvent)
            {
              if(aActionEvent.getSource() == name)
              {
                  input = JOptionPane.showInputDialog(null, "Enter your player Name please");
                  if (!input.isBlank()) {
                      name.setText(input);
                  }
              }  
            }
        });
        
        newGame = new JButton("New Game");
        newGame.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
                if( aActionEvent.getSource() == newGame)
                {
                    
                    new game(frame, mainPanel,input);
                    
                }
            }
        });
        mainPanel.add(newGame).setLocation(3,1);
        newGame.setSize(40, 40);
        newGame.setOpaque(false);
        newGame.setContentAreaFilled(false);
        newGame.setBorderPainted(false);
        
        
        //Adding components to the frame 
        frame.getContentPane().add(BorderLayout.NORTH, menubar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent aevt)
    {
    }
}

