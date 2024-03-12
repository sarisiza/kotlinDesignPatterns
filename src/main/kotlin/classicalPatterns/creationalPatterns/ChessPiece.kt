package classicalPatterns.creationalPatterns

//Factory Design Pattern
interface ChessPiece {
    val file: Char
    val rank: Char
}

data class Pawn(override val file: Char, override val rank: Char): ChessPiece
data class Queen(override val file: Char, override val rank: Char): ChessPiece
data class King(override val file: Char, override val rank: Char): ChessPiece
data class Bishop(override val file: Char, override val rank: Char): ChessPiece
data class Knight(override val file: Char, override val rank: Char): ChessPiece
data class Rook(override val file: Char, override val rank: Char): ChessPiece

fun createPiece(notation: String): ChessPiece{
    val (type, file, rank) = notation.toCharArray() //destructing declaration
    return when(type){
        'q' -> Queen(file, rank)
        'p' -> Pawn(file, rank)
        'b' -> Bishop(file, rank)
        'k' -> King(file, rank)
        'r' -> Rook(file, rank)
        'n' -> Knight(file, rank)
        else -> throw Exception("Unknown piece: $type")
    }
}