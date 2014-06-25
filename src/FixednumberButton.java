import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;


public class FixednumberButton extends JButton implements MouseListener {
	private DisplayedCalculationFormula dispCalc;

	/** πが取りうる値 */
    public static String PI = "π";

    /** ボタンを表示する定数を列挙した配列*/
    public static String FIXEDN[] = {PI};

    private String fixedn;



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
