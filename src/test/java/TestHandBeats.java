

import com.githab.grinevskayaab.hand.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestHandBeats {
    @Test
    public void rock() {
        Hand rock = Hand.ROCK;

        Assertions.assertTrue(rock.beats(Hand.SCISSORS), "Камень проиграл ножницам");
        Assertions.assertFalse(rock.beats(Hand.PAPER), "Камень выиграл бумагу");
        Assertions.assertFalse(rock.beats(Hand.ROCK), "Камень выиграл камень");
        Assertions.assertFalse(rock.beats(Hand.WELL), "Камень выиграл колодец");
    }

    @Test
    public void paper() {
        Hand paper = Hand.PAPER;

        Assertions.assertFalse(paper.beats(Hand.SCISSORS), "Бумага выиграла ножницы");
        Assertions.assertFalse(paper.beats(Hand.PAPER), "Бумага проиграла ножницам");
        Assertions.assertTrue(paper.beats(Hand.ROCK), "Бумага проиграла камню");
        Assertions.assertTrue(paper.beats(Hand.WELL), "Бумага проиграла колодцу");
    }

    @Test
    public void scissors() {
        Hand scissors = Hand.SCISSORS;

        Assertions.assertFalse(scissors.beats(Hand.SCISSORS), "Ножницы выиграли ножницы");
        Assertions.assertTrue(scissors.beats(Hand.PAPER), "Ножницы проиграли бумаге");
        Assertions.assertFalse(scissors.beats(Hand.ROCK), "Ножницы выиграли камень");
        Assertions.assertFalse(scissors.beats(Hand.WELL), "Ножницы выиграли колодец");
    }

    @Test
    public void well() {
        Hand well = Hand.WELL;

        Assertions.assertTrue(well.beats(Hand.SCISSORS), "Колодец проиграл ножницам");
        Assertions.assertFalse(well.beats(Hand.PAPER), "Колодец выиграл бумагу");
        Assertions.assertTrue(well.beats(Hand.ROCK), "Колодец проиграл камню");
        Assertions.assertFalse(well.beats(Hand.WELL), "Колодец выиграл колодец");
    }
}
