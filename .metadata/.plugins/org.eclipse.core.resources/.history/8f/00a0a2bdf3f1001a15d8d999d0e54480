package data;

import java.awt.Image;
public class Tower {
	
	public String textureFile = "";
	public Image texture;
	
	// tower array;
	public static final Tower[] towerlist = new Tower[200];
	
	public static final Tower lightningTower = new TowerLightning(0).getTextureFile("");
	
	public int id;
	
	
	public Tower(int id) {
		if(towerlist[id] != null) {
			System.out.println("Tower Initialization: Two tower with same ID: ID : " + id);
		}
		else {
			towerlist[id] = this;
			this.id = id;
		}
	}
	
	public Tower getTextureFile(String str) {
		this.textureFile = str;
		
		return null;
	}
}