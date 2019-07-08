package business;

public class Calculator {
	public static String imcCalculate(double weight, double height){
		Double result = (weight/(height*height));
		
		if(result < 18.5)
			return "under weight";
		else if(result >= 18.5 && result < 24.9)
			return "normal weight";
		else if(result >= 25 && result < 29.9)
			return "overweight";
		else if(result >= 30 && result < 34.9)
			return "obesity grade 1";
		else if(result >= 35 && result < 39.9)
			return "obesity grade 2";
		else
			return "obesity grade 3";
	}
}
