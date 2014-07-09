import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** ドットボタンの表示とドットボタンが押された際の処理を行う */
public class DotButton extends JButton implements MouseListener{

    /** 表示する数 */
    private DisplayedCalculationFormula dispNumber;

    /** フィールドの表示する数に引数の表示する数を代入、ボタンの状態の監視を始める。 */
    public DotButton(DisplayedCalculationFormula dispNumber){
    	super(".");
    	this.dispNumber=dispNumber;
    	addMouseListener(this);
    }
    /** ドットボタンが押された時の動作、表示する数式に”.”の追加を行う*/
    public void mouseClicked(MouseEvent e){
	dispNumber.setDisplayedCalculationFormula(".");
	dispNumber.setSlashCalculationFormula(".");
	Calc.calc.requestFocus();
    }
    /** 使用しない */
    public void mouseEntered(MouseEvent e){}
    /** 使用しない */
    public void mouseExited(MouseEvent e){}
    /** 使用しない */
    public void mousePressed(MouseEvent e){}
    /** 使用しない */
    public void mouseReleased(MouseEvent e){}
}
