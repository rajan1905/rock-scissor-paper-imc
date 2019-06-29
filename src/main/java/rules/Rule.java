package rules;

import entity.Symbol;

import java.util.Arrays;
import java.util.List;

public class Rule {

    private static final String HUMAN_WON = "Human Won.";
    private static final String COMPUTER_WON = "Computer Won.";
    private static final String DRAW = "It's a draw";
    private Rule(){}
    private static List<Symbol> rulesHierarchy =
            Arrays.asList(Symbol.OPEN, Symbol.FIST, Symbol.FINGER_INDEX_MIDDLE);

    /**
     * • Paper beats (wraps) rock
     * • Rock beats (blunts) scissors
     * • Scissors beats (cuts) paper.
     * @param human
     * @param computer
     * @return
     */
    private static boolean evaluate(Symbol human, Symbol computer){
        boolean result = false;

        byte humanAtIndex = (byte) rulesHierarchy.indexOf(human);
        byte computerAtIndex = (byte) rulesHierarchy.indexOf(computer);

        if(humanAtIndex == rulesHierarchy.size()-1 && computerAtIndex == 0) result = true;
        else if(humanAtIndex==0 && computerAtIndex==rulesHierarchy.size()-1) result = false;
        else if(humanAtIndex < computerAtIndex) result = true;

        return result;
    }

    public static String whoWon(Symbol human, Symbol computer){
        String result;
        if(isADraw(human, computer)) result = DRAW;
        else{
            result = evaluate(human, computer) ? HUMAN_WON:COMPUTER_WON;
        }

        return result;
    }

    private static boolean isADraw(Symbol human, Symbol computer){
        return human.equals(computer);
    }

    public static Symbol getHandEquivalent(String hand){
        Symbol symbol = null;
        if(hand.equalsIgnoreCase("Fist")) symbol = Symbol.FIST;
        if(hand.equalsIgnoreCase("Open")) symbol = Symbol.OPEN;
        if(hand.equalsIgnoreCase("FINGER_INDEX_MIDDLE")) symbol = Symbol.FINGER_INDEX_MIDDLE;
        return symbol;
    }

    public static Symbol getHandEquivalent(int hand){
        String handInString = "";
        if(hand == 1) handInString = "Fist";
        else if(hand == 2) handInString = "Open";
        else if(hand == 3) handInString = "FINGER_INDEX_MIDDLE";
        else{
            System.out.println("Computer won't play with you. Shouldn't you learn the game first..?");
            System.exit(1);
        }

        return getHandEquivalent(handInString);
    }
}
