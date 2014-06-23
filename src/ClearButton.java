import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** Cボタンの生成とCボタンが押された際の処理を行う */
public class ClearButton extends JButton implements MouseListener{

    /** 表示する数 */
    private DisplayedCalculationFormula dispNumber;

    /** 演算器 */

    /** フィールドの表示する数と演算器に引数の表示する数と演算器を代入 */
    public ClearButton( DisplayedCalculationFormula dispNumber){
    	super("C");
    	this.dispNumber = dispNumber;
    	addMouseListener(this);
    }

    /** Cボタンが押された時の処理 演算器の初期化と表示する数の初期化,初期入力フラグのリセットを行う */
    public void mouseClicked(MouseEvent e){
    	/*必要な処理を後でかく*/
    	/*cボタンは演算器の初期化と表示する数の初期化を行う*/
    	dispNumber.clear();
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
