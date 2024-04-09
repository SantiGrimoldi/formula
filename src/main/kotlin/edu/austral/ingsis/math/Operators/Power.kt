package edu.austral.ingsis.math.Operators

import edu.austral.ingsis.math.Term
import edu.austral.ingsis.math.Visitors.Visitor

class Power(override val left: Term, override val right: Term) : Operation{
    val power: Term

    init {
        this.power = right
    }
    override fun solve(variableValue: Map<String, Double>): Double {
        return Math.pow(left.solve(variableValue), power.solve(variableValue))
    }

    override fun print(): String {
        return " " + left.print() + " ^ " + power.print()
    }

    override fun <T> accept(visitor: Visitor<T>) : T {
        return visitor.visit(this)
    }
}