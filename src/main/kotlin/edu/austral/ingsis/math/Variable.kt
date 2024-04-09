package edu.austral.ingsis.math

import edu.austral.ingsis.math.Visitors.Visitor

class Variable (name : String) : Term {
    val name: String

    init {
        this.name = name
    }

    override fun solve(variableValue: Map<String, Double>): Double {
        return variableValue.get(name)!!
    }

    override fun print(): String {
        return name
    }

    override fun <T> accept(visitor: Visitor<T>): T {
        return visitor.visit(this)
    }


}