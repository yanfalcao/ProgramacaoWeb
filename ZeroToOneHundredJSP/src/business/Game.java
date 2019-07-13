package business;

import java.util.Random;

public class Game {
	private int number;
	private int loteryNumber;
	private int attemptsHelp = 0;
	private int attempts = 0;
	
	public Game() {
		this.raffle();
	}
	
	public String getResult() {
		this.attemptsHelp ++;
        this.attempts = this.attemptsHelp;
        
        if(this.loteryNumber > this.getNumber())
            return "The number you entered is less";
        else if(this.loteryNumber < this.getNumber())
            return "The number you entered is larger";
        else{
            this.raffle();
            this.attemptsHelp = 0;
            return "CONGRATULATIONS YOU WON !!!";
        }
	}
	
	public String getAttempts() { 
		return "The total of attempts is " + this.attempts; 
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}

	public String getLoteryNumber() {
		return "The lotery number is " + this.loteryNumber;
	}

	private void setLoteryNumber(int loteryNumber) {
		this.loteryNumber = loteryNumber;
	}
	
	public void raffle(){ 
		this.setLoteryNumber((new Random()).nextInt(101));
	}
}
