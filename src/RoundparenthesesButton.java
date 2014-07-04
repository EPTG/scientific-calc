import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 括弧ボタンの生成とボタンが押された際の処理を行う */
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

    /** 引数で与えられた括弧でボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入 。その後ボタンが押されたことを聞きつける状態になる。*/
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
