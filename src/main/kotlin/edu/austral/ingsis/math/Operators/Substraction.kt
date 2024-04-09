package edu.austral.ingsis.math.Operators

import edu.austral.ingsis.math.Term
import edu.austral.ingsis.math.Visitors.Visitor

class Substraction(override val left: Term, override val right: Term) : Operation {
    override fun solve(variableValue: Map<String, Double>): Double {
        return left.solve(variableValue) - right.solve(variableValue)
    }

    override fun print(): String {
        return " " + left.print() + " - " + right.print()
    }

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }
}