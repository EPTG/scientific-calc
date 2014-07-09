import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** Cボタンの表示とCボタンが押された際の処理を行う */
public class ClearButton extends JButton implements MouseListener{

    /** 表示する数式 */
    private DisplayedCalculationFormula dispNumber;
    /** 演算器 */
    private ArithmeticUnit arithmUnit;


    /** フィールドの表示する数と演算器に引数の表示する数式と演算器を代入 */
    public ClearButton(ArithmeticUnit arithmUnit,DisplayedCalculationFormula dispNumber){
    	super("C");
    	this.dispNumber = dispNumber;
    	this.arithmUnit = arithmUnit;
    	addMouseListener(this);
    }

    /** Cボタンが押された時の処理 演算器の初期化と表示する数列の初期化,初期入力フラグのリセットを行う */
    public void mouseClicked(MouseEvent e){
    	/*必要な処理を後でかく*/
    	/*cボタンは演算器の初期化と表示する数の初期化を行う*/
    	dispNumber.clear();
    	arithmUnit.Clear();
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
