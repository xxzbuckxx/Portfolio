import java.util.Scanner;
import javax.swing.*;

/**
 * Write a description of class main_nim here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EXTRA_CREDIT_MAIN{
    public static void main(String[] args){
        //GLOBAL DECLERATION
        boolean play = true;
        int wins = 0;
        int games = 0;
        Scanner sc = new Scanner(System.in);
        game gam = new game();
        
        
        
        //NAME GET
        String player = JOptionPane.showInputDialog("What is your name sir?");
        
        //PLAY?
        Object[] option1 = {"For Sure", "Not Right Now"};
        int choice = JOptionPane.showOptionDialog(null,
                "Would you like to play a game of NIM " + player + "?",
                "Game of NIM",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                option1,
                "For Sure");
                
        if(choice == 1) play = false;
                
////////////////////////////////////////////////////////////////////////////////////        
        //GAME LOOP
        while(play){
            
        //HARD OR EASY
            boolean diff = true;
            Object[] option2 = {"Easy", "Hard"};
            int mode = JOptionPane.showOptionDialog(null,
                "HARD MODE or easy?",
                "Game of NIM",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                option2,
                "Easy");
                
        if(mode == 0) diff = false;
        else diff = true;
            
         //INTIALIZE GAME
            gam.newGame(diff);
            boolean turn = true;
            games++;
            System.out.println("Let's start at " + gam.getCurr());
            //JOptionPane.showMessageDialog(null, "Let's start at " + gam.getCurr());
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
            
            //END LOOP?
            System.out.println("Y or N?");
            String ans = sc.nextLine();
            if(ans.length() >= 1 && ans.charAt(0) == 'n') break;
            
        }
    }
}
