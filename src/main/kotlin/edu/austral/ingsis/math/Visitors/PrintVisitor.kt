package edu.austral.ingsis.math.Visitors

import edu.austral.ingsis.math.Number
import edu.austral.ingsis.math.Operators.*
import edu.austral.ingsis.math.SingleOperators.Module
import edu.austral.ingsis.math.SingleOperators.Parenthesis
import edu.austral.ingsis.math.SingleOperators.Root
import edu.austral.ingsis.math.Variable

class PrintVisitor : Visitor <String>{
    override fun visit(division: Division): String {
        return "" + division.left.accept(this) + " / " + division.right.accept(this)
    }

    override fun visit(mult: Multiplication): String {
        return "" + mult.left.accept(this) + " * " + mult.right.accept(this)
    }

    override fun visit(power: Power): String {
        return "" + power.left.accept(this) + " ^ " + power.right.accept(this)
    }

    override fun visit(subs: Substraction): String {
        return "" + subs.left.accept(this) + " - " + subs.right.accept(this)
    }

    override fun visit(sum: Sum): String {
        return "" + sum.left.accept(this) + " + " + sum.right.accept(this)
    }

    override fun visit(number: Number): String {
        return "" + number.number
    }

    override fun visit(variable: Variable): String {
        return variable.name
    }

    override fun visit(module: Module): String {
        return "|" + module.term.accept(this) + "|"
    }

    override fun visit(parenthesis: Parenthesis): String {
        return "(" + parenthesis.term.accept(this) + ")"
    }

    override fun visit(root: Root): String {
        return "√" + root.term.accept(this)
    }

}