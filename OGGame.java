package Game;

import java.util.Random;
import java.util.Scanner;

public class OGGame {
    Functions function = new Functions();
    public void game(String userName,Scanner ip,PlayerDetails p){
        Random rand = new Random();
        function.successLogin(userName, p.getUserUid(),p.getUserPoints());
        int num = rand.nextInt(100) + 1;
        boolean hasWon = false;
        int attempt = 5;
        System.out.println("Guess a number between 1 to 100");
        int guess = ip.nextInt();
        while (!hasWon) {
            if(guess==num){
                hasWon=true;
                break;
            }else if (guess < num) {
                System.out.println("Guess higher");
                if (attempt == 0) break;
                guess = ip.nextInt();
            } else{
                System.out.println("guess lower");
                if (attempt == 1) break;
                guess = ip.nextInt();
            }
            attempt--;
        }
        if (hasWon) {
            System.out.println("Congratulation your guess is correct and the number is " + num);
            p.updatePoints(attempt == 0 ? 10 : attempt*20);
            function.displayPoints(p.getUserPoints());
        } else {
            System.out.println("GAME OVER!!!");
            System.out.println("The Winning number is " + num);
        }
    }
}
