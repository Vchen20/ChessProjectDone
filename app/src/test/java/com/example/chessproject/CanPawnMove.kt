package com.example.chessproject

import org.junit.Test
import org.junit.Assert.*


class CanPawnMove {
    @Test
    fun canPawnMove(){
        ChessGame.clear()
        ChessGame.addPiece(Piece(3,1, Player.WHITE, Types.PAWN, -1))
        ChessGame.addPiece(Piece(4,2, Player.BLACK, Types.PAWN, -1))
        println(ChessGame)
        //assertTrue(ChessGame.canPawnMove(Square(4,2), Square(3,1)))
        //assertFalse(ChessGame.canPawnMove(Square(3,1), Square(4,0)))
    }
}