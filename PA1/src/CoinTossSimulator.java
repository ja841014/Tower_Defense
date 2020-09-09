import java.util.Random;

// Name:
// USC NetID:
// CS 455 PA1
// Fall 2020

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {

	private int numTrials;
	private int TwoHeads;
	private int TwoTails;
	private int HeadTail;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
	   numTrials = 0;
	   TwoHeads = 0;
	   TwoTails = 0;
	   HeadTail = 0;
   }


   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
	   this.numTrials = numTrials + this.numTrials;
	   calculate(numTrials);
//	   System.out.println("run method: "+TwoHeads + TwoTails + HeadTail);
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
//	   System.out.println(this.numTrials);
       return this.numTrials; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
//	   System.out.println(this.TwoHeads);
       return TwoHeads; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
//	   System.out.println(this.TwoTails);
       return TwoTails; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
//	   System.out.println(this.HeadTail);
       return HeadTail; // DUMMY CODE TO GET IT TO COMPILE
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
	   numTrials = 0;
	   TwoHeads = 0;
	   TwoTails = 0;
	   HeadTail = 0;
   }
   
   
   private void calculate(int numTrials) {
	   Random rand = new Random(); 
	   for(int i = 0; i < numTrials; i++) {
		   // 0 ~ 99
		   int ans1 = rand.nextInt(100);
		   int ans2 = rand.nextInt(100);
	
		   if(ans1 < 50 && ans2 < 50) {
			   TwoHeads++;
		   }
		   else if(ans1 >= 50 && ans2 >= 50){
			   TwoTails++;
		   }
		   else {
			   HeadTail++;
		   }
	   }
   }

}
