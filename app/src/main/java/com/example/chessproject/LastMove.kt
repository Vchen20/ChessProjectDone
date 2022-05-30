package com.example.chessproject

data class LastMove(
    var lastMoveStarting: Square,
    var lastMoveEnding: Square,
    var Player: Player,
    var PieceType: Types
)
