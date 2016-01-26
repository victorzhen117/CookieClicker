import javax.swing.*;

public class Cookie
{
  public static void main (String[] args)
  {
    //
    try {
      UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    //create a JOptionPane called pane
    JOptionPane pane = new JOptionPane();
    
    //creates an array named choices which is used later in a drop down menu
    String[] choices = {"Standard", "Sandbox"};
    
    String s = (String) JOptionPane.showInputDialog(pane,
                    "Which do you want to play?",
                                            "Display",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    choices,
                    "zzzzZZzzz");
    
    //creates a JFrame called frame
    JFrame frame = new JFrame ("Cookie Clicker");
    
    //allow the window to be closed
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    
    //if the input entered was standard, play standard mode
    //if the input entered was sandbox, play sandbox mode
    if(s.equals("Standard"))
      frame.getContentPane().add(new CookiePanel());
    
    if(s.equals("Sandbox"))
      frame.getContentPane().add(new CookiePanel(1000000000));
    
    
    //makes the frame visible and packed
    frame.pack();
    frame.setVisible(true);
    
    
    //creates 8 threads to help make 8 methods run at the same time
    Thread thread1 = new Thread() {
      public void run() {
        Clicker.increase();
      }
    };
    
    Thread thread2 = new Thread() {
      public void run() {
        Grandma.increase();
      }
    };
    Thread thread3 = new Thread() {
      public void run() {
        Factory.increase();
      }
    };
    
    Thread thread4 = new Thread() {
      public void run() {
        Mine.increase();
      }
    };
    
    Thread thread5 = new Thread() {
      public void run() {
        Shipment.increase();
      }
    };
    
    Thread thread6 = new Thread() {
      public void run() {
        AlchemyLab.increase();
      }
    };
    
    Thread thread7 = new Thread() {
      public void run() {
        Portal.increase();
      }
    };
    Thread thread8 = new Thread() {
      public void run() {
        TimeMachine.increase();
      }
    };
    
    //starts the threads to increment based on time
    thread1.start();
    thread2.start();
    thread3.start();
    thread4.start();
    thread5.start();
    thread6.start();
    thread7.start();
    thread8.start();
  }
}