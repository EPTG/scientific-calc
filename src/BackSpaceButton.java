import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**   Deleteボタンの生成とボタンが押された際の処理を行う */
public class BackSpaceButton extends JButton implements MouseListener{

    /** 表示する数式 */
    private DisplayedCalculationFormula dispNumber;

    /** Deleteボタンを生成し,フィールドの表示する数に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる。*/
	public BackSpaceButton(DisplayedCalculationFormula dispNumber){
		super("BS");
		this.dispNumber =dispNumber;
		addMouseListener(this);
	}


    /** Delボタンが押された時の処理 表示する数式の1文字削除メソッドを呼び出す */
    public void mouseClicked(MouseEvent e){
    	dispNumber.Delate();
    	Calc.calc.requestFocus();
    }
    /**使用しない*/
    public void mouseEntered(MouseEvent e){}
    /**使用しない*/
    public void mouseExited(MouseEvent e){}
    /**使用しない*/
    public void mousePressed(MouseEvent e){}
    /**使用しない*/
    public void mouseReleased(MouseEvent e){}
}



