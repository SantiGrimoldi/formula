package edu.austral.ingsis.math.Operators

import edu.austral.ingsis.math.Term

interface Operation : Term {
    val left: Term
    val right: Term

}