package edu.austral.ingsis.math.factory

import edu.austral.ingsis.math.Number
import edu.austral.ingsis.math.Operators.Division
import edu.austral.ingsis.math.Operators.Multiplication
import edu.austral.ingsis.math.Operators.Substraction
import edu.austral.ingsis.math.Operators.Sum
import edu.austral.ingsis.math.SingleOperators.Module
import edu.austral.ingsis.math.SingleOperators.Parenthesis
import edu.austral.ingsis.math.Operators.Power
import edu.austral.ingsis.math.SingleOperators.Root
import edu.austral.ingsis.math.Term
import edu.austral.ingsis.math.Variable

class CreateEquations {
    fun createSum(left: Term, right: Term): Term {
        return Sum(left, right)
    }

    fun createSubstraction(left: Term, right: Term): Term {
        return Substraction(left, right)
    }

    fun createMultiplication(left: Term, right: Term): Term {
        return Multiplication(left, right)
    }

    fun createDivision(left: Term, right: Term): Term {
        return Division(left, right)
    }

    fun createSquareRoot(term: Term): Term {
        return Root(term)
    }

    fun createModule(term: Term): Term {
        return Module(term)
    }

    fun createPower(term: Term, power : Term): Term {
        return Power(term, power)
    }

    fun createNumber(number: Double): Term {
        return Number(number)
    }

    fun createVariable(variable: String): Term {
        return Variable(variable)
    }

    fun createParenthesis (term: Term): Term {
        return Parenthesis(term)
    }

}