import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** =ボタンの生成と=ボタンが押された際の処理を行う */
public class EqualButton extends JButton implements MouseListener{

	/** 演算器 */
    private ArithmeticUnit arithmUnit;
    private DisplayedCalculationFormula dispCalc;
    /** =ボタンを生成し、フィールドの演算器に引数の演算器を代入 */
    public EqualButton(ArithmeticUnit arithmUnit,DisplayedCalculationFormula dispCalc){
    	super("=");
    	this.arithmUnit = arithmUnit;
    	this.dispCalc=dispCalc;
    	addMouseListener(this);
    }
    /** ＝ボタンが押された */
    public void mouseClicked(MouseEvent e){
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
   	/** 使用しない */
    public void mouseEntered(MouseEvent e){}
	/** 使用しない */
    public void mouseExited(MouseEvent e){}
	/** 使用しない */
    public void mousePressed(MouseEvent e){}
	/** 使用しない */
    public void mouseReleased(MouseEvent e){}
}
