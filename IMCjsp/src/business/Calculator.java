package business;

public class Calculator {
	private Double weight;
	private Double height;
	
	public Calculator(){
		this.setWeight(0.0);
		this.setHeight(0.0);
	}
	
	public Calculator(Double weight, Double height){
		this.setWeight(weight);
		this.setHeight(height);
	}
	
	public String getImcTradicional(){
		Double result = this.getWeight()/Math.pow(this.getHeight(), 2);
		
		if(result < 18.5)
			return "You're under weight";
		else if(result >= 18.5 && result < 24.9)
			return "You're normal weight";
		else if(result >= 25 && result < 29.9)
			return "You're overweight";
		else if(result >= 30 && result < 34.9)
			return "You're obesity grade 1";
		else if(result >= 35 && result < 39.9)
			return "You're obesity grade 2";
		else
			return "You're obesity grade 3";
	}
	
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}

}
