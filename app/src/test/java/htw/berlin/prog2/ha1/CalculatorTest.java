package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    /**
    * Teilaufgabe 1: Schreiben Sie einen neuen zusätzlichen Test,
    * der eine bisher nicht getestete Funktionalität abdeckt, die
    * bereits funktioniert und der daher direkt grün wird.
    */

    //Testfall: Subtaktion von positiven Zahlen
    
    @Test
    @DisplayName("should display result after subtracting two positive multi-digit numbers")
      void testPositiveSubtraction() {
          Calculator calc = new Calculator();
   
          calc.pressDigitKey(2);
          calc.pressDigitKey(0);
          calc.pressBinaryOperationKey("-");
          calc.pressDigitKey(1);
          calc.pressDigitKey(0);
          calc.pressEqualsKey();
   
          String expected = "10";
          String actual = calc.readScreen();
   
          assertEquals(expected, actual);
    }

    /**
    * Teilaufgabe 2: Schreiben Sie zwei weitere zusätzliche Tests, 
    * die zwei unterschiedliche Fehlerkategorien aufdecken (d.h. deren 
    * Fehlerursachen in unterschiedlichen Methoden liegen) und somit fehlschlagen.
    */

    //Testfall: Nur die letzte Eingabe soll gelöscht werden 
    //prüft die pressClearKey-Methode, um sicherzustellen, dass nur die letzte 
    //und nicht die gänzliche Eingabe gelöscht wird

    @Test
    @DisplayName("should only delete last number entered when pressed once")
    void testClearKey() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressBinaryOperationKey("x");
        calc.pressDigitKey(5);
        calc.pressClearKey();
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        String expected = "14";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Testfall: Eingabe von einzelner Zahl, soll auch einzelne Zahl im Ergebnis anzeigen 
    //und nicht als Error angezeigt werden 
    //prüft die pressEqualsrKey-Methode, um sicherzustellen, dass bei Eingabe einer Zahl ohne 
    //Operation auch die eingegebene Zahl, unverändert im Ergebnis anzeigt wird

    @Test
    @DisplayName("should display the same number when equals is pressed without an operation")
     void testEqualsWithoutOperation() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "3"; 
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }
}
   
