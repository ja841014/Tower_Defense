package data;
// Note: I do not change the thing in episode 13
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;



public class Screen extends JPanel implements Runnable{
	
	Thread thread = new Thread(this);
	
	Frame frame;
	Level level;
	LevelFile levelfile;
	EnemyAI enemyAI;
	Wave wave;
	
	/** Account*/
	User user;
	
	private int fps = 0; // frame per second
	
	
	public int scene;
	
	// hold a tower in the hand
	public int hand = 0;
	public int handXpos = 0;
	public int handYpos = 0;
	
	// TowerShop location
	int towerShop_X = 0;
	int towerShop_Y = 0;
	
	public boolean running = false;
	
	
	
	double towerwidth;
	double towerheight;
	public static double towerSize;
	
	
	public int[][] map = new int[22][13];
	public Tower[][] towerMap = new Tower[22][13];
	public Image[] terrain = new Image[100];
	
	// represent how many enemy on the map on the same time
	public EnemyMove[] enemyMap = new EnemyMove[200];
	private int enemies = 0;
	
	
	public String packagename = "data"; // maybe problem
	
	
	public Screen(Frame frame) {
		this.frame = frame;
		// let game can click sth
		this.frame.addKeyListener(new KeyHandler(this)); // this screen
		this.frame.addMouseListener(new MouseHandler(this));
		this.frame.addMouseMotionListener(new MouseHandler(this));
		// towersize = this.frame.getWidth() / 16 * 9 / 18
//		System.out.println(this.frame.getWidth());
//		towerWidth = (this.frame.getWidth() / (1440.0 / 1100.0) ) / 22.0;
//		towerHeight = (this.frame.getHeight() / (826.0 / 650.0) ) / 13.0;
//		System.out.println((this.frame.getWidth() / (1440.0 / 1100.0) ));
		// if we do not have this line, we will not execute run method.
		thread.start();
	}
	
	Graphics2D g;
	@Override
	public void paintComponent(Graphics g) {
		
		// if we paint layer on layer on. will cause computer slow
		// this.frame is point to the Frame class
		this.g = (Graphics2D) g;
		g.clearRect(0, 0, this.frame.getWidth(), this.frame.getHeight());
		if(scene == 0) {
			// Main screen sis blue
			g.setColor(new Color(30, 100, 100, 128));
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight() );
			g.setColor(Color.BLACK);
			g.setFont(new Font("Click Space to Start", Font.ITALIC, 76)); 
			g.drawString("Click Space to Start", 1440/2 - 350, 826 / 2);

		}
		// in the game
		else if(scene == 1){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.frame.getWidth(), this.frame.getHeight() );
			
			
			
			// draw the map
			g.setColor(Color.GRAY);
			towerwidth = (this.frame.getWidth() / (1440.0 / 1100.0) ) / 22.0;
			towerheight = (this.frame.getHeight() / (826.0 / 650.0) ) / 13.0;
			towerSize = towerwidth;
			
			for(int x = 0; x < 22; x++) {
				for(int y = 0; y < 13; y++) {
					g.drawImage(terrain[map[x][y]], (int)towerwidth + (x *(int)(towerwidth)), (int)towerheight + (y * (int)towerheight), (int)towerwidth, (int)towerheight, null);
					g.drawRect((int)towerwidth + (x * (int)towerwidth), (int)towerheight + (y * (int)towerheight), (int)towerwidth, (int)towerheight);
//					System.out.println((int)towerWidth);
				}
			}
			
			// Enemies
			for(int i = 0; i < enemyMap.length; i++) {
				if(enemyMap[i] != null) {
					// this may be problem because i did not change the boarder ep17 10:10
					g.drawImage(enemyMap[i].enemy.texture, (int)enemyMap[i].xPos + (int)towerwidth, (int)enemyMap[i].yPos + (int)towerheight, (int)towerwidth, (int)towerheight, null);
				}
			}
			
			
			// Health + Money thing 						//他這邊不是826 是900
			g.drawRect(12, (14*(int)towerheight) + 25, 125, ((this.frame.getHeight() - (14 * (int)towerheight)) - 25 - 25) / 3 );
			g.drawString("Health: " + user.player.health, 12 + 25, 14*(int)towerheight + 20 + 25);
			
			g.drawRect(12, (14*(int)towerheight) + 25 + ((this.frame.getHeight()- (14 * (int)towerheight)) - 25 - 25) / 3, 125, ((this.frame.getHeight() - (14 * (int)towerheight)) - 25 - 25) / 3 );
			g.drawString("Money: " + user.player.money, 12 + 25, 14*(int)towerheight + 20 + (int)towerheight);

			
			g.drawRect(12, (14*(int)towerheight) + 25 + 2*(((this.frame.getHeight() - (14 * (int)towerheight)) - 25 - 25) / 3), 125, ((this.frame.getHeight() - (14 * (int)towerheight)) - 25 - 25) / 3 );
			
			// Tower scroll List button
			g.drawRect(12 + 12 + 125, 14*(int)towerheight  + 25, this.frame.getWidth() / 40, (this.frame.getHeight() - (14 * (int)towerheight )) - 25 - 25);
			
			towerShop_X = (int) (12  + 12 + 125 + 12 + 40 );
			towerShop_Y = (int)(14*50 + 12);
			
			//	Tower shop List
			for(int i = 0; i < 18; i ++) {
				for(int j = 0; j < 2; j++) {
					if(Tower.towerlist[i * 2 + j] != null) {
						/**
						 * parameter1 : Image
						 * parameter2 : Image start x
						 * parameter3 : Image start y
						 * parameter4 : expand x
						 * parameter4 : expand y
						 * parameter5 : ImageObserver
						 *  */
						g.drawImage(Tower.towerlist[i * 2 + j].texture, (int) (12  + 12 + 125 + 12 + this.frame.getWidth() / 40 + i * towerwidth), 14*(int)towerheight + 12 + j * (int)towerheight, (int)towerwidth,(int)towerheight, null);
						if(Tower.towerlist[i * 2 + j].cost > this.user.player.money) {
							g.setColor(new Color(255, 0, 0,100));
							g.fillRect((int) (12  + 12 + 125 + 12 + this.frame.getWidth() / 40 + i * towerwidth), 14*(int)towerheight  + 12 + j * (int)towerheight, (int)towerwidth,(int)towerheight);
						}
						
					}
					g.setColor(Color.GRAY);
					g.drawRect((int) (12  + 12 + 125 + 12 + this.frame.getWidth() / 40 + i * towerwidth), 14*(int)towerheight  + 12 + j * (int)towerheight, (int)towerwidth, (int)towerheight);
					
				}
			}
			// Tower on Grid
			for(int x = 0; x < 22; x++) {
				for(int y = 0; y < 13; y++) {
					if(towerMap[x][y] != null) {
						// draw big circle for shoooting area
						g.setColor(Color.GRAY);
						g.drawOval((int)towerwidth + (x * (int)towerwidth) - (towerMap[x][y].range * 2 * (int)towerwidth + (int)towerwidth) / 2 + (int)towerwidth / 2, (int)towerheight + (y * (int)towerheight) - (towerMap[x][y].range * 2 * (int)towerheight + (int)towerheight) / 2 + (int)towerheight / 2, towerMap[x][y].range * 2 * (int)towerwidth + (int)towerwidth , towerMap[x][y].range * 2 * (int)towerheight + (int)towerheight);
						// fill the tranparent int light gray circle
						g.setColor(new Color(64,64,64,64));
						g.fillOval((int)towerwidth + (x * (int)towerwidth) - (towerMap[x][y].range * 2 * (int)towerwidth + (int)towerwidth) / 2 + (int)towerwidth / 2, (int)towerheight + (y * (int)towerheight) - (towerMap[x][y].range * 2 * (int)towerheight + (int)towerheight) / 2 + (int)towerheight / 2, towerMap[x][y].range * 2 * (int)towerwidth + (int)towerwidth , towerMap[x][y].range * 2 * (int)towerheight + (int)towerheight);
						g.drawImage(Tower.towerlist[towerMap[x][y].id].texture, (int)towerwidth + (x * (int)towerwidth), (int)towerheight + (y * (int)towerheight), (int)towerwidth, (int)towerheight, null);
						
						// if tower attacking draw shooting
						if(towerMap[x][y].target != null) {
							g.setColor(Color.ORANGE);
							g.drawLine((int)towerwidth + (x * (int)towerwidth) + (int)towerSize / 2, (int)towerheight + (y * (int)towerheight) + (int)towerSize / 2, (int)towerSize + (int)towerMap[x][y].target.xPos + (int)towerSize / 2, (int)towerSize + (int)towerMap[x][y].target.yPos + (int)towerSize / 2);
						}
					}
				}
				
			}
			
			
			// HAND
			if (hand != 0 && Tower.towerlist[hand - 1] != null) {
				g.drawImage(Tower.towerlist[hand - 1].texture, this.handXpos - (int)this.towerwidth / 2, this.handYpos - (int)this.towerheight / 2, (int)this.towerwidth, (int)this.towerheight, null);
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
		levelfile = new LevelFile();
		ClassLoader c1 = this.getClass().getClassLoader();
		wave = new Wave(this);
		
		for(int y = 0; y < 10; y++) {
			for(int x = 0; x < 10; x++) {
				terrain[x + (y * 10)] = new ImageIcon(c1.getResource(packagename + "/terrain.png")).getImage();
				terrain[x + (y * 10)] = createImage(new FilteredImageSource(terrain[x + (y * 10)].getSource(), new CropImageFilter(x*25, y*25, 25, 25) ));
			}
		}
		
		running = true;
				
	}
	/**
	 *  Each time you start a level
	 *  @param user
	 *  @param level
	 *  */
	public void startGame(User user, String level) {
		user.createPlayer();
		
		this.level = levelfile.getlevel(level);
		this.level.findSpawnPoint();
		this.map = this.level.map;
		
		this.enemyAI = new EnemyAI(this.level);
		
		this.scene = 1; //level 1
		this.wave.waveNumber = 0;
		
	}
	
	
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Success Frame Created");
		// last time we update our fps
		long lastframe = System.currentTimeMillis();
		int frames = 0;
		int synchronized_fps = 0;

		
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
			
			
//			update();
			double time = (double)System.currentTimeMillis() / 1000;
			int timeMillisSec = (int)Math.round((time - (int)time) * 1000);
			
			// every 40 frame we update
			if( timeMillisSec > synchronized_fps * 1000 / 25) { //Systme.currentTimeMillis() / 30 
				synchronized_fps++;
				update();
				if(synchronized_fps == 1000 / 25) {
					synchronized_fps = 0;
				}
			}
			
			if(timeMillisSec + 1000/25 < synchronized_fps * 1000 / 25) {
				synchronized_fps = 0;
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
	
	public void enemyUpdate() {
		for(int i = 0; i < enemyMap.length; i++) {
			if(enemyMap[i] != null) {
				if(!enemyMap[i].attack) {
					EnemyAI.moveAI.move(enemyMap[i]);
				}
				// this method is make them die
				enemyMap[i] = enemyMap[i].update(); //Currently Only check if they are dead or not
			}
		}
	}
	
	public void towerUpdate() {
		for(int x = 0; x < 22; x++) {
			for(int y = 0; y < 13; y++) {
				// the all tower on my Tower
				if(towerMap[x][y] != null) {
					towerAttack(x, y);
				}
			}
		}
	}
	
	public void towerAttack(int x, int y) {
		// if this tower do not have enemy
		if(this.towerMap[x][y].target == null) {
			// Find a target for our tower
			if(this.towerMap[x][y].attackDelay > this.towerMap[x][y].maxAttackDelay) {
				EnemyMove currentEnemy = this.towerMap[x][y].calculateEnemy(enemyMap, x, y);
				
				if(currentEnemy != null) {
					currentEnemy.health -= this.towerMap[x][y].damage;
					
					this.towerMap[x][y].target = currentEnemy;
					this.towerMap[x][y].attackTime = 0;
					this.towerMap[x][y].attackDelay = 0; 
					
					System.out.println("[Tower] Enemy Attack! health: " + currentEnemy.health + " x: " + x +" y: " + y);
				}
			}
			else {
				this.towerMap[x][y].attackDelay += 1;
			}
		}
		else {
			if(this.towerMap[x][y].attackTime < this.towerMap[x][y].maxAttackTime) {
				this.towerMap[x][y].attackTime += 1;
			}
			else {
				// is we set it to null, we have to find a enemy again
				this.towerMap[x][y].target = null;
			}
		}
	}
	
	public void update() {
		
		enemyUpdate();
		towerUpdate();
		
		if(wave.waveSpawning == true) {
			wave.spawnEnemies();
		}
	}
	
	
	public void spawnEnemy(int enemyID) {
		for(int i = 0; i < enemyMap.length; i++) {
			// if it is not null, we know there already has a enemy there
			if(enemyMap[i] == null) {
				enemyMap[i] = new EnemyMove(Enemy.enemyList[enemyID], level.spawnPoint);
				break;
			}
			else {
				System.out.println("[Screen spawnEnemy]::contain enemy");
			}
		}
	}
	
	
	
	public void placeTower(int x, int y) {
		// if we do not place accurately on the grid , it will automatically choose the nearst one grid
		int xPos = x / (int)towerwidth;
		int yPos = y / (int)towerheight;
		
		if(xPos >=0 && xPos <= 22 && yPos > 0 && yPos <= 13 ) {
			xPos = xPos - 1;
			yPos = yPos - 1;
			if(towerMap[xPos][yPos] == null && map[xPos][yPos] == 0) {
				user.player.money = user.player.money - Tower.towerlist[hand - 1].cost;
				
				towerMap[xPos][yPos] = (Tower) Tower.towerlist[hand - 1].clone();
			}
		}		
	}
	
	public class MouseHeld {
		
		boolean mouseDown = false;
		
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			handXpos = e.getXOnScreen();
			handYpos = e.getYOnScreen();
		}
		public void updateMouse(MouseEvent e) {
			if(scene == 1) {
				if(mouseDown == true && hand == 0) {
					// in the shop area X , Y 軸很奇怪 差了大概２５pixal
					if(e.getXOnScreen() >= towerShop_X && e.getXOnScreen() <= towerShop_X + (int)(towerwidth * 20) && e.getYOnScreen() >= towerShop_Y + 25 && e.getYOnScreen() <= towerShop_Y  + (int)(towerheight * 2) + 25) {
						for(int i = 0; i < Tower.towerlist.length; i++) {
							// buy the first tower, so hand is 1
							if(e.getXOnScreen() >= towerShop_X + (i / 2) * (int)towerSize && e.getXOnScreen() <= towerShop_X + (int)towerwidth + (i / 2) * (int)towerSize && e.getYOnScreen() >= towerShop_Y + 25 + (i % 2) * (int)towerSize && e.getYOnScreen() <= towerShop_Y+ (int)towerheight + 25 + (i % 2) * (int)towerSize ) {
								if(user.player.money >= Tower.towerlist[i].cost) {
									System.out.println("[Shop] You bought a tower for" + Tower.towerlist[i].cost + "!");
									hand = i + 1;
									
									return;
								}
							}
						}
						
					}
				}
			}
		}
		public void mouseDown(MouseEvent e) {
			// TODO Auto-generated method stub
			mouseDown = true;
			if(hand != 0) {
				//這裡可能有問題
				placeTower(e.getXOnScreen(), e.getYOnScreen());
				hand = 0;
				
			}
			updateMouse(e);
		}
		
	}

	
	public class KeyTyped {
		public void keyESC() {
			running = false;
		}
		
		public void keyENTER() {
			wave.nextWave();
		}

		public void keySPACE() {
			// TODO Auto-generated method stub
			
			startGame(user, "Level1");
		}
	}
}
