import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
/** ドットボタンの表示とドットボタンが押された際の処理を行う */
public class DotButton extends JButton implements ActionListener{

    /** 表示する数 */
    private DisplayedCalculationFormula dispNumber;

    /** フィールドの表示する数に引数の表示する数を代入、ボタンの状態の監視を始める。 */
    public DotButton(DisplayedCalculationFormula dispNumber){
    	super(".");
    	this.dispNumber=dispNumber;
    	addActionListener(this);
    }
    /** ドットボタンが押された時の動作、表示する数式に”.”の追加を行う*/
	public void actionPerformed(ActionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		dispNumber.setDisplayedCalculationFormula(".");
		dispNumber.setSlashCalculationFormula(".");
		Calc.calc.requestFocus();
	}
}
