import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** Rootボタンの生成とボタンが押された際の処理を行う */
public class RootButton extends JButton implements MouseListener{

    /** √が取りうる値 */
    public static String Root = "√";

    /** 表示する数式 */
    private DisplayedCalculationFormula dispcalcf;

    /** Rootボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつけ状態になる。 */
    public RootButton(DisplayedCalculationFormula dispcalcf){
    	super(Root);
    	this.dispcalcf = dispcalcf;
    	addMouseListener(this);
    }

    /** Rootボタンが押された */
    public void mouseClicked(MouseEvent e){
    	dispcalcf.setDisplayedCalculationFormula(Root+"(");
    	dispcalcf.setSlashCalculationFormula("/"+Root+"/"+"/"+"("+"/");
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
