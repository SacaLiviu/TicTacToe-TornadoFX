package com.gameXO

import javafx.scene.control.Button
import javafx.scene.paint.Color
import tornadofx.*
import java.io.File

class MainView : View("Player 1 turn") {
    private val controller:Controller by inject()
    private val button: Array<Button?> = arrayOfNulls(9)
    private val size=237/3.00
    private var player=1
    private val pathO=File("src/main/kotlin/com/gameXO/O.png").toURI().toURL().toExternalForm()
    private val pathX=File("src/main/kotlin/com/gameXO/X.png").toURI().toURL().toExternalForm()
    private val pathClearTile=File("src/main/kotlin/com/gameXO/ClearTile.png").toURI().toURL().toExternalForm()

    override val root = hbox {
        flowpane {
            for(i in 0 until 9) {
                button[i]=button {
                    this.imageview(pathClearTile)
                    style{
                        focusColor= Color.TRANSPARENT
                        focusTraversable=false
                    }
                    minWidth = size
                    minHeight = size
                    //gameloop
                    action{
                        player = if(player==1){
                            this@MainView.title="Player 2 turn"
                            this.imageview(pathX)
                            this.disableProperty().set(true)
                            this.opacity=1.0
                            controller.board[indexInParent]=1

                            2
                        } else{
                            this@MainView.title="Player 1 turn"
                            //this.imageview(Image("file:O.png"))
                            this.imageview(pathO)
                            this.disableProperty().set(true)
                            this.opacity=1.0
                            controller.board[indexInParent]=2
                            1
                        }
                        //check if either player has won and reset the game
                        controller.checkGamestate()
                        if(controller.player1Win) {
                            controller.winner.set("Player 1 wins! (X)")
                            replaceWith(MyView2::class, ViewTransition.Fade(0.3.seconds))
                            resetButtons()
                            player=1
                            controller.reset()
                            this@MainView.title="Player 1 turn"
                        }
                        if(controller.player2Win) {
                            controller.winner.set("Player 2 wins! (O)")
                            replaceWith(MyView2::class, ViewTransition.Fade(0.3.seconds))
                            resetButtons()
                            controller.reset()
                            this@MainView.title="Player 1 turn"
                        }
                        if(controller.draw) {
                            controller.winner.set("DRAW! No winners!")
                            replaceWith(MyView2::class, ViewTransition.Fade(0.3.seconds))
                            resetButtons()
                            controller.reset()
                            this@MainView.title="Player 1 turn"
                        }
                    }
                }
            }
        }
    }
    private fun resetButtons(){
        for(i in 0 until 9){
            button[i]?.disableProperty()?.set(false)
            button[i]?.imageview(pathClearTile)
            button[i]?.opacity=1.0
        }
    }
}



