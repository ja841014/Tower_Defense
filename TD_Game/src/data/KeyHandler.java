package data;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
	
	
	private Screen screen;
	private Screen.KeyTyped keyTyped;
	
	
	// constructor screen has a frame
	public KeyHandler(Screen screen) {
		this.screen = screen;
		this.keyTyped = this.screen.new KeyTyped();
		
	}
	
	
	// click keyboard every single time
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode();
		System.out.println(e.getKeyCode());
		// 27 is esc button keycode, when we press "esc" will close rhe game
		if(keyCode == 27) {
			this.keyTyped.keyESC();
		}
		// 32 is whit space
		if(keyCode == 32) {
			this.keyTyped.keySPACE();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

}
