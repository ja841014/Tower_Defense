/*
 * This program is used to test CoinTossSimulator class
 * 
 * */
public class CoinTossSimulatorTester {
	public static void main(String[] args) {
		// First Part
		CoinTossSimulator test = new CoinTossSimulator();
		System.out.println("After constructor: ");
		System.out.print("Number of trials [exp:0]: ");
		System.out.println(test.getNumTrials());
		System.out.print("Two-head tosses: ");
		System.out.println(test.getTwoHeads());
		System.out.print("Two-tail tosses: ");
		System.out.println(test.getTwoTails());
		System.out.print("One-head one-tail tosses: ");
		System.out.println(test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Second Part
		test.run(1);
		System.out.println("After run(1): ");
		System.out.println("Number of trials [exp:1]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Third Part
		test.run(10);
		System.out.println("After run(10): ");
		System.out.println("Number of trials [exp:11]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Forth Part
		test.run(100);
		System.out.println("After run(100): ");
		System.out.println("Number of trials [exp:111]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Fifth
		test.run(73);
		System.out.println("After run(73): ");
		System.out.println("Number of trials [exp:184]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Sixth
		test.run(16);
		System.out.println("After run(16): ");
		System.out.println("Number of trials [exp:200]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Seventh Reset
		test.reset();
		System.out.println("After reset: ");
		System.out.println("Number of trials [exp:0]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Eight
		test.run(1000);
		System.out.println("After run(1000): ");
		System.out.println("Number of trials [exp:1000]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		System.out.println();
		// Nineth
		test.run(1000);
		System.out.println("After run(1000): ");
		System.out.println("Number of trials [exp:1000]: " + test.getNumTrials());
		System.out.println("Two-head tosses: " + test.getTwoHeads());
		System.out.println("Two-tail tosses: " + test.getTwoTails());
		System.out.println("One-head one-tail tosses: " + test.getHeadTails());
		System.out.print("Tosses add up correctly? ");
		if(test.getNumTrials() == test.getTwoHeads() + test.getTwoTails() + test.getHeadTails()) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
		
		
		
	}
}