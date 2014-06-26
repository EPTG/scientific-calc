import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class PowButton extends JButton implements MouseListener {

	/** ^が取りうる値 */
    public static String Pow = "^";

	/** 演算器 */
    private DisplayedCalculationFormula dispcalcf;

	public PowButton(DisplayedCalculationFormula dispcalcf){
		super(Pow);
		this.dispcalcf=dispcalcf;
		addMouseListener(this);
	}

	/** 累乗ボタンが押された */
    public void mouseClicked(MouseEvent e){
    	dispcalcf.setDisplayedCalculationFormula(Pow);
    	dispcalcf.setSlashCalculationFormula("/"+Pow+"/");
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
