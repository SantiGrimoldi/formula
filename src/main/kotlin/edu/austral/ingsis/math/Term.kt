package edu.austral.ingsis.math

import edu.austral.ingsis.math.Visitors.Visitor


interface Term {
    fun solve(variableValue: Map<String, Double>) : Double
    fun print() : String
    fun <T> accept(visitor: Visitor<T>) : T
}