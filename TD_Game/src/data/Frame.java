package data;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Frame extends JFrame{
	
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Frame();
			}
		});
		
	}
	
	public Frame() {
		new JFrame();
//		JFrame jframe = new JFrame();
		
		this.setTitle("Tower Defense");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setSize(1440, 826);
		// full screen
		this.setExtendedState(MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setResizable(false);
//		this.pack();
		this.setVisible(true);
		// this.setLocationRelativeTo(null); // it will pop out in the middle
		System.out.println(this.getWidth());
		
		Screen screen = new Screen(this);
		this.add(screen);// add our screen class print on our screen 
	}
}
