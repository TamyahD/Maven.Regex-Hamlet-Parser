import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HamletParserTest {
    private String hamletText;
    private HamletParser hamletParser;

    @Before
    public void setUp() {
        this.hamletParser = new HamletParser();
        this.hamletText = hamletParser.getHamletData();
    }

    @Test
    public void testChangeHamletToLeon() {
        // Given
        String actualHamletToLeon = hamletParser.replaceHamletWithLeon();
        String[] words = actualHamletToLeon.split("\\s+");
        int countOfHamlet =0;
        int countOfLeon =0;
        // When
        for (String word : words) {
            if (word.equalsIgnoreCase("hamlet")) {
                countOfHamlet++;
            }
            if (word.equalsIgnoreCase("leon")) {
                countOfLeon++;
            }
        }
        // Then
        assertEquals(0, countOfHamlet);
        assertTrue(countOfLeon>0);
    }

    @Test
    public void testChangeHoratioToTariq() {
        // Given
        String actualHoratioToTariq = hamletParser.replaceHoratioWithTariq();
        String[] words = actualHoratioToTariq.split("\\s+");
        int countOfHoratio=0;
        int countOfTariq=0;
        // When
        for (String word : words) {
            if (word.equalsIgnoreCase("horatio")) {
                countOfHoratio++;
            }
            if (word.equalsIgnoreCase("tariq")) {
                countOfTariq++;
            }
        }
        // Then
        assertEquals(0, countOfHoratio);
        assertTrue(countOfTariq>0);
    }

    @Test
    public void testFindHoratio() {
        // Given
        String strHoratio="horatio";
        boolean actualFoundHoratioOutcome=hamletParser.findInput(strHoratio);
        // When
        boolean expectedFoundHoratioOutcome=true;
        // Then
        assertEquals(expectedFoundHoratioOutcome, actualFoundHoratioOutcome);
    }

    @Test
    public void testFindHamlet() {
        // Given
        String strHamlet="Hamlet";
        boolean actualFoundHamletOutcome=hamletParser.findInput(strHamlet);
        // When
        boolean expectedFoundHamletOutcome=true;
        // Then
        assertEquals(expectedFoundHamletOutcome, actualFoundHamletOutcome);
    }

    @Test
    public void testGetNumOfHamletOccurrences() {
        // Given
        int expectedHamletOccurrences = 472;
        // When
        int actualHamletOccurrences=hamletParser.howManyTimesFound("hamlet");
        // Then
        assertTrue(actualHamletOccurrences>10);
        assertEquals(expectedHamletOccurrences, actualHamletOccurrences);
    }
}