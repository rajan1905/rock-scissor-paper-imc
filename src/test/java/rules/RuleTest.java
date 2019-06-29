package rules;

import entity.Symbol;
import org.junit.Assert;
import org.junit.Test;

public class RuleTest {

    @Test
    public void testRockScissor(){
        Symbol human = Symbol.FIST;
        Symbol computer = Symbol.FINGER_INDEX_MIDDLE;

        Assert.assertEquals(Rule.whoWon(human,computer), "Human Won.");
    }

    @Test
    public void testScissorRock(){
        Symbol human = Symbol.FINGER_INDEX_MIDDLE;
        Symbol computer = Symbol.FIST;

        Assert.assertEquals(Rule.whoWon(human,computer), "Computer Won.");
    }

    @Test
    public void testPaperScissor(){
        Symbol human = Symbol.OPEN;
        Symbol computer = Symbol.FINGER_INDEX_MIDDLE;

        Assert.assertEquals(Rule.whoWon(human,computer), "Computer Won.");
    }

    @Test
    public void testScissorPaper(){
        Symbol human = Symbol.FINGER_INDEX_MIDDLE;
        Symbol computer = Symbol.OPEN;

        Assert.assertEquals(Rule.whoWon(human,computer), "Human Won.");
    }

    @Test
    public void testRockPaper(){
        Symbol human = Symbol.FIST;
        Symbol computer = Symbol.OPEN;

        Assert.assertEquals(Rule.whoWon(human,computer), "Computer Won.");
    }

    @Test
    public void testPaperRock(){
        Symbol human = Symbol.OPEN;
        Symbol computer = Symbol.FIST;

        Assert.assertEquals(Rule.whoWon(human,computer), "Human Won.");
    }
}
