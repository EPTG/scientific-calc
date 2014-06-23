import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 演算子ボタンの生成と演算子ボタンが押された際の処理を行う */
public class OpButton extends JButton implements MouseListener{

    /** +演算子(足し算記号).operatorが取りうる値 */
    public static String OP_PLUS = "+";
    /** -演算子(引き算記号).operatorが取りうる値 */
    public static String OP_MINUS = "-";
    /** ＊演算子(掛け算記号).operatorが取りうる値 */
    public static String OP_TIMES = "×";
    /** ／演算子(割り算記号).operatorが取りうる値 */
    public static String OP_DIVIDE = "÷";
    /** 演算子が未選択であることを示す.operatorが取りうる値 */
    public static String OP_NONE = "";
    /** ボタンを表示する演算子を列挙した配列*/
    public static String OPERATORS[] = {OP_PLUS,OP_MINUS,OP_TIMES,OP_DIVIDE};


    /** 割り当てられた演算器号 */
    private String opStr;

    /** 演算器 */
    private DisplayedCalculationFormula dispcalcf;

    /** 引数で与えられた演算子でボタンを生成し、フィールドの演算器に引数の演算器を代入 */
    public OpButton(DisplayedCalculationFormula dispcalcf,int i){
    	super(OPERATORS[i]);
    	this.dispcalcf = dispcalcf;
    	opStr=OPERATORS[i];
    	addMouseListener(this);
    }

    /** 演算器号ボタンが押された */
    public void mouseClicked(MouseEvent e){
    	dispcalcf.setDisplayedCalculationFormula(opStr);
    	dispcalcf.setSlashCalculationFormula("/"+opStr+"/");
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
