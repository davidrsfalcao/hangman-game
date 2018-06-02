package tests;

import database.Dictionary.Category;
import database.Word;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestDatabase {

    @Test
    public void testWord(){
        Word word = new Word("caranguejo",Category.animal);

        assertEquals("caranguejo", word.getComplete());
        assertEquals(Category.animal, word.getCategory());
        assertEquals(10, word.getRemainingLetters().size());
        assertEquals("__________", word.toString());
        assertEquals("__________", word.testLetter('i'));
        assertEquals("_a_a______", word.testLetter('a'));
        assertEquals("ca_a______", word.testLetter('c'));
        assertEquals("cara______", word.testLetter('r'));
        assertEquals("cara_____o", word.testLetter('o'));
        assertEquals("cara____jo", word.testLetter('j'));
        assertEquals("cara___ejo", word.testLetter('e'));
        assertEquals("caran__ejo", word.testLetter('n'));
        assertEquals("caran_uejo", word.testLetter('u'));
        assertEquals("caranguejo", word.testLetter('g'));
        assertEquals(0, word.getRemainingLetters().size());


    }


}
