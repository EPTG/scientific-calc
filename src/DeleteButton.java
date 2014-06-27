import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class DeleteButton extends JButton implements MouseListener{

    /** 表示する数式 */
    private DisplayedCalculationFormula dispNumber;

    /** フィールドの表示する数に引数の表示する数式を代入*/
	public DeleteButton(DisplayedCalculationFormula dispNumber){
		super("Del");
		this.dispNumber =dispNumber;
		addMouseListener(this);
	}


    /** Delボタンが押された時の処理 表示する数式の1文字削除メソッドを呼び出す */
    public void mouseClicked(MouseEvent e){
    	/*必要な処理を後でかく*/
    	/*cボタンは演算器の初期化と表示する数の初期化を行う*/
    	dispNumber.Delate();
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



