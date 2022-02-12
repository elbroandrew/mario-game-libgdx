package com.mygdx.game.desktop

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.mygdx.game.MyGdxGame


fun main() {
    val config = Lwjgl3ApplicationConfiguration()
    config.setIdleFPS(60)
    config.setTitle("Mario game")
    config.setWindowedMode(1200, 624)
    Lwjgl3Application(MyGdxGame(), config)

}
