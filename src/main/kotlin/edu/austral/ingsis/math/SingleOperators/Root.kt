package edu.austral.ingsis.math.SingleOperators

import edu.austral.ingsis.math.Term
import edu.austral.ingsis.math.Visitors.Visitor


class Root(override val term: Term) : SingleOp {
    override fun solve(variableValue: Map<String, Double>): Double {
        return Math.sqrt(term.solve(variableValue))
    }

    override fun print(): String {
        return " " + "(" + "√" + term.print() + ")"
    }

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

}