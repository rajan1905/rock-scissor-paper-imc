import game.GameUsingFuture;
import game.GameUsingThread;
import game.GameUsingCompletableFuture;

public class Application {
    public static void main(String[] args){
        /*GameUsingFuture gameUsingFuture = new GameUsingFuture(5);
        gameUsingFuture.startGame();*/
        /*GameUsingCompletableFuture gameUsingFuture = new GameUsingCompletableFuture(5);
        gameUsingFuture.startGame();*/
        GameUsingThread gameUsingThread = new GameUsingThread(5);
        gameUsingThread.startGame();
    }
}
