package edu.austral.ingsis.math;

import edu.austral.ingsis.math.Operators.Division;
import edu.austral.ingsis.math.Operators.Sum;
import edu.austral.ingsis.math.Visitors.Visitor;
import edu.austral.ingsis.math.Visitors.solveVisitor;
import edu.austral.ingsis.math.factory.CreateEquations;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

    private final CreateEquations creator = new CreateEquations();

    /**
     * Case 1 + 6
     */
    @Test
    public void shouldResolveSimpleFunction1() {
        final Term left = new Number(1);
        final Term right = new Number(6);
        final Term sum = new Sum(left, right);
        final Double result = sum.solve(Map.of());

        assertThat(result, equalTo(7d));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        final Term left = new Number(12);
        final Term right = new Number(2);
        final Term division = new Division(left, right);
        final Double result = division.solve(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        final Term left = creator.createNumber(9);
        final Term right = creator.createNumber(2);
        final Term division = creator.createDivision(left, right);
        final Term parenthesis = creator.createParenthesis(division);
        final Term multiplication = creator.createMultiplication(parenthesis, creator.createNumber(3));
        final Double result = multiplication.solve(Map.of());

        assertThat(result, equalTo(13.5d));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        final Term left = creator.createNumber(27);
        final Term right = creator.createNumber(6);
        final Term division = creator.createDivision(left, right);
        final Term parenthesis = creator.createParenthesis(division);
        final Term power = creator.createPower(parenthesis, creator.createNumber(2));
        final Double result = power.solve(Map.of());

        assertThat(result, equalTo(20.25d));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        final Term left = creator.createNumber(36);
        final Term power = creator.createPower(left, creator.createNumber(0.5));
        final Double result = power.solve(Map.of());

        assertThat(result, equalTo(6d));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Term module = creator.createModule(creator.createNumber(136));
        final Double result = module.solve(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Term module = creator.createModule(creator.createNumber(-136));
        final Double result = module.solve(Map.of());

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        final Term left = creator.createNumber(5);
        final Term right = creator.createNumber(5);
        final Term subtraction = creator.createSubstraction(left, right);
        final Term parenthesis = creator.createParenthesis(subtraction);
        final Term multiplication = creator.createMultiplication(parenthesis, creator.createNumber(8));
        final Visitor<Double> visitor = new solveVisitor(Map.of());
        final Double result = multiplication.accept(visitor);
//        final Double result = creator.createNumber(0).solve(Map.of());

        assertThat(result, equalTo(0d));
    }
}
