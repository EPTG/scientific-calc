import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/** 電卓クラス（電卓プログラムのメインクラス) */

public class Calc extends JFrame{
    /** 数字ボタン ０から９の１０個 */
    private NumButton[] numButton;
    /** ドットボタン　. */
    private DotButton dotButton;
    /**演算記号ボタン + - * / の4つ */
    private OpButton[] opButton;
    /**削除ボタン*/
    private DeleteButton delButton;
    /** ()ボタン */
    private RoundparenthesesButton[] RpButton;
    /** √ボタン */
    private RootButton RootButton;
    /** ^ボタン */
    private PowButton powButton;
    /** 定数ボタン */
    private FixednumberButton[] fixedButton;
    /** Logボタン */
    private LogButton[] logButton;
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

    /** 表示する数ラベル */
    public JLabel calcLabel;

    /**　メイン関数、Calcのオブジェクトの初期化を行い、フレームの生成と表示を行う*/
    public static void main(String[] args){
	Calc calc = new Calc();
	calc.setVisible(true);
    }

    /** 電卓が使えるよう属性と表示の初期化をする*/
    public Calc() {
	initFields();
	initGUI();
    }
    /** 電卓の属性を初期化する */
    private void initFields(){
	/*後で必要なコードを書く*/
    	dispCalcf=new DisplayedCalculationFormula();
    	arithmUnit=new ArithmeticUnit(dispCalcf);
    	clearButton =  new ClearButton(arithmUnit, dispCalcf);
		calcLabel =dispCalcf;
		RootButton = new RootButton(dispCalcf);
		powButton = new PowButton(dispCalcf);

		numButton = new NumButton[12];
		for (int i = 0; i<12; i++){
		    numButton[i] = new NumButton(dispCalcf,i);
		}

		dotButton =new DotButton(dispCalcf);
		delButton =new DeleteButton(dispCalcf);

		//いろんなボタンのインスタンス化

		//Triボタンのインスタンスが配列に入れられる順は0がSin 1がCos 2がTan 3がrad 4がarcSin 5がarcCos 6がarcTan
		Trigonometricbutton = new TrigonometricFunctionButton[7];
		for (int i = 0; i<7; i++){
		    Trigonometricbutton[i] = new TrigonometricFunctionButton(dispCalcf,i);
		}//Triボタンのインスタンス化ここまで

		//Logボタンのインスタンスが配列に入れられる順は0がlog 1がln
		logButton = new LogButton[2];
		for (int i = 0; i<2; i++){
		    logButton[i] = new LogButton(dispCalcf,i);
		}//Logボタンのインスタンス化ここまで

		//OPボタンのインスタンスが配列に入れられる順は0が+ 1が－ 2が× 3が÷
		opButton = new OpButton[4];
		for (int i = 0; i<4; i++){
		    opButton[i] = new OpButton(dispCalcf,i);
		}//OPボタンのインスタンス化ここまで

		//Fixednボタンのインスタンスが配列に入れられる順は0が+ 1が－ 2が× 3が÷
		fixedButton = new FixednumberButton[3];
		for (int i = 0; i<3; i++){
			fixedButton[i] = new FixednumberButton(dispCalcf,i);
		}//Fixednボタンのインスタンス化ここまで

		//()ボタンのインスタンスが配列に入れられる順は0が( 1が)
		RpButton = new RoundparenthesesButton[2];
		for (int i = 0; i<2; i++){
		    RpButton[i] = new RoundparenthesesButton(dispCalcf,i);
		}//()ボタンのインスタンス化ここまで


		equalButton =new EqualButton(arithmUnit,dispCalcf);
		//いろんなボタンのインスタンス化おわり


    }
    /** 電卓の表示を初期化する */
    private void initGUI(){
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
    	//上から1行め
    	c.gridy = 1;
    	add(numButton[7], c);
    	add(numButton[8], c);
    	add(numButton[9], c);
    	c.gridwidth = 2;
    	add(clearButton, c);
    	c.gridwidth = 1;
    	add(delButton,c);
    	add(fixedButton[1],c);
    	//上から1行め終わり
    	//上から2行め
    	c.gridwidth = 1;
    	c.gridy = 2;
    	add(numButton[4], c);
    	add(numButton[5], c);
    	add(numButton[6], c);
    	add(opButton[2], c);
    	add(opButton[3], c);
    	add(RpButton[0],c);
    	add(RpButton[1],c);
    	add(RootButton,c);
    	add(powButton,c);
    	//上から二行目終わり
    	//上から三行目
    	c.gridwidth = 1;
    	c.gridy = 3;
    	add(numButton[1], c);
    	//よくわからないけど四行目にかくとおかしくなるからnum[0]は1の下につくる的なイメージで
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
	add(fixedButton[2],c);
	add(logButton[0],c);
	add(logButton[1],c);
	c.gridwidth = 2;
	c.gridy = 4;
	c.gridwidth = 1;
	add(equalButton, c);
	add(Trigonometricbutton[0],c);
	add(Trigonometricbutton[1],c);
	add(Trigonometricbutton[2],c);
	add(Trigonometricbutton[3],c);
	add(Trigonometricbutton[4],c);
	add(Trigonometricbutton[5],c);
	add(Trigonometricbutton[6],c);
	add(fixedButton[0],c);
    }
}

