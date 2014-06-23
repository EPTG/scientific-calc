import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 数字ボタンの生成と数字ボタンが押された際の処理を行う */
public class DotButton extends JButton implements MouseListener{

    /** 表示する数 */
    private DisplayedCalculationFormula dispNumber;

    /** 引数で与えられた数字でボタンを生成し、フィールドの表示する数に引数の表示する数を代入 */
    public DotButton(DisplayedCalculationFormula dispNumber){
    	super(".");
    	this.dispNumber=dispNumber;
    	addMouseListener(this);
    }
    /** 数字ボタンが押された */
    public void mouseClicked(MouseEvent e){
	dispNumber.setDisplayedCalculationFormula(".");
	dispNumber.setSlashCalculationFormula(".");
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
