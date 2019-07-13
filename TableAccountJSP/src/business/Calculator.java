package business;

public class Calculator {
	private double total;
	private double tip;
	private int people;
	
		private double total(){
			return this.getTotal() + (this.getTotal()*(this.getTip()/100));
		}
		
		public String getTotalExpense(){
			return "Total expense: " + this.total();
		}
		
		public String getTotalPerPerson(){
			return "Total per person: " + (this.total()/this.getPeople());
		}

		public double getTotal() {
			return total;
		}

		public void setTotal(double total) {
			this.total = total;
		}

		public double getTip() {
			return tip;
		}

		public void setTip(double tip) {
			this.tip = tip;
		}

		public int getPeople() {
			return people;
		}

		public void setPeople(int people) {
			this.people = people;
		}
}
