import game.GameUsingFuture;
import game.GameUsingThread;
import game.GameUsingCompletableFuture;

public class Application {
    public static void main(String[] args){
        // Implementation With Completable Future
        /*GameUsingFuture gameUsingFuture = new GameUsingFuture(5);
        gameUsingFuture.startGame();*/
        // Implementation Using Future
        /*GameUsingCompletableFuture gameUsingFuture = new GameUsingCompletableFuture(5);
        gameUsingFuture.startGame();*/
        // Implementation using Threads
        GameUsingThread gameUsingThread = new GameUsingThread(5);
        gameUsingThread.startGame();
    }
}
