package data;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Screen extends JPanel implements Runnable{
	
	Thread thread = new Thread(this);
	Frame frame;
	/** Account*/
	User user;
	
	private int fps = 0; // frame per second
	
	public int scene;
	
	public boolean running = false;
	

	public Screen(Frame frame) {
		this.frame = frame;
		System.out.println(this.frame.getWidth());
		// let game can click sth
		this.frame.addKeyListener(new KeyHandler(this)); // this screen
		
		// if we do not have this line, we will not execute run method.
		thread.start();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// if we paint layer on layer on. will cause computer slow
		// this.frame is point to the Frame class
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
		
		
		if(scene == 0) {
			// Main scrren sis blue
			g.setColor(Color.BLUE);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight() );

		}
		// in the game
		else if(scene == 1){
			g.setColor(Color.GREEN);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight() );
			
			// draw the map
			g.setColor(Color.GRAY);
			double width = (this.frame.getWidth() / (1440.0 / 1100.0) ) / 22.0;
			double height = (this.frame.getHeight() / (826.0 / 650.0) ) / 13.0;
			for(int x = 0; x < 22; x++) {
				for(int y = 0; y < 13; y++) {
					
					g.drawRect(50 + (x * 50), 50 + (y * 50), (int)width, (int)height);
					
				}
			}
			// Health + Money thing
			g.drawRect(12, (14*50) + 25, 125, ((826 - (14 * 50)) - 25 - 25) / 3 );
			g.drawRect(12, (14*50) + 25 + ((826 - (14 * 50)) - 25 - 25) / 3, 125, ((826 - (14 * 50)) - 25 - 25) / 3 );
			g.drawRect(12, (14*50) + 25 + 2*(((826 - (14 * 50)) - 25 - 25) / 3), 125, ((826 - (14 * 50)) - 25 - 25) / 3 );
			
			// Tower scroll List button
			g.drawRect(12 + 12 + 125, 14*50 + 25, 40, (826 - (14 * 50)) - 25 - 25);
			
			//	Tower List
			for(int i = 0; i < 20; i ++) {
				for(int j = 0; j < 2; j++) {
					if(Tower.towerlist[i * 2 + j] != null) {
						g.drawImage(Tower.towerlist[i * 2 + j].texture, (int) (12  + 12 + 125 + 12 + 40 + i * width), 14*50 + 12 + j * (int)height, null);
					}
					g.drawRect((int) (12  + 12 + 125 + 12 + 40 + i * width), 14*50 + 12 + j * (int)height, (int)width, (int)height);
				}
			}
			
		}
		
		
		else {
			g.setColor(Color.WHITE);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight() );

		}
		
		
		// FPS AT THE BOTTOM  10 pixel to right and 10 pixel to down
		g.drawString(fps + "", 10, 10);

	}
	
	//Only for first time
	public void loadGame() {
		user = new User(this);
		
		running = true;
				
	}
	
	public void startGame(User user) {
		user.createPlayer();
		
		this.scene = 1; //level 1
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Success Frame Created");
		// last time we update our fps
		long lastframe = System.currentTimeMillis();
		int frames = 0;
		
		loadGame();
		// the entire game run. all the thing run in here.
		while(running) {
			// draw sth on the screen
			repaint();
			
			frames++;
			
			// when we meet 1 second
			if(System.currentTimeMillis() - 1000 >= lastframe) {
				fps = frames;
				frames = 0;
				lastframe = System.currentTimeMillis();
			}
			try {
				Thread.sleep(2);// we sleep 2 mili second every single frame
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
	
	
	
	public class KeyTyped {
		public void keyESC() {
			running = false;
		}

		public void keySPACE() {
			// TODO Auto-generated method stub
			startGame(user);
		}
	}
}
