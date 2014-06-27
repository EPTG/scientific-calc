import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/** 演算器.　演算記号の表示部も含む,表示する数式クラスの「/」つき数式をうけとって演算を行う.演算結果は「表示する数」オブジェクトに渡して表示する*/
public class ArithmeticUnit{
    /** +演算子(足し算記号).operatorが取りうる値 */
    public static String OP_PLUS = "+";
    /** -演算子(引き算記号).operatorが取りうる値 */
    public static String OP_MINUS = "-";
    /** ＊演算子(掛け算記号).operatorが取りうる値 */
    public static String OP_TIMES = "×";
    /** ／演算子(割り算記号).operatorが取りうる値 */
    public static String OP_DIVIDE = "÷";
    /** 演算子が未選択であることを示す.operatorが取りうる値 */
    public static String OP_NONE = "";
    /** ボタンを表示する演算子を列挙した配列*/
    public static String OPERATORS[] = {OP_PLUS,OP_MINUS,OP_TIMES,OP_DIVIDE};
    /** 前回の答え*/
    public static String Ans = "0";
    /** (が取りうる値 */
    public static String RpareL = "(";
    /** )が取りうる値 */
    public static String RpareR = ")";
    /**ボタンを表示する演算子を列挙した配列*/
    private static String Rpares[]={RpareL,RpareR};

    /** 表示する数*/
    private DisplayedCalculationFormula dispCalcf;

    /** フィールドの表示する数に引数の表示する数を代入し、演算子を未設定にして表示する */
    public ArithmeticUnit(DisplayedCalculationFormula dispCalcf){
    	this.dispCalcf = dispCalcf;
    }

    /** 計算結果を消去する*/
    public void Clear(){
    	Ans = "0";
    }

    /** 演算子と数値を分けてArrayListに入れる。*/
    public String[] split_op_num(){
    	String[] s =dispCalcf.getslash().split("/");
    	return s;
    }
    /** ArrayList内の要素で空白がある場合削除を行う */
    public List<String> Whitedel(List<String> list){
    	while(list.contains("")){
    	list.remove(list.indexOf(""));
    	}
    	return list;
    }

    /** Stringの配列をStringのArraylistに変換する */
    public List<String> convert(String[] array){
    	return new LinkedList<String>(Arrays.asList(array));
    }
    /** √計算を行う */
    private String root(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.sqrt(Dnum);
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		System.out.println(Dnum);
		return num.toPlainString();
	}

    /** 累乗計算を行う。*/
    private void pow(List<String> list) {
		double firstnum;
		firstnum =Double.valueOf(list.get(0));
		double secondnum;
		secondnum = Double.valueOf(list.get(2));
		double result;
		result = Math.pow(firstnum, secondnum);
		list.set(0,Double.toString(result));
		list.remove(1);
		list.remove(1);
	}


    /** Log計算を行う */
    private String Log(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.log10(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}
    //**ln計算を行う。/
    private String Ln(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.log(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}

    /** Sin計算を行う*/
    private String Sin(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.sin(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}
    /** Cos計算を行う*/
    private String Cos(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.cos(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}
    /** Tan計算を行う*/
    private String Tan(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.tan(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}

    /** 角度のラジアン変換を行う*/
    private String rad(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.toRadians(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(15,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}

    /** 括弧の始まりから終わりを見つける。*/
    public List<String> Roundparentheses(List<String> list){
    	while(list.contains(RpareL)|list.contains(RpareR)){
    		int temp1= list.indexOf(RpareL);
    		System.out.println(temp1);
    		int counter =1;
    		int temp2 = temp1;
    		try{
    		for(temp2 = temp1+1;counter >0;temp2++){
    			System.out.println(temp2);
    			System.out.println(counter);
    			System.out.println(list.get(temp2));
    			if((list.get(temp2)).equals(RpareL)){
    				counter=counter+1;
    				System.out.println("+");
    			}
    			else if((list.get(temp2)).equals(RpareR)){
    				counter=counter-1;
    				System.out.println("-");
    			}
    			System.out.println(counter);
    		}

    		list.set(temp1,(operate(list.subList(temp1+1, temp2-1))));
    		}catch(IndexOutOfBoundsException e){
				dispCalcf.setText("括弧Error");
    		}
    		System.out.println(temp1);
    		System.out.println(temp2);
    			list.remove(temp1+1);
    			list.remove(temp1+1);
    			System.out.println(list);
    	}
    	return list;
    }

    /** StringのListを受け取って演算を行う。演算結果をString型で返す。*/
    public String operate(List<String> list) throws IndexOutOfBoundsException,ArithmeticException,NumberFormatException {
    	list = Whitedel(list);
    	System.out.println(list);
    	list = Roundparentheses(list);//括弧の処理

    	while(list.contains("π")){
    	int temp =list.indexOf("π");
    	list.set(temp, Double.toString(Math.PI));
    	}

    	while(list.contains("e")){
        	int temp =list.indexOf("e");
        	list.set(temp, Double.toString(Math.E));
        	}

    	while(list.contains("Ans")){
        	int temp =list.indexOf("Ans");
        	list.set(temp, Ans);
        	}

    	while(list.contains("√")){
    	int temp = list.indexOf("√");
    	list.set(temp,root(list,temp));
    	list.remove(temp+1);
    	}

    	while(list.contains("log")){
        int temp = list.indexOf("log");
        list.set(temp,Log(list,temp));
        list.remove(temp+1);
        }

    	while(list.contains("ln")){
        int temp = list.indexOf("ln");
        list.set(temp,Ln(list,temp));
        list.remove(temp+1);
        }

    	while(list.contains("Sin")){
    	int temp = list.indexOf("Sin");
    	list.set(temp,Sin(list,temp));
    	list.remove(temp+1);
    	}

    	while(list.contains("Cos")){
        int temp = list.indexOf("Cos");
        list.set(temp,Cos(list,temp));
        list.remove(temp+1);
        }

    	while(list.contains("Tan")){
        int temp = list.indexOf("Tan");
        list.set(temp,Tan(list,temp));
        list.remove(temp+1);
        }


    	while(list.contains("rad")){
    	int temp = list.indexOf("rad");
    	list.set(temp,rad(list,temp));
    	list.remove(temp+1);
    	}

    	while(list.contains("^")){
    	int temp =list.indexOf("^");
    	pow(list.subList(temp-1,temp+2));//累乗は○^○の形なので
    	}


    	BigDecimal firstnum;
    	BigDecimal secondnum;
    	BigDecimal result = null;

    		while(list.contains(OPERATORS[2])||list.contains(OPERATORS[3])){
    				int temp1 = list.indexOf(OPERATORS[2]);
    				int temp2 = list.indexOf(OPERATORS[3]);
    				int now =0;
    				int j=1;
    				if(temp1 < temp2){
    					if(temp1<0){
    					now = temp2;
    					j=3;
    					}
    					else{
    					now = temp1;
    					j=2;
    					}
    				}
    				else if (temp1 > temp2){
    					if(temp2<0){
        					now = temp1;
        					j=2;
    						}
        					else{
        					now = temp2;
        					j=3;
        					}
    				}

    					firstnum=new BigDecimal(list.get(now-1));
    					secondnum=new BigDecimal(list.get(now+1));
    					switch(j){
    						case 2:
    						System.out.println(firstnum);
    						System.out.println(secondnum);
    						result = firstnum.multiply(secondnum);
    						break;
    						case 3:
    						System.out.println(firstnum);
        					System.out.println(secondnum);
    						result = firstnum.divide(secondnum,16,BigDecimal.ROUND_HALF_EVEN);
    						break;
    						}

					list.set(now, result.toString());
    					list.remove(now+1);
    					list.remove(now-1);

    				System.out.println(list);
    			}

    	//負の数入力のためにマイナスを先に評価した
    	for(int j=1;j>=0;j--){
    		while(list.contains(OPERATORS[j])){
    				int now = list.indexOf(OPERATORS[j]);
    				try{
    					firstnum=new BigDecimal(list.get(now-1));
    				}catch(IndexOutOfBoundsException e){
    					firstnum=null;
    				}
    					secondnum=new BigDecimal(list.get(now+1));

    				switch(j){
    					case 0:
    						result = firstnum.add(secondnum);
    						break;
    					case 1:
    						if(firstnum!=null){
    						result = firstnum.subtract(secondnum);
    						break;
    						}
    						else if(firstnum==null){
    						result = secondnum.negate();
    						break;
    						}
    				}

    					list.set(now, result.toString());
    					list.remove(now+1);
    					if(firstnum!=null){
    					list.remove(now-1);
    					}

    				System.out.println(list);
    			}
    		System.out.println(list);
    		}
    	if(list.size()>1){
			return "色々とエラー(計算しきれてない模様)";
		}
    	BigDecimal tmp = new BigDecimal(list.get(0));
    	BigDecimal keta = new BigDecimal("1.0E15");
    	DecimalFormat df1 = new DecimalFormat("################.###############");
    	DecimalFormat df2 = new DecimalFormat("0.00#############E0");
    	if(tmp.compareTo(keta) >= 0){
    	Ans=df2.format(tmp);
    	return df2.format(tmp);
    	}
    	else{
    	Ans=df1.format(tmp);
    	return df1.format(tmp);
    	}
    }


}

