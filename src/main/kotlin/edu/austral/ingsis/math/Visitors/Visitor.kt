package edu.austral.ingsis.math.Visitors

import edu.austral.ingsis.math.Number
import edu.austral.ingsis.math.Operators.*
import edu.austral.ingsis.math.SingleOperators.Module
import edu.austral.ingsis.math.SingleOperators.Parenthesis
import edu.austral.ingsis.math.SingleOperators.Root
import edu.austral.ingsis.math.Variable

interface Visitor<T>{
    fun visit(division : Division) : T
    fun visit(mult : Multiplication) : T
    fun visit(power : Power) : T
    fun visit(subs : Substraction) : T
    fun visit(sum : Sum) : T
    fun visit(number : Number) : T
    fun visit(variable : Variable) : T
    fun  visit(module: Module) : T
    fun  visit(parenthesis: Parenthesis) : T
    fun visit(root: Root) : T

}