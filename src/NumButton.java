import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 数字ボタンの生成と数字ボタンが押された際の処理を行う */
public class NumButton extends JButton implements MouseListener{

    /** 割り当てられた数字 */
    private String digit;

    /** (が取りうる値 */
    public static String RpareL = "(";

    /** )が取りうる値 */
    public static String RpareR = ")";

    /**ボタンに表示する数字を列挙した配列*/
    private static String Numbers[]={"0","1","2","3","4","5","6","7","8","9",RpareL,RpareR};

    /** 表示する数 */
    private DisplayedCalculationFormula dispCalcf;

    /** 引数で与えられた数字でボタンを生成し、フィールドの表示する数に引数の表示する数を代入 */
    public NumButton(DisplayedCalculationFormula dispCalcf,int i){
    	super(Numbers[i]);
    	this.dispCalcf=dispCalcf;
    	digit=Numbers[i];
    	addMouseListener(this);
    }
    /** 数字ボタンが押された */
    public void mouseClicked(MouseEvent e){
    if(digit.equals(RpareL) || digit.equals(RpareR)){
    	dispCalcf.setDisplayedCalculationFormula(digit);
    	dispCalcf.setSlashCalculationFormula("/"+digit+"/");
    	}
    else{
    	dispCalcf.setDisplayedCalculationFormula(digit);
    	dispCalcf.setSlashCalculationFormula(digit);
    	}
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
