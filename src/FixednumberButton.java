import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/**   定数(πやe)ボタンの生成とボタンが押された際の処理を行う */
public class FixednumberButton extends JButton implements MouseListener {

	/** 表示する数式*/
	private DisplayedCalculationFormula dispCalc;

	/** πが取りうる値 */
    public static String PI = "π";
    /** Ansが取りうる値*/
    public static String ANS = "Ans";
    /** eが取りうる値*/
    public static String E = "e";
    /** ボタンを表示する定数を列挙した配列*/
    public static String FIXEDN[] = {PI,ANS,E};
    /** 割り当てられた定数*/
    private String fixedn;


    /** 引数で指定した定数でボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる */
	public FixednumberButton(DisplayedCalculationFormula dispCalc,int i){
    	super(FIXEDN[i]);
    	this.dispCalc=dispCalc;
    	fixedn=FIXEDN[i];
    	addMouseListener(this);

    }

	/** 定数ボタンが押された、表示する数式に引数で指定された定数の追加を行う。* */
	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		dispCalc.setDisplayedCalculationFormula(fixedn);
    	dispCalc.setSlashCalculationFormula("/"+fixedn+"/");
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
