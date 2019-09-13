StopWatch.java

import java.awt.Dimension;
import javax.swing.JFrame;

public class StopWatch {

 public static void main(String[] args) {

  JFrame frame = new JFrame("StopWatch (Seconds)"); //instantiate  HeavyWeight container with title
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //close on command
  frame.getContentPane().add(new StopWatchPanel()); //add the stopwatch panel to this container
 
  frame.setMinimumSize(new Dimension(750,750));
  frame.pack(); // sizes contents at or above their preferred size
  frame.setVisible(true);


 }
}
