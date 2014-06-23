import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 演算子ボタンの生成と演算子ボタンが押された際の処理を行う */
public class RoundparenthesesButton extends JButton implements MouseListener{

    /** (が取りうる値 */
    public static String RpareL = "(";
    /** )が取りうる値 */
    public static String RpareR = ")";

    /**ボタンを表示する演算子を列挙した配列*/
    private static String Rpares[]={RpareL,RpareR};

    /** 割り当てられた演算器号 */
    private String Rpare;

    /** 演算器 */
    private DisplayedCalculationFormula dispcalcf;

    /** 引数で与えられた演算子でボタンを生成し、フィールドの演算器に引数の演算器を代入 */
    public RoundparenthesesButton(DisplayedCalculationFormula dispcalcf,int i){
    	super(Rpares[i]);
    	this.dispcalcf = dispcalcf;
    	Rpare=Rpares[i];
    	addMouseListener(this);
    }

    /** 演算器号ボタンが押された */
    public void mouseClicked(MouseEvent e){
    	dispcalcf.setDisplayedCalculationFormula(Rpare);
    	dispcalcf.setSlashCalculationFormula("/"+Rpare+"/");
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
