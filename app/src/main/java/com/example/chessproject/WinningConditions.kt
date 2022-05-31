package com.example.chessproject

lateinit var whiteKing : Piece
lateinit var blackKing : Piece
object WinningConditions {
    fun check() : Boolean {
        if (turn % 2 == 0)
        {
            for(pieces in chessArray)
            {
                if(pieces.player == Player.WHITE && pieces.types == Types.KING)
                {
                    var gap = 0
                    whiteKing = pieces
                    var topRight = ChessGame.pieceAt(whiteKing.col + 1, whiteKing.row + 1)
                    var topLeft = ChessGame.pieceAt(whiteKing.col - 1, whiteKing.row + 1)
                    if(topRight?.player == Player.BLACK || topLeft?.player == Player.BLACK)
                    {
                        if(topRight?.types == Types.PAWN || topRight?.types == Types.BISHOP
                            || topRight?.types == Types.QUEEN || topLeft?.types == Types.PAWN
                            || topLeft?.types == Types.BISHOP || topLeft?.types == Types.QUEEN)
                        {
                            return true
                        }
                    }
                    for(i in whiteKing.row .. 7)
                    {
                        if(ChessGame.pieceAt(whiteKing.col, i)?.player == Player.BLACK
                            && (ChessGame.pieceAt(whiteKing.col, i)?.types == Types.QUEEN
                                    || ChessGame.pieceAt(whiteKing.col, i)?.types == Types.ROOK))
                        {
                            return true
                        }
                    }//Top Right of King
                    gap = 7 - whiteKing.row
                    for(i in 1..gap) {
                        val nextCol = whiteKing.col + i
                        val nextRow = whiteKing.row + i
                        if(ChessGame.pieceAt(nextCol, nextRow)?.types == Types.QUEEN
                            || ChessGame.pieceAt(nextCol, nextRow)?.types == Types.BISHOP)
                        {
                            return true
                        }
                        else if(ChessGame.pieceAt(nextCol, nextRow) != null)
                        {
                            break
                        }
                    }
                    for(i in 0 .. whiteKing.row)
                    {
                        val nextCol = whiteKing.col - i
                        val nextRow = whiteKing.row - i
                        if(ChessGame.pieceAt(whiteKing.col, i)?.player == Player.BLACK
                            && (ChessGame.pieceAt(whiteKing.col, i)?.types == Types.QUEEN
                                    || ChessGame.pieceAt(whiteKing.col, i)?.types == Types.ROOK))
                        {
                            return true
                        } //Bottom Left of King
                        else if(ChessGame.pieceAt(nextCol, nextRow)?.types == Types.QUEEN
                            || ChessGame.pieceAt(nextCol, nextRow)?.types == Types.BISHOP) {
                                return true
                        }
                        else if(ChessGame.pieceAt(nextCol, nextRow) != null)
                        {
                            break
                        }
                    }
                    for(i in 0 .. whiteKing.col)
                    {
                        if(ChessGame.pieceAt(i, whiteKing.row)?.player == Player.BLACK
                            && (ChessGame.pieceAt(i, whiteKing.row)?.types == Types.QUEEN
                                    || ChessGame.pieceAt(i, whiteKing.row)?.types == Types.ROOK))
                        {
                            return true
                        }
                    }
                    //Bottom Right of King
                    gap = 7 - whiteKing.col
                    for(i in 1..gap) {
                        val nextCol = whiteKing.col + i
                        val nextRow = whiteKing.row - i
                        if(ChessGame.pieceAt(nextCol, nextRow)?.types == Types.QUEEN
                            || ChessGame.pieceAt(nextCol, nextRow)?.types == Types.BISHOP)
                        {
                            return true
                        }
                        else if(ChessGame.pieceAt(nextCol, nextRow) != null)
                        {
                            break
                        }
                    }
                    for(i in whiteKing.col .. 7)
                    {
                        val nextCol = whiteKing.col - i
                        val nextRow = whiteKing.row + i
                        if(ChessGame.pieceAt(i, whiteKing.row)?.player == Player.BLACK
                            && (ChessGame.pieceAt(i, whiteKing.row)?.types == Types.QUEEN
                                    || ChessGame.pieceAt(i, whiteKing.row)?.types == Types.ROOK))
                        {
                            return true
                        }
                        //Top Left of King
                        else if(ChessGame.pieceAt(nextCol, nextRow)?.types == Types.QUEEN
                            || ChessGame.pieceAt(nextCol, nextRow)?.types == Types.BISHOP) {
                            return true
                        }
                        else if(ChessGame.pieceAt(nextCol, nextRow) != null)
                        {
                            break
                        }
                    }

                }
            }
        }
        return false
    }
}