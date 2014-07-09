import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** =ボタンの生成と=ボタンが押された際の処理を行う */
public class EqualButton extends JButton implements ActionListener{

	/** 演算器 */
    private ArithmeticUnit arithmUnit;

    /** 表示する数式 */
    private DisplayedCalculationFormula dispCalc;

    /** =ボタンを生成し、フィールドの演算器と表示する数式に引数の演算器を代入。ボタンが押されたことを聞きつけるのを始める。 */
    public EqualButton(ArithmeticUnit arithmUnit,DisplayedCalculationFormula dispCalc){
    	super("=");
    	this.arithmUnit = arithmUnit;
    	this.dispCalc=dispCalc;
    	addActionListener(this);
    }

    /** ＝ボタンが押された時の動作。スラッシュ付きの数式を読み出し、文字列をスラッシュごとに切り分けて配列の要素とする。その配列をArrayListに変換し、演算を行う*/
    public void actionPerformed(ActionEvent e) {
		Calc.calc.requestFocus();
    	if(dispCalc.checkError()){
    		System.out.println("test");
    		return ;
    	}
    	try{
    	dispCalc.setNewDisplayedCalculationFormula(arithmUnit.operate(arithmUnit.convert(arithmUnit.split_op_num())));
    	}catch(IndexOutOfBoundsException e1){
			dispCalc.setText("配列Error");
		}catch(ArithmeticException e1){
			dispCalc.setText("BigdecimalError");
		}catch(NumberFormatException e1){
			dispCalc.setText("文字列Error");
		}

	dispCalc.setFlag();
    }
}
