import java.util.Scanner;

/**
 * Write a description of class main_nim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class main_nim
{
    public static void main(String[] args){
        //GLOBAL DECLERATION
        boolean play = true;
        int wins = 0;
        int games = 0;
        Scanner sc = new Scanner(System.in);
        game gam = new game();
        
        //NAME GET
        System.out.println("What is your name sir?");
        String player = sc.nextLine();
        
        System.out.println("Would you like to play a game of NIM " + player + "?");
        
        //GAME LOOP
        while(play){

        //END LOOP?
            System.out.println("Y or N?");
            String ans = sc.nextLine();
            if(ans.length() >= 1 && ans.charAt(0) == 'n') break;
            
        //HARD OR EASY
            boolean understand = false;
            boolean diff = true;
            while(understand == false){
                System.out.println("hard or easy?");
                String inp = sc.nextLine();
                if(inp.toLowerCase().equals("hard")){
                    diff = true;
                    understand = true;
                }
                else if(inp.toLowerCase().equals("easy")){
                    diff = false;
                    understand = true;
                }
                else {
                   System.out.println("I don't understand..."); 
                }
            }
            
         //INTIALIZE GAME
            gam.newGame(diff);
            boolean turn = true;
            games++;
            System.out.println("Let's start at " + gam.getCurr());
            if(gam.compStarts()) gam.compTurn(); //Randomly selects starter (if true then computer starts)
            
         //GAME PHASE
            while(turn){
                gam.turn(); 
                if(gam.getCurr() <= 0){
                    System.out.println("  +  +  +  +  + GAME OVER +  +  +  +  +  " + System.lineSeparator());
                    System.out.println(player + ", you LOST!! ;(" + System.lineSeparator());
                    break;
                }
                else gam.compTurn();
                System.out.println("Here is the score: " + gam.getCurr());
                if(gam.getCurr() <= 0){
                    System.out.println("  +  +  +  +  + GAME OVER +  +  +  +  +  " + System.lineSeparator());
                    System.out.println(player + ", you WON!! :))" + System.lineSeparator());
                    wins++;
                    break;
                }
            }
            
            //DISPLAYS RECORD
            System.out.println("RECORD:");
            System.out.println("-------------");
            System.out.printf("wins: %s%nlosses: %s%ntotal: %s%n", wins, games-wins, games);
            
            System.out.println("----------------------------------------------");
            System.out.println("PLAY AGAIN?");
            
        }
    }
}
