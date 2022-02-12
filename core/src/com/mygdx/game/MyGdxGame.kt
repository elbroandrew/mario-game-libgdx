package com.mygdx.game

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.mygdx.game.screens.PlayScreen

class MyGdxGame : Game() {

    companion object{
        val V_WIDTH = 400f
        val V_HEIGHT = 208f
        val PPM = 100f
    }

    lateinit var  batch: SpriteBatch

    override fun create() {
        batch = SpriteBatch()
        setScreen(PlayScreen(this))
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        batch.dispose()
    }
}