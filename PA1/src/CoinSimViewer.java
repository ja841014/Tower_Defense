// it is same function as CarViewer
/*
 *  Contains the main method. 
 *  Prompts for the number of trials, and creates the JFrame containing the CoinSimComponent. 
 *  Besides CoinSimComponent, this class does not depend on any of the other classes mentioned here 
 *  (e.g., if one of those other classes changed, CoinSimViewer would not have to change.) 
 *  The later section on communicating information between objects will be useful 
 *  when developing this and the next class listed.
 * */
import java.util.Scanner;

import javax.swing.JFrame;

public class CoinSimViewer
{
   public static void main(String[] args)
   {
	  Scanner scan = new Scanner(System.in);
	  CoinTossSimulator sim = new CoinTossSimulator();
	  int num = 0;
	  boolean checkValid = false;
	  
	  while(checkValid == false) {
		  System.out.println("How many trials do you want to play? ");
		  num = scan.nextInt();
		  if(num <= 0) {
			  System.out.println("ERROR: The number is not avaliable.");
		  }
		  else {
			  sim.run(num);
			  checkValid = true;
			  scan.close();
		  }
	  }
	  
	  
	  
	  
      JFrame frame = new JFrame();

      frame.setSize(800, 500);
      frame.setTitle("Coin Simulation");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      CoinSimComponent component = new CoinSimComponent(sim.getTwoHeads(), sim.getTwoTails(), sim.getHeadTails(), sim.getNumTrials());
      frame.add(component);

      frame.setVisible(true);
   }
}
