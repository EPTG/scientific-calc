import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;


public class KeyboardListener extends JFrame implements KeyListener {

	private NumButton[] numButton;
	private int KeyCode;

	public KeyboardListener(NumButton[] numButton){
		this.numButton = numButton;
		addKeyListener(this);
		setFocusable(true);
	}

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {
		KeyCode=e.getKeyCode();
		System.out.println(KeyCode);
		if(KeyCode>=96 || KeyCode<=105 ){
			this.numButton[KeyCode-96].doClick(100);
		}
	}
	public void keyTyped(KeyEvent e) {}
}
