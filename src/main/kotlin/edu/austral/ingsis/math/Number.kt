package edu.austral.ingsis.math

import edu.austral.ingsis.math.Visitors.Visitor

class Number(number: Double) : Term{
    val number: Double

    init {
        this.number = number
    }

    override fun solve(variableValue: Map<String, Double>): Double {
        return number
    }

    override fun print(): String {
        return number.toString()
    }

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }

}