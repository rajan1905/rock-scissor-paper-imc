package game;

import entity.Symbol;
import rules.Rule;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class GameUsingCompletableFuture {
    private int numberOfTimes;
    private Symbol human, computer;
    private static final Scanner scanner = new Scanner(System.in);
    byte gameCount = 1;
    private Random random = new Random();

    Runnable computerRunnable = () -> {
        computer = Rule.getHandEquivalent(random.nextInt(3) + 1);
        System.out.println(Rule.whoWon(human, computer));
        human=computer=null;
        gameCount++;
    };

    Runnable humanRunnable = () -> {
        System.out.println("\t\t\t GameUsingFuture count "+gameCount+" started");
        System.out.println("Enter 1 -> Fist, 2 -> Open Hand & 3-> Index and Middle Finger");
        human = Rule.getHandEquivalent(scanner.nextInt());
    };

    public GameUsingCompletableFuture(int times){
        numberOfTimes = times;
    }

    public synchronized void startGame(){
        for(int i=1 ; i<=numberOfTimes; i++){
            CompletableFuture singleGame = CompletableFuture.runAsync(humanRunnable).thenRun(computerRunnable);
            while (!singleGame.isDone()) {}
        }
    }
}
