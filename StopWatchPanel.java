StopWatch.java

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class StopWatchPanel extends JPanel {

 private JButton start, stop , reset;
 private JLabel clockLabel;
 private Timer timer;
 private int time = 1;

 public StopWatchPanel()
 {

  //create layout to hold the time and set alignment center of screen
  clockLabel = new JLabel("" + "0");
  clockLabel.setFont(new Font("Bold", Font.BOLD, 75));
  clockLabel.setAlignmentX(CENTER_ALIGNMENT);

  //three button objects to be instantiated with labels, listener, and keyboard mneumonic
  //each button will share the same listener
  start = new JButton("START");
  start.setBackground(Color.black);
  start.setForeground(Color.white); //sets text color
  start.addActionListener(new ClockListener());
  start.setMnemonic('s');

  stop = new JButton("STOP");
  stop.setBackground(Color.black);
  stop.setForeground(Color.white);
  stop.addActionListener(new ClockListener());
  stop.setMnemonic('x');

  reset = new JButton("RESET");
  reset.setBackground(Color.black);
  reset.setForeground(Color.white);
  reset.addActionListener(new ClockListener());
  reset.setMnemonic('r');

  //seperate pane to hold each button object and display them horizontally on the screen
  JPanel buttonPane = new JPanel();
  buttonPane.setLayout(new BoxLayout(buttonPane,BoxLayout.X_AXIS));
  buttonPane.add(start); //add each button in order
  buttonPane.add(Box.createRigidArea(new Dimension(25,0))); //creates space between each button
  buttonPane.add(stop);
  buttonPane.add(Box.createRigidArea(new Dimension(25,0)));
  buttonPane.add(reset);
  buttonPane.add(Box.createRigidArea(new Dimension(25,0)));
  buttonPane.setAlignmentX(CENTER_ALIGNMENT); //buttons align near center
  buttonPane.setBackground(Color.white); //matches the rest of the panel color

  setLayout(new BoxLayout(this,BoxLayout.Y_AXIS)); //set to boxlayout to display label above buttons
  setBackground(Color.white);
  setBorder(BorderFactory.createLineBorder(Color.black, 25)); //border for aesthetics
  add(Box.createRigidArea(new Dimension(0,350))); //pushes label and buttonPane closer to bottom of screen
  add(clockLabel); //clock label above buttons
  add(Box.createRigidArea(new Dimension(15,15))); // small space between label and buttons
  add(buttonPane); //finally add the button pane

  // once start button has been pressed timer will perform actionEvent
  // every 1000 milliseconds(one second) until stop or reset has been pressed
  // clockListener class will control the timer
  timer = new Timer(1000,  new ClockListener()
  {
   public void actionPerformed(ActionEvent e)
   {
   clockLabel.setText(""+(time++)); //change clock label each iteration(one second)
   }
  });

 }

 // Listener to control timer object if buttons have been pressed
 private class ClockListener implements ActionListener
 {
  public void actionPerformed(ActionEvent event)
  {
   if(event.getSource() == start) //timer begins once the start button has been pressed
    timer.start();

   if(event.getSource() == stop) //timer will stop and label left as is
    timer.stop();

   if(event.getSource() == reset) //timer stops and label will be reset back to zero
   {
    time = 1; // time left at 1 due to latency issue if reset to 0 takes extra second to start
    clockLabel.setText("" + "0");
    timer.stop();
   }
  }
 }

}


