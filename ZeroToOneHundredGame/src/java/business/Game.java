package business;

import java.util.Random;

public class Game {
    private int loteryNumber;
    private int attemptsHelp = 0;
    private int attempts = 0;
    
    public Game(){ this.raffle(); }
    
    public String verify(int numberEntered){
        this.attemptsHelp ++;
        this.attempts = this.attemptsHelp;
        
        if(this.loteryNumber > numberEntered)
            return "The number you entered is less";
        else if(this.loteryNumber < numberEntered)
            return "The number you entered is larger";
        else{
            this.raffle();
            this.attemptsHelp = 0;
            return "CONGRATULATIONS YOU WON !!!";
        }
    }
    
    public int getAttempts(){ return this.attempts; }
    
    private void raffle(){ this.loteryNumber = (new Random()).nextInt(101); }
}
