import java.util.Scanner;
import java.util.Random;

/**
 * Write a description of class game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class game
{
    // instance variables
    private int current;
    private boolean diff; //True is hard, False is easy
    
    // accessory methods
    public int getCurr(){
        return current;
    }
    
    public String getDiff(){
        if(diff) return "Hard";
        return "Easy";
    }
    
    public boolean compStarts(){
        Random rand = new Random();
        int res = rand.nextInt(2);
        if(res == 0) return true;
        return false;
    }
    
    // mutator methods
    public void newGame(boolean dif){
        Random rand = new Random();
        current = rand.nextInt(91)+9;
        diff = dif;
    }
    
    public void turn(){
        Scanner sc = new Scanner(System.in);
        boolean legal = false;
        int temp = 0;
        int half = current/2;
        if(current % 2 == 0) half = current/2;
        else half = current/2 + 1;
        
        while(legal == false){
            System.out.println("How many marbles would you like to take?");
            temp = sc.nextInt();
            if(current - temp >= half) legal = true;
            else if(half == 1 && current == 1){
                legal = true;
                current = 0;
            } else {
                System.out.println("SCOUNDREL! That is Illegal.");
            }
        }
        
        current -= temp;
    }
    
    public void compTurn(){
        System.out.println("I'll take...");
        
        int half = current/2;
        int temp = 0;
        int[] goal = {63,31,15,7,3,1};
        int change;
        if(current % 2 == 0) half = current/2;
        else half = current/2 + 1;
        
        if(diff == true){
            for(int i : goal){
                if(half <= i && i < current){
                    temp = i;
                    break;
                }
            }
            
            if(temp == 0 && current > 2){
                Random rand = new Random();
                temp = rand.nextInt(half -1 )+1;
                System.out.println(temp + " marbles");
                current -= temp;
            } else if(current <= 2){
                temp = 1;
                System.out.println(temp + " marbles");
                current -= temp;
            }else {
                change = current - temp;
                System.out.println(change + " marbles");
                current = temp;
            }
                

            
        } else {
            if(getCurr() == 1 || getCurr() == 2) temp = 1;
            else {
                Random rand = new Random();
                temp = rand.nextInt(half -1 )+1;
            }
            System.out.println(temp + " marbles");
            current -= temp;
            
        }
    }
}
