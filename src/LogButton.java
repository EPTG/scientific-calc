import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
/** 演算子ボタンの生成と演算子ボタンが押された際の処理を行う */
public class LogButton extends JButton implements MouseListener{

    /** logが取りうる値 */
    public static String LOG = "log";
    /** lnが取りうる値*/
    public static String LN ="ln";
    /**Logに関して取りうる値*/
    public static String LOGS[] = {LOG,LN};
    
    /** 割り当てられた演算器号 */
    private String log;

    /** 演算器 */
    private DisplayedCalculationFormula dispcalcf;
    
    /** 引数で与えられた演算子でボタンを生成し、フィールドの演算器に引数の演算器を代入 */
    public LogButton(DisplayedCalculationFormula dispcalcf,int i){
    	super(LOGS[i]);
    	log = LOGS[i];
    	this.dispcalcf = dispcalcf;
    	addMouseListener(this);
    }

    /** 演算器号ボタンが押された */
    public void mouseClicked(MouseEvent e){
    	dispcalcf.setDisplayedCalculationFormula(log+"(");
    	dispcalcf.setSlashCalculationFormula("/"+log+"/"+"/"+"("+"/");
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
