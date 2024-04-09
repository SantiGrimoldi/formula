package edu.austral.ingsis.math.Visitors

import edu.austral.ingsis.math.Number
import edu.austral.ingsis.math.Operators.*
import edu.austral.ingsis.math.SingleOperators.Module
import edu.austral.ingsis.math.SingleOperators.Parenthesis
import edu.austral.ingsis.math.SingleOperators.Root
import edu.austral.ingsis.math.Variable

class solveVisitor(variableNumbers:Map<String, Double>) : Visitor<Double> {

    private val variableNumbers: Map<String, Double>
    init {
        this.variableNumbers = variableNumbers
    }
    override fun visit(division: Division): Double {
        return division.left.accept(this) / division.right.accept(this)
    }

    override fun visit(mult: Multiplication): Double {
        return mult.left.accept(this) * mult.right.accept(this)
    }

    override fun visit(power: Power): Double {
        return Math.pow(power.left.accept(this), power.right.accept(this))
    }

    override fun visit(subs: Substraction): Double {
        return subs.left.accept(this) - subs.right.accept(this)
    }

    override fun visit(sum: Sum): Double {
        return sum.left.accept(this) + sum.right.accept(this)
    }

    override fun visit(number: Number): Double {
        return number.number
    }

    override fun visit(variable: Variable): Double {
        return variableNumbers[variable.name]!!
    }

    override fun visit(module: Module): Double {
        return Math.abs(module.term.accept(this))
    }

    override fun visit(parenthesis: Parenthesis): Double {
        return parenthesis.term.accept(this)
    }

    override fun visit(root: Root): Double {
        return Math.sqrt(root.term.accept(this))
    }
}