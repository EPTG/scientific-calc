import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


/** 演算器.　演算記号の表示部も含む,2つの数に対して4種類の演算をする.演算結果は「表示する数」オブジェクトに渡して表示する*/
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
    /** 演算子と数値を分ける*/
    public String[] split_op_num(){
    	String[] s =dispCalcf.getslash().split("/");
    	return s;
    }

    public List<String> Whitedel(List<String> list){
    	while(list.contains("")){
    	list.remove(list.indexOf(""));
    	}
    	return list;
    }


    public List<String> convert(String[] array){
    	return new LinkedList<String>(Arrays.asList(array));
    }

    private String root(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.sqrt(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		return String.valueOf(Dnum);
	}

    private String Sin(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.sin(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(14,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}

    private String rad(List<String> list, int indexOf) {
		BigDecimal num;
		num =new BigDecimal(list.get(indexOf+1));
		Double Dnum = num.doubleValue();
		System.out.println(Dnum);
		Dnum = Math.toRadians(Dnum);
		System.out.println(num);
		System.out.println(Dnum);
		// 一旦BigDecimalになおして丸めておくのが良さげ。
		num =new BigDecimal(Dnum).setScale(14,BigDecimal.ROUND_HALF_EVEN);
		System.out.println(num);
		return num.toPlainString();
	}


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


    public String operate(List<String> list) throws IndexOutOfBoundsException,ArithmeticException,NumberFormatException {
    	list = Whitedel(list);
    	System.out.println(list);
    	list = Roundparentheses(list);//括弧の処理

    	while(list.contains("√")){
    	int temp = list.indexOf("√");
    	list.set(temp,root(list,temp));
    	list.remove(temp+1);
    	}

	while(list.contains("Sin")){
    	int temp = list.indexOf("Sin");
    	list.set(temp,Sin(list,temp));
    	list.remove(temp+1);
    	}

	while(list.contains("rad")){
    	int temp = list.indexOf("rad");
    	list.set(temp,rad(list,temp));
    	list.remove(temp+1);
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
    						result = firstnum.divide(secondnum,15,BigDecimal.ROUND_HALF_EVEN);
    						break;
    						}

					list.set(now, result.toString());
    					list.remove(now+1);
    					list.remove(now-1);

    				System.out.println(list);
    			}


    	for(int j=0;j<2;j++){
    		while(list.contains(OPERATORS[j])){
    				int now = list.indexOf(OPERATORS[j]);

    					firstnum=new BigDecimal(list.get(now-1));
    					secondnum=new BigDecimal(list.get(now+1));

    				switch(j){
    					case 0:
    						result = firstnum.add(secondnum);
    						break;
    					case 1:
    						result = firstnum.subtract(secondnum);
    						break;
    				}
				result.setScale(12);
    					list.set(now, result.toString());
    					list.remove(now+1);
    					list.remove(now-1);


    				System.out.println(list);
    			}
    		System.out.println(list);
    		}
    		String tmp=list.get(0);
    		if(list.size()>1){
    			return "色々とエラー";
    		}
    		return tmp;
    	}

}

