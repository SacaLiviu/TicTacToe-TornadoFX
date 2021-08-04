package com.gameXO

import javafx.geometry.Pos
import tornadofx.*
import tornadofx.Stylesheet.Companion.title

class MyView2: View("TicTacToe") {
    private val controller:Controller by inject()
    override val root = borderpane{
        top=vbox(alignment = Pos.BASELINE_CENTER) {
            label(" ")
            label(" ")
            label(" ")
            label(controller.winner)
        }
        center=button("Start Game") {
            action {
                replaceWith(MainView::class, ViewTransition.Fade(0.5.seconds))
            }
        }
    }
}