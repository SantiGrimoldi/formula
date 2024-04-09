package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Visitors.PrintVisitor;
import edu.austral.ingsis.math.Visitors.Visitor;
import edu.austral.ingsis.math.factory.CreateEquations;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    private final CreateEquations creator = new CreateEquations();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = " 1.0 + 6.0";
        final Term left = creator.createNumber(1);
        final Term right = creator.createNumber(6);
        final String result = creator.createSum(left, right).print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = " 12.0 / 2.0";
        final Term left = creator.createNumber(12);
        final Term right = creator.createNumber(2);
        final Term division = creator.createDivision(left, right);
        final String result = division.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "(9.0 / 2.0) * 3.0";
        final Term left = creator.createNumber(9);
        final Term right = creator.createNumber(2);
        final Term division = creator.createDivision(left, right);
        final Term parenthesis = creator.createParenthesis(division);
        final Term multiplication = creator.createMultiplication(parenthesis, creator.createNumber(3));
        final Visitor<String> visitor = new PrintVisitor();

        final String result = multiplication.accept(visitor);
//                multiplication.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = " ( 27.0 / 6.0) ^ 2.0";
        final Term left = creator.createNumber(27);
        final Term right = creator.createNumber(6);
        final Term division = creator.createDivision(left, right);
        final Term parenthesis = creator.createParenthesis(division);
        final Term power = creator.createPower(parenthesis, creator.createNumber(2));
        final String result = power.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction6() {
        final String expected = " |value| - 8.0";
        final Term left = creator.createVariable("value");
        final Term right = creator.createNumber(8);
        final Term module =  creator.createModule(left);
        final Term subtraction = creator.createSubstraction(module, right);
        final String result = subtraction.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = " |value| - 8.0";
        final Term left = creator.createVariable("value");
        final Term right = creator.createNumber(8);
        final Term module =  creator.createModule(left);
        final Term subtraction = creator.createSubstraction(module, right);
        final String result = subtraction.print();

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = " ( 5.0 - i) * 8.0";
        final Term left = creator.createNumber(5);
        final Term right = creator.createVariable("i");
        final Term subtraction = creator.createSubstraction(left, right);
        final Term parenthesis = creator.createParenthesis(subtraction);
        final Term multiplication = creator.createMultiplication(parenthesis, creator.createNumber(8));
        final String result = multiplication.print();

        assertThat(result, equalTo(expected));
    }
}
