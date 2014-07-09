import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/** 電卓クラス（電卓プログラムのメインクラス) */

public class Calc extends JFrame{
    /** 数字ボタン ０から９,()の12個 */
    private NumButton[] numButton;
    /** ドットボタン　. */
    private DotButton dotButton;
    /**演算記号ボタン + - * / の4つ */
    private OpButton[] opButton;
    /**削除ボタン*/
    private BackSpaceButton delButton;
    /** 定数ボタン */
    private FixednumberButton[] fixedButton;
    /** Logボタン */
    private LogButton[] logButton;
    /** RADボタン */
    private RadButton radButton;
    /** 三角関数ボタン */
    private TrigonometricFunctionButton[] Trigonometricbutton;
    /** ＝ボタン */
    private EqualButton equalButton;
    /** Cボタン */
    private ClearButton clearButton;
    /** 表示する数 */
    private DisplayedCalculationFormula dispCalcf;
    /** 演算器 */
    private ArithmeticUnit arithmUnit;
    /** キーボードリスナー */
    private static  KeyboardListener kListener;

    /** 表示する数ラベル */
    public JLabel calcLabel;

    public static Calc calc;

    /** メイン関数、Calcのオブジェクトの初期化を行い、フレームの生成と表示を行う*/
    public static void main(String[] args){
	calc = new Calc();
	calc.setVisible(true);
	calc.requestFocus();
    }

    public void RemoveFocus(){
    calc.requestFocus();
    }

    /** 電卓が使えるよう属性と表示の初期化をする*/
    public Calc() {
	initFields();
	initGUI();

    }
    /** 電卓の属性を初期化する */
    private void initFields(){
	/*後で必要なコードを書く*/

    	//いろんなボタンのインスタンス化

    	dispCalcf=new DisplayedCalculationFormula();
    	arithmUnit=new ArithmeticUnit(dispCalcf);
    	clearButton =  new ClearButton(arithmUnit, dispCalcf);
    	radButton = new RadButton(dispCalcf);
		calcLabel = dispCalcf;

		//numボタンのインスタンスが配列に入れられる順は0から9まではその数字 10は（ 11は）
		numButton = new NumButton[12];
		for (int i = 0; i<12; i++){
		    numButton[i] = new NumButton(dispCalcf,i);
		}

		dotButton =new DotButton(dispCalcf);
		delButton =new BackSpaceButton(dispCalcf);

		//Triボタンのインスタンスが配列に入れられる順は0がSin 1がCos 2がTan 3がarcSin 4がarcCos 5がarcTan
		Trigonometricbutton = new TrigonometricFunctionButton[6];
		for (int i = 0; i<6; i++){
		    Trigonometricbutton[i] = new TrigonometricFunctionButton(dispCalcf,i);
		}//Triボタンのインスタンス化ここまで

		//Logボタンのインスタンスが配列に入れられる順は0がlog 1がln
		logButton = new LogButton[2];
		for (int i = 0; i<2; i++){
		    logButton[i] = new LogButton(dispCalcf,i);
		}//Logボタンのインスタンス化ここまで

		//OPボタンのインスタンスが配列に入れられる順は0が+ 1が－ 2が× 3が÷ 4が累乗 5が平方根
		opButton = new OpButton[6];
		for (int i = 0; i<6; i++){
		    opButton[i] = new OpButton(dispCalcf,i);
		}//OPボタンのインスタンス化ここまで

		//Fixednボタンのインスタンスが配列に入れられる順は0がπ 1がAns 2がe
		fixedButton = new FixednumberButton[3];
		for (int i = 0; i<3; i++){
			fixedButton[i] = new FixednumberButton(dispCalcf,i);
		}//Fixednボタンのインスタンス化ここまで

		//equalButtonボタンのインスタンス化
		equalButton =new EqualButton(arithmUnit,dispCalcf);
		//equalButtonボタンのインスタンス化ここまで

		//** キーボードリスナー のインスタンス化
		kListener =new KeyboardListener(numButton);
		//キーボードリスナー のインスタンス化ここまで

		//いろんなボタンのインスタンス化おわり


    }
    /** 電卓の表示を初期化する */
    private void initGUI(){
    	this.addKeyListener(kListener);

    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	/*後で必要なコードを書く*/
    	setSize(700,400);
    	setLocation(100,100);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	setLayout(new GridBagLayout());
    	GridBagConstraints c =new GridBagConstraints();
    	c.fill = GridBagConstraints.BOTH;
    	c.weightx = c.weighty =1 ;
    	c.gridx = GridBagConstraints.RELATIVE;

    	//上から０行め
    	c.gridwidth = 4;
    	add(calcLabel, c);
    	calcLabel.setHorizontalAlignment(SwingConstants.RIGHT);
    	c.gridwidth =1;
    	//上から０行目おわり
    	//上から1行め 7 8 9 c BS ( ) ^ √
    	c.gridy = 1;
    	add(numButton[7], c);
    	add(numButton[8], c);
    	add(numButton[9], c);
    	add(clearButton, c);
    	add(delButton,c);
    	add(numButton[10], c);
    	add(numButton[11], c);
    	add(opButton[4],c);
    	add(opButton[5],c);
    	//上から1行め終わり

    	//上から2行め 4 5 6 × ÷ Ans e log Ln
    	c.gridwidth = 1;
    	c.gridy = 2;
    	add(numButton[4], c);
    	add(numButton[5], c);
    	add(numButton[6], c);
    	add(opButton[2], c);
    	add(opButton[3], c);
    	add(fixedButton[1],c);
    	add(fixedButton[2],c);
    	add(logButton[0],c);
    	add(logButton[1],c);
    	//上から二行目終わり

    	//上から三行目 1 2 3 + - Sin Cos Tan π
    	c.gridwidth = 1;
    	c.gridy = 3;
    	add(numButton[1], c);
    	//四行目にかくとおかしくなるからnum[0]と.は1の下につくる的なイメージで
    	c.gridwidth = 2;
    	c.gridy = 4;
    	add(numButton[0],c);

    	c.gridwidth = 1;
    	add(dotButton,c);

    	c.gridy = 3;

    	add(numButton[2], c);
    	add(numButton[3], c);
    	c.gridheight = 2;
    	//sumButtonは二行分

    	add(opButton[0], c);
    	c.gridheight = 1;

    	add(opButton[1], c);
    	add(Trigonometricbutton[0],c);
    	add(Trigonometricbutton[1],c);
    	add(Trigonometricbutton[2],c);
    	add(fixedButton[0],c);

    	//上から4行目 0 . + = aS aC aT rad
    	c.gridwidth = 2;
    	c.gridy = 4;
    	c.gridwidth = 1;
    	add(equalButton, c);

    	add(Trigonometricbutton[3],c);
    	add(Trigonometricbutton[4],c);
    	add(Trigonometricbutton[5],c);
    	add(radButton,c);

    }
}

