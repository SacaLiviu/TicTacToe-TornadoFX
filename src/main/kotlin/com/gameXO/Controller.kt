package com.gameXO

import javafx.beans.property.SimpleStringProperty
import tornadofx.Controller

class Controller : Controller() {
    var board=IntArray(9)
    var player1Win=false
    var player2Win=false
    var draw=false
 //player 1=1 player2=2 no player=0
    var winner = SimpleStringProperty()
    //check for player 1 win
    private fun checkWinPlayer1() {
        player1Win = if (board[0] == 1 && board[1] == 1 && board[2] == 1)
            true
        else if (board[3] == 1 && board[4] == 1 && board[5] == 1)
            true
        else if (board[6] == 1 && board[7] == 1 && board[8] == 1)
            true
        else if (board[0] == 1 && board[4] == 1 && board[8] == 1)
            true
        else if (board[2] == 1 && board[5] == 1 && board[8] == 1)
            true
        else if (board[1]==1&& board [4]==1 &&board[7]==1)
            true
        else board[2] == 1 && board[4] == 1 && board[6] == 1
    }
    private fun checkWinPlayer2() {
        //check for player 2 win
        player2Win = if(board[0]==2&&board[1]==2&&board[2]==2)
            true
        else if (board[3] == 2 && board[4] == 2 && board[5] == 2)
            true
        else if (board[6] == 2 && board[7] == 2 && board[8] == 2)
            true
        else if (board[0] == 2 && board[4] == 2 && board[8] == 2)
            true
        else if (board[2] == 2 && board[5] == 2 && board[8] == 2)
            true
        else if (board[1]==2&& board [4]==2 &&board[7]==2)
            true
        else board[2] == 2 && board[4] == 2 && board[6] == 2
    }
   private fun checkDraw() {
   //check for draw
   if((board[0]==1||board[0]==2)
    &&(board[1]==1||board[1]==2)
    &&(board[2]==1||board[2]==2)
    &&(board[3]==1||board[3]==2)
    &&(board[4]==1||board[4]==2)
    &&(board[5]==1||board[5]==2)
    &&(board[6]==1||board[6]==2)
    &&(board[7]==1||board[7]==2)
    &&(board[8]==1||board[8]==2)
   )
    draw=true
  }
     fun checkGamestate() {
        checkWinPlayer1()
         checkWinPlayer2()
         checkDraw()
     }

    fun reset(){
        for(i in 0..8){
            board[i]=0
        }
        player1Win=false
        player2Win=false
        draw=false
    }
}