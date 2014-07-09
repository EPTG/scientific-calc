import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

/** キーボードからの入力を監視するクラス　*/
public class KeyboardListener extends JFrame implements KeyListener {
	/** 数字ボタン */
	private NumButton[] numButton;
	/** 演算器号ボタン */
	private OpButton[] opButton;
	/** 小数点ボタン */
	private DotButton dotButton;
	/** イコールボタン */
	private EqualButton equalButton;
	/** キーボードからの入力（キーコード） */
	private int KeyCode;

	/** 引数の数字ボタン、演算器号ボタン、小数点ボタン、イコールボタンをそれぞれフィールド変数に代入して、キーボードからの入力を聞きつける状態になる */
	public KeyboardListener(NumButton[] numButton,OpButton[] opButton,DotButton dotButton,EqualButton equalButton){
		this.numButton = numButton;
		this.opButton = opButton;
		this.dotButton = dotButton;
		this.equalButton = equalButton;
		addKeyListener(this);
		setFocusable(true);
	}

	/** 使用しない */
	public void keyPressed(KeyEvent e) {}

	/** キーが離された瞬間にキーコードを取得し、キーコードに対応したボタンをクリックしたことにする*/
	public void keyReleased(KeyEvent e) {
		KeyCode=e.getKeyCode();
		System.out.println(KeyCode);
		if(KeyCode>=96 && KeyCode<=105 ){
			this.numButton[KeyCode-96].doClick();
		}
		else if (KeyCode == 107) {
			this.opButton[0].doClick();
		}
		else if (KeyCode == 109) {
			this.opButton[1].doClick();
		}
		else if (KeyCode == 106) {
			this.opButton[2].doClick();
		}
		else if (KeyCode == 111) {
			this.opButton[3].doClick();
		}
		else if (KeyCode == 110){
			this.dotButton.doClick();
		}
		else if (KeyCode == 10){
			this.equalButton.doClick();
		}
	}
	/** 使用しない */
	public void keyTyped(KeyEvent e) {}
}
