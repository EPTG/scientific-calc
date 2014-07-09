import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** 演算子ボタンの生成と演算子ボタンが押された際の処理を行う */
public class OpButton extends JButton implements ActionListener{

    /** +演算子(足し算記号).operatorが取りうる値 */
    public static String OP_PLUS = "+";
    /** -演算子(引き算記号).operatorが取りうる値 */
    public static String OP_MINUS = "-";
    /** ＊演算子(掛け算記号).operatorが取りうる値 */
    public static String OP_TIMES = "×";
    /** ／演算子(割り算記号).operatorが取りうる値 */
    public static String OP_DIVIDE = "÷";
    /** ^が取りうる値 */
    public static String OP_POW = "^";
    /** √が取りうる値 */
    public static String OP_ROOT = "√";
    /** 演算子が未選択であることを示す.operatorが取りうる値 */
    public static String OP_NONE = "";
    /** ボタンを表示する演算子を列挙した配列*/
    public static String OPERATORS[] = {OP_PLUS,OP_MINUS,OP_TIMES,OP_DIVIDE,OP_POW,OP_ROOT};

    /** 割り当てられた演算器号 */
    private String opStr;

    /** 表示する数式 */
    private DisplayedCalculationFormula dispcalcf;

    /** 引数で与えられた演算子でボタンを生成し、フィールドの演算器に引数の演算器を代入。その後ボタンが押されたことを聞きつける状態になる。 */
    public OpButton(DisplayedCalculationFormula dispcalcf,int i){
    	super(OPERATORS[i]);
    	this.dispcalcf = dispcalcf;
    	opStr=OPERATORS[i];
    	addActionListener(this);
    }

    /** 演算器号ボタンが押された 表示する数式に引数で指定された演算器号の追加を行う。*/
	public void actionPerformed(ActionEvent e) {
		if(opStr.equals(OP_ROOT)){
	    	dispcalcf.setDisplayedCalculationFormula(opStr+"(");
	        dispcalcf.setSlashCalculationFormula("/"+opStr+"/"+"/"+"("+"/");
	    	}
	    	else{
	    	dispcalcf.setDisplayedCalculationFormula(opStr);
	    	dispcalcf.setSlashCalculationFormula("/"+opStr+"/");
	    	}
	    	Calc.calc.requestFocus();
	}
}
