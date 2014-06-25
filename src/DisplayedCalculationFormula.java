import java.util.Arrays;

import javax.swing.JLabel;

/** 表示する式に関しての処理を行う．ここで表示する数の表示も行う．また、入力完了フラグの処理も行う． */

public class DisplayedCalculationFormula extends JLabel{

    /** 現在の式 */
    private String disp;
    private String slash;
    private Boolean finishedFlag;
    private String[] Clearstr = {"0","1","2","3","4","5","6","7","8","9","√("};


    /** 表示する式の初期化をし初期表示を行う*/
    public DisplayedCalculationFormula(){
    	disp="";
    	slash="";
	finishedFlag=false;
    	super.setText(disp);//初期表示を変更した(8回より前ではsuper.setTextだったがこちらの方に変更した)
    }

    /** 表示する式を空欄にする */
    public void clear(){
    	disp= "";
    	slash="";
	unsetFlag();
    	super.setText(disp);
    }

    /** 表示している式に引数を加える */
    public void setDisplayedCalculationFormula(String o){
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
    	slash=slash+o;
    }

    /** 表示する式を読み出す */
    public String getDisplayedCalculationFormula(){
    	return disp;
    }
    /** 表示する式に代入*/
    public void setNewDisplayedCalculationFormula(String s){
    	disp=s;
    	slash=s;
    	super.setText(disp);
    }
    /** 演算子の前後にスラッシュをつけた文を読み出す */
    public String getslash(){
    	return slash;
    }
    public void Delate(){
    	if(disp.length()==0){
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
    public void setFlag(){
	finishedFlag=true;
    }
    public void unsetFlag(){
	finishedFlag=false;
    }
    public boolean checkFlag(){
	return finishedFlag;
    }
    /** Errorを表示する　*/
    public void setError(){//Errorを表示
    	super.setText("Error");
    }
    /** Errorが表示されているか確認して表示されている場合trueを返し、表示されていない場合falseを返す。*/
    public boolean checkError(){//ラベルにErrorが表示されているか確認
    	if ((super.getText()).equals("Error")){//セットされている文字列がErrorだった場合trueを返す
	    return true;
    	}
    	return false;//そうでない場合はfalseを返す。
    }
}
