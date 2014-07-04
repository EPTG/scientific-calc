import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

/** 三角関数ボタンの生成とボタンが押された際の処理を行う */
public class TrigonometricFunctionButton extends JButton implements MouseListener{

	/** 画面表示 */
    private DisplayedCalculationFormula dispCalc;
    /** Sinが取りうる値 */
    public static String Sin = "Sin";
    /** Cosが取りうる値 */
    public static String Cos = "Cos";
    /** Tanが取りうる値 */
    public static String Tan = "Tan";
    /** radが取りうる値 */
    public static String rad = "rad";
    /** arcSinが取りうる値 */
    public static String ASin = "arcSin";
    /** arcCosが取りうる値 */
    public static String ACos = "arcCos";
    /** arcTanが取りうる値 */
    public static String ATan = "arcTan";
    /** ボタンの表示と画面表示に用いる値を列挙した配列*/
    public static String FANCTION[] = {Sin,Cos,Tan,rad,ASin,ACos,ATan};

    /** 割り当てられた三角関数 */
    private String tfanction;

    /** 引数で指定した三角関数ボタンを生成し、フィールドの表示する数式に引数の表示する数式を代入。その後ボタンが押されたことを聞きつける状態になる */
    public TrigonometricFunctionButton(DisplayedCalculationFormula dispCalc,int i){
    	super(FANCTION[i]);
    	this.dispCalc=dispCalc;
    	tfanction = FANCTION[i];
    	addMouseListener(this);
    }
    /** 三角関数ボタンが押された時の動作*/
    public void mouseClicked(MouseEvent e){
     	dispCalc.setDisplayedCalculationFormula(tfanction+"(");
    	dispCalc.setSlashCalculationFormula("/"+tfanction+"/"+"/"+"("+"/");
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
