import java.util.Arrays;

import javax.swing.JLabel;

/** 表示する式に関しての処理を行う．ここで表示する数の表示も行う．また、入力完了フラグの処理も行う． */

public class DisplayedCalculationFormula extends JLabel{

    /** 現在の式 */
    private String disp;
    /** 現在の式の/つき */
    private String slash;
    /** 演算完了フラグ */
    private Boolean finishedFlag;
    /** 演算完了時に演算結果を消すボタンを列挙した配列 */
    private String[] Clearstr = {"0","1","2","3","4","5","6","7","8","9","Ans","(",")","√(","e","log(","ln(","Sin(","Cos(","Tan(","rad(","π","arcSin(","arcCos(","arcTan("};

    /** 表示する数式の初期化をし初期表示を行う*/
    public DisplayedCalculationFormula(){
    	disp="";
    	slash="";
	finishedFlag=false;
    	super.setText(disp);//初期表示を変更した(8回より前ではsuper.setTextだったがこちらの方に変更した)
    }

    /** 表示する数式を空欄にする */
    public void clear(){
    	disp= "";
    	slash="";
	unsetFlag();
    	super.setText(disp);
    }

    /** 表示している数式に引数を加える */
    public void setDisplayedCalculationFormula(String o){
    if(checkError()){
    	System.out.println("test");
    	return ;
    }
	if(checkFlag()){
		unsetFlag();
	    System.out.println(o);
	    if(Arrays.asList(Clearstr).contains(o)){
	       clear();
	   }
	  }
    	disp=disp+o;
    	super.setText(disp);
    }


    public void setSlashCalculationFormula(String o){
    	if(checkError()){
        	System.out.println("test");
        	return ;
        }
    	slash=slash+o;
    }

    /** 表示する数式を読み出す */
    public String getDisplayedCalculationFormula(){
    	return disp;
    }
    /** 表示する数式に代入*/
    public void setNewDisplayedCalculationFormula(String s){
    	disp=s;
    	slash=s;
    	super.setText(disp);
    }
    /** 表示する数式の演算子の前後にスラッシュをつけた文を読み出す */
    public String getslash(){
    	return slash;
    }
    /** 表示する数式の最後の文字を削除する。またスラッシュ付きの文は表示する数式に合わせる。*/
    public void Delate(){
    	if(disp.length()==0 || checkError()){
    		return;
    	}
    	//表示する数の削除
    	disp= disp.substring(0, (disp.length()-1));
    	char last = 0;
    	char last_1 = 0;
    	try{
    	 last=slash.charAt(slash.length()-1);
    	 last_1=slash.charAt(slash.length()-2);
    	}catch(IndexOutOfBoundsException e){
    	 last_1= 0;
    	}
    	System.out.println(last);
    	System.out.println(last_1);

    	if(last=='/' && last_1=='/'){
    		slash =slash.substring(0, slash.length()-3);
    	}
    	else if(last=='/'){
    		slash =slash.substring(0, slash.length()-2);
    	}
    	else{
    		slash = slash.substring(0,slash.length()-1);
    	}

    	if(slash.equals("/")){
    		slash = "";
    	}
    	System.out.println(slash);
    	super.setText(disp);
    }

    /** 演算完了フラグを立てる */
    public void setFlag(){
	finishedFlag=true;
    }
    /** 演算完了フラグを解除する */
    public void unsetFlag(){
	finishedFlag=false;
    }
    /** 演算完了フラグを確認する。*/
    public boolean checkFlag(){
	return finishedFlag;
    }
    /** Errorを表示する*/
    public void setError(){//Errorを表示
    	super.setText("Error");
    }
    /** Errorが表示されているか確認して表示されている場合trueを返し、表示されていない場合falseを返す。*/
    public boolean checkError(){//ラベルにErrorが表示されているか確認
    	if ((super.getText()).contains("Error")){//セットされている文字列がErrorだった場合trueを返す
	    return true;
    	}
    	return false;//そうでない場合はfalseを返す。
    }
}
