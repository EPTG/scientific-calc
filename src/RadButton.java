import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/** 三角関数ボタンの生成とボタンが押された際の処理を行う */
public class RadButton extends JButton implements MouseListener{

	/** 画面表示 */
    private DisplayedCalculationFormula dispCalc;
    /** radが取りうる値 */
    public static String RAD= "rad";


    /** RADボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる */
    public RadButton(DisplayedCalculationFormula dispCalc){
    	super(RAD);
    	this.dispCalc=dispCalc;
    	addMouseListener(this);
    }
    /** Radボタンが押された時の動作、表示する数式に"rad"の追加を行う。*/
    public void mouseClicked(MouseEvent e){
     	dispCalc.setDisplayedCalculationFormula(RAD+"(");
    	dispCalc.setSlashCalculationFormula("/"+RAD+"/"+"/"+"("+"/");
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
