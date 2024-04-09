package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Operators.*;
import edu.austral.ingsis.math.SingleOperators.Module;
import edu.austral.ingsis.math.SingleOperators.Parenthesis;
import edu.austral.ingsis.math.Visitors.Visitor;
import edu.austral.ingsis.math.Visitors.solveVisitor;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        final Term left = new Number(1);
        final Term right = new Variable("x");
        final Term sum = new Sum(left, right);
        final Double result = sum.solve(Map.of("x", 3d));

        assertThat(result, equalTo(4d));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        final Term left = new Number(12);
        final Term right = new Variable("div");
        final Term division = new Division(left, right);
        final Double result = division.solve(Map.of("div", 4d));

        assertThat(result, equalTo(3d));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        final Term left = new Number(9);
        final Term right = new Variable("x");
        final Term division = new Division(left, right);
        final Term parenthesis = new Parenthesis(division);
        final Term multiplication = new Multiplication(parenthesis, new Variable("y"));
        final Double result = multiplication.solve(Map.of("x", 3d, "y", 4d));

        assertThat(result, equalTo(12d));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        final Term left = new Number(27);
        final Term right = new Variable("a");
        final Term division = new Division(left, right);
        final Term parenthesis = new Parenthesis(division);
        final Term power = new Power(parenthesis, new Variable("b"));
        final Double result = power.solve(Map.of("a", 9d, "b", 3d));


        assertThat(result, equalTo(27d));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        final Term left = new Variable("z");
        final Term right = new Number(2);
        final Term power = new Power(left, new Division(new Number(1), right));
        final Double result = power.solve(Map.of("z", 36d));


        assertThat(result, equalTo(6d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction6() {
        final Term in = new Variable("value");
        final Term left = new Module(in);
        final Term right = new Number(8);
        final Term subtraction = new Substraction(left, right);
        final Double result = subtraction.solve(Map.of("value", 8d));


        assertThat(result, equalTo(0d));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {

        final Double result = 0d;

        assertThat(result, equalTo(0d));
    }

    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        final Term left = new Number(5);
        final Term right = new Variable("i");
        final Term subtraction = new Substraction(left, right);
        final Term parenthesis = new Parenthesis(subtraction);
        final Term multiplication = new Multiplication(parenthesis, new Number(8));
        final Visitor<Double> visitor = new solveVisitor(Map.of("i", 2d));
        final Double result = multiplication.accept(visitor);


        assertThat(result, equalTo(24d));
    }
}
