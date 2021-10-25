import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


public class game extends JPanel implements ActionListener
{
    public JFrame f;
    public JPanel panel,user, comp, centre;
    public JButton rock, paper, scissor, computer, user_name, ai;
    public String name;
    public JLabel user_score, ai_score, winner;
    public String user_response, ai_response;
    
    public String container[] = {"ROCK","PAPER", "SCISSOR"};
    int flag = 0;
    int player, comp_player = 0;
    public game(JFrame frame, JPanel mainPanel , String input)
    {
        f= frame;
        panel=mainPanel;
        name = input;
        user = new JPanel();
        comp = new JPanel();
        centre = new JPanel();
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        
        user_score = new JLabel();
        ai_score = new JLabel();
        winner = new JLabel();
        
        
        
        
        gameplaySetup();
        //new gameplay(frame,panel);
    }
    
    //this method sets up the gameplay
    public void gameplaySetup()
    {
        panel.setLayout(new BorderLayout());
        user.setLayout(new GridLayout(3,1));
        comp. setLayout(new BorderLayout());
        centre.setLayout(null);
        
        rock = new JButton("ROCK");
        rock.setLocation(1,1);
        paper = new JButton("PAPER");
        paper.setLocation(2,1);
        scissor = new JButton("SCISSOR");
        scissor.setLocation(3,1);
        
        user.add(rock);
        user.add(paper);
        user.add(scissor);
        panel.add(user, BorderLayout.WEST);
        
        computer = new JButton("COMPUTER");
        
        comp.add(computer,BorderLayout.CENTER);
        panel.add(comp, BorderLayout.EAST);
        
        
        user_name = new JButton();
        user_name.setText(name);
        user_name.setBounds(0,250,100,50);
        centre.add(user_name);
        
        
        ai = new JButton();
        ai.setText("AI");
        ai.setBounds(292,250,100,50);
        centre.add(ai);
        
        panel.add(centre, BorderLayout.CENTER);
        
        user_score.setText(name+" :");
        user_score.setBounds(20,100,100,100);
        
        ai_score.setText("AI :");
        ai_score.setBounds(290,100,100,100);
        
        winner.setBounds(150,400,200,200);
        
        centre.add(user_score);
        centre.add(ai_score);
        centre.add(winner);
        
        gameplay();
    }
    
    public void gameplay()
    {
        
        
        rock.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
                if( aActionEvent.getSource() == rock)
                {
                    user_response = "ROCK";
                    user_name.setText("ROCK");
                    ai_response = aiResponse();
                    winner();
                    display();
                    
                }
            }
        });
        
        paper.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
                if( aActionEvent.getSource() == paper)
                {
                    user_response = "PAPER";
                    user_name.setText("PAPER");
                    ai_response = aiResponse();
                    winner();
                    display();
                    
                }
            }
        });
        
        scissor.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent aActionEvent)
            {
                if( aActionEvent.getSource() == scissor)
                {
                    user_response = "SCISSOR";
                    user_name.setText("SCISSOR");
                    ai_response = aiResponse();
                    winner();
                    display();
                    
                }
            }
        });
    }
    
    public void display()
    {
        System.out.println(flag);
        System.out.println(user_response);
        System.out.println(ai_response);
        if (flag == 2)
          {
            player= player+1;
            user_score.setText(name+" : "+player);
            ai_score.setText("AI : "+comp_player);
            winner.setText(name+" WINS.");
            
        }
        
        if (flag == 1)
        {
            comp_player= comp_player+1;
            user_score.setText(name+" : "+player);
            ai_score.setText("AI : "+comp_player);
            winner.setText("COMPUTER WINS. ");
            
        }
        
        if ( flag == -1)
        {
            winner.setText("IT IS A TIE");
            
        }
    }
    //Will return 2 if the Player is winner and will return 1 if the AI is winner and will return -1 if it is a tie
    public void winner()
    {
        if (user_response == "ROCK")
        {
            if ( ai_response == "ROCK"){flag = -1;}
            else
            {
                if(ai_response == "PAPER"){flag = 1;}
                else{flag=2;}
            }
            
        }
        
        else if (user_response == "PAPER")
        {
            if ( ai_response == "PAPER"){flag = -1;}
            else
            {
                if(ai_response == "SCISSOR"){flag = 1;}
                else{flag=2;}
            }
            
        }
        
        else if (user_response == "SCISSOR")
        {
            if ( ai_response == "SCISSOR"){flag = -1;}
            else
            {
                if(ai_response == "ROCK"){flag = 1;}
                else{flag=2;}
            }
            
        }
        
    }
    
    //This method will generate the response from AI
    public String aiResponse()
    {
        String response;
        Random r = new Random();
        int index = r.nextInt(3);
        response = container[index];
        ai.setText(response);
        return response;
    }
    
    public void actionPerformed(ActionEvent aevt)
    {
    }
}