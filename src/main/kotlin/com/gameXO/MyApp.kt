package com.gameXO

import javafx.scene.image.Image
import javafx.stage.Stage
import tornadofx.App
import tornadofx.addStageIcon
import java.io.File

class MyApp: App(MyView2::class, Styles::class){
    override fun start(stage: Stage) {
        super.start(stage)
         val pathToIcon=File("src/main/kotlin/com/gameXO/icon.png").toURI().toURL().toExternalForm()
        addStageIcon(Image(pathToIcon))
        stage.width = 255.0
        stage.height = 280.0
        stage.isResizable=false
    }
}