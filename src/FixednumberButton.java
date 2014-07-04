import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class FixednumberButton extends JButton implements MouseListener {
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


    //* 引数で指定した定数でボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる */
	public FixednumberButton(DisplayedCalculationFormula dispCalc,int i){
    	super(FIXEDN[i]);
    	this.dispCalc=dispCalc;
    	fixedn=FIXEDN[i];
    	addMouseListener(this);
    }

	public void mouseClicked(MouseEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ
		dispCalc.setDisplayedCalculationFormula(fixedn);
    	dispCalc.setSlashCalculationFormula("/"+fixedn+"/");
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
