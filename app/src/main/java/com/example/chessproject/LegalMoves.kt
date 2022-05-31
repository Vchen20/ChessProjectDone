package com.example.chessproject

import kotlin.math.abs

    fun canPawnMove(from: Square, to: Square) : Boolean {
        var rightSquare = ChessGame.pieceAt(
            ChessGame.lastMove.lastMoveEnding.col + 1,
            ChessGame.lastMove.lastMoveEnding.row
        )
        var leftSquare = ChessGame.pieceAt(
            ChessGame.lastMove.lastMoveEnding.col - 1,
            ChessGame.lastMove.lastMoveEnding.row
        )
        val space = abs(from.row - to.row)
        var lastMoveSpace = ChessGame.lastMove.lastMoveStarting.row - ChessGame.lastMove.lastMoveEnding.row
        if (ChessGame.pieceAt(from)?.player == Player.WHITE) {
            if(from.col == to.col && Clear.isClearVerticallyPawn(from, to))
            {
                if(from.row == 1)
                {
                    return to.row == 2 || to.row == 3
                }
                else if(to.row > from.row && space == 1)
                {
                    return true
                }
            } //Capturing
            else if((from.col + 1 == to.col || from.col - 1 == to.col) && from.row + 1 == to.row
                && ChessGame.pieceAt(to.col, to.row) != null)
            {
                return true
            }
            //en passant
            /*      else if(lastMove.Player == Player.BLACK && lastMoveSpace == 2 && lastMove.PieceType == Types.PAWN)
                  {
                      if(lastMove.lastMoveEnding.col == 0)
                      {
                          if(rightSquare?.types == Types.PAWN && rightSquare.player == Player.BLACK)
                          {
                              chessArray.remove(pieceAt(to.col, to.row-1))
                              return true
                          }
                      }
                      else if(lastMove.lastMoveEnding.col == 7)
                      {
                          if(leftSquare?.types == Types.PAWN && leftSquare.player == Player.BLACK)
                          {
                              chessArray.remove(pieceAt(to.col, to.row-1))
                              return true
                          }
                      }
                      else{
                          if((leftSquare?.types == Types.PAWN && leftSquare.player == Player.BLACK)
                              || (rightSquare?.types == Types.PAWN && rightSquare.player == Player.BLACK))
                          {
                              chessArray.remove(pieceAt(to.col, to.row-1))
                              return true
                          }
                      }
                  }*/
        }
        else{
            if(from.col == to.col && Clear.isClearVerticallyPawn(from, to))
            {
                if(from.row == 6)
                {
                    return to.row == 5 || to.row == 4
                }
                else if(space == 1 && to.row < from.row){
                    return true
                }
            } //capturing
            else if((from.col + 1 == to.col || from.col - 1 == to.col) && from.row - 1 == to.row
                && ChessGame.pieceAt(to.col, to.row) != null) {
                return true
            }
        }

        return false
    }

    fun canKnightMove(from: Square, to: Square): Boolean {
        if((abs(from.col - to.col) == 2 && abs(from.row - to.row) == 1))
        {
            return true
        }
        else if ((abs(from.col - to.col) == 1 && abs(from.row - to.row) == 2))
        {
            return true
        }
        return false
    }

    fun canRookMove(from: Square, to: Square): Boolean {
        if((from.col == to.col && Clear.isClearVertically(from, to)
            || from.row == to.row && Clear.isClearHorizontally(from, to)))
        {
            return true
        }
        return false
    }

    fun canBishopMove(from: Square, to: Square): Boolean {
        if ((abs(from.col - to.col) == abs(from.row - to.row))) {
            return Clear.isClearDiagonally(from, to)
        }
        return false
    }

    fun canQueenMove(from: Square, to: Square) : Boolean {
        if((canBishopMove(from, to) || canRookMove(from, to))){
            return true
        }
        return false
    }

    fun canKingMove(from: Square, to: Square) : Boolean {
        if(abs(from.col - to.col) <= 1 && abs(from.row - to.row) <= 1) {
            return true
        }
        return false
    }


