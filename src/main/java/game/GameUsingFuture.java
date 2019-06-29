package game;

import entity.Symbol;
import rules.Rule;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class GameUsingFuture {
    private int numberOfTimes;
    private Symbol human, computer;
    private static final Scanner scanner = new Scanner(System.in);
    private AtomicInteger gameCount = new AtomicInteger(1);
    private Random random = new Random();
    ExecutorService es = Executors.newCachedThreadPool();

    Runnable computerRunnable = () -> {
        computer = Rule.getHandEquivalent(random.nextInt(3) + 1);
    };

    Runnable humanRunnable = () -> {
        System.out.println("\t\t\t GameUsingFuture count "+gameCount.getAndAdd(1)+" started");
        System.out.println("Enter 1 -> Fist, 2 -> Open Hand & 3-> Index and Middle Finger");
        human = Rule.getHandEquivalent(scanner.nextInt());
    };

    public GameUsingFuture(int times){
        numberOfTimes = times;
    }

    public synchronized void startGame(){
        for(int i=0; i<numberOfTimes;i++){
            Future humanFuture = es.submit(humanRunnable);
            Future computerFuture = es.submit(computerRunnable);
            while(!humanFuture.isDone() || !computerFuture.isDone()){}
            System.out.println(Rule.whoWon(human, computer));
            human=computer=null;
        }
        es.shutdownNow();
    }
}
