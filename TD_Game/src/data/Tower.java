package data;

import java.awt.Image;

import javax.swing.ImageIcon;
public class Tower {
	
	public String textureFile = "";
	public Image texture;
	
	// tower array;
	public static final Tower[] towerlist = new Tower[200];
	
	public static final Tower lightningTower = new TowerLightning(0, 10).getTextureFile("lightningtower");
	
	public int id;
	public int cost;
	
	public Tower(int id, int cost) {
		if(towerlist[id] != null) {
			System.out.println("Tower Initialization: Two tower with same ID: ID : " + id);
		}
		else {
			towerlist[id] = this;
			this.id = id;
			this.cost = cost;
		}
	}
	// get image
	public Tower getTextureFile(String str) {
		this.textureFile = str;
		this.texture = new ImageIcon("res/Tower/" + this.textureFile + ".png").getImage();
		
		
		return null;
	}
}