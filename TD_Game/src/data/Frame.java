package data;

import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public static void main(String[] args) {
		new Frame();
	}
	
	public Frame() {
		
		JFrame jframe = new JFrame();
		//this.setSize(800, 600);
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// full screen
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setResizable(false);
		this.setVisible(true);
		// this.setLocationRelativeTo(null); // it will pop out in the middle
		
		
		Screen screen = new Screen(this);
		this.add(screen);// add our screen class print on our screen 
	}
}
