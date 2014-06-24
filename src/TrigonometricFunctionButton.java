import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class TrigonometricFunctionButton extends JButton implements MouseListener{

	/** 画面表示 */
    private DisplayedCalculationFormula dispCalc;
    /** Sinが取りうる値 */
    public static String Sin = "Sin";
    /** Cosが取りうる値 */
    public static String Cos = "Cos";
    /** Tanが取りうる値 */
    public static String Tan = "Tan";
    /** radが取りうる値 */
    public static String rad = "rad";
    /** ボタンの表示と画面表示に用いる値を列挙した配列*/
    public static String FANCTION[] = {Sin,Cos,Tan,rad};

    /** 割り当てられた三角関数 */
    private String tfanction;

    /** =ボタンを生成し、フィールドの演算器に引数の演算器を代入 */
    public TrigonometricFunctionButton(DisplayedCalculationFormula dispCalc,int i){
    	super(FANCTION[i]);
    	this.dispCalc=dispCalc;
    	tfanction = FANCTION[i];
    	addMouseListener(this);
    }
    /** ＝ボタンが押された */
    public void mouseClicked(MouseEvent e){
     	dispCalc.setDisplayedCalculationFormula(tfanction+"(");
    	dispCalc.setSlashCalculationFormula("/"+tfanction+"/"+"/"+"("+"/");
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
