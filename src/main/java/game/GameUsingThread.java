package game;

import entity.Symbol;
import rules.Rule;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class GameUsingThread {
    private int numberOfTimes;
    private static final int SLEEP_TIME = 500;
    private AtomicBoolean humanInputDone = new AtomicBoolean(false);
    private Symbol human, computer;
    private static final Scanner scanner = new Scanner(System.in);
    private AtomicInteger gameCount = new AtomicInteger(1);
    private Random random = new Random();

    Runnable computerRunnable = () -> {
        while(true){
            if(humanInputDone.get() == true){
                try {
                    computer = Rule.getHandEquivalent(random.nextInt(3) + 1);
                    System.out.println(Rule.whoWon(human, computer));
                    human=computer=null;
                    if(gameCount.get() == numberOfTimes+1)
                        System.exit(0);
                    Thread.sleep(SLEEP_TIME);
                    humanInputDone.set(false);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable humanRunnable = () -> {
        while(true){
            if(humanInputDone.get() == false){
                System.out.println("\t\t\t Game count "+gameCount.getAndAdd(1)+" started");
                System.out.println("Enter 1 -> Fist, 2 -> Open Hand & 3-> Index and Middle Finger");
                human = Rule.getHandEquivalent(scanner.nextInt());
                humanInputDone.set(true);
            }
        }
    };

    public GameUsingThread(int times){
        numberOfTimes = times;
    }

    public synchronized void startGame(){
        new Thread(computerRunnable).start();
        new Thread(humanRunnable).start();
    }
}
