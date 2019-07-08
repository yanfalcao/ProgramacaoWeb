package business;

public class Calculator {
	public static double totalExpense(double total, double tipPercentage){
		double tip = total*(tipPercentage/100);
		
		return total+tip;
	}
	
	public static double totalPerPerson(int totalOfPeople, double total, double tipPercentage){
		return Calculator.totalExpense(total, tipPercentage)/totalOfPeople;
	}
}
