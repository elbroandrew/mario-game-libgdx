package com.mygdx.game

import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShaderProgram
import com.mygdx.game.screens.PlayScreen


class MyGdxGame : Game() {

    companion object{
        val V_WIDTH = 400f
        val V_HEIGHT = 208f
        val PPM = 100f
    }

    lateinit var  batch: SpriteBatch
    lateinit var shader: ShaderProgram
    var time: Float = 0.0f

    override fun create() {
        batch = SpriteBatch()
        shader = ShaderProgram(batch.shader.vertexShaderSource, Gdx.files.internal("glitch.frag").readString())
        if(!shader.isCompiled){
            println(shader.log)
        }
        setScreen(PlayScreen(this))
    }

    override fun render() {
        super.render()
    }

    override fun dispose() {
        batch.dispose()
        shader.dispose()
    }
}