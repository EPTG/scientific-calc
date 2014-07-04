import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 累乗ボタンの生成とボタンが押された際の処理を行う */
public class PowButton extends JButton implements MouseListener {

	/** ^が取りうる値 */
    public static String Pow = "^";

	/** 表示する数式 */
    private DisplayedCalculationFormula dispcalcf;

    /** 累乗ボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる。 */
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
