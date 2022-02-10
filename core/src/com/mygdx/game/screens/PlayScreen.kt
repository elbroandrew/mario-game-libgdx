package com.mygdx.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.utils.viewport.StretchViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.MyGdxGame

class PlayScreen(var game: MyGdxGame) : Screen {
    var texture: Texture = Texture("badlogic.jpg")
    private var gameCam: OrthographicCamera = OrthographicCamera()
    private var gamePort: Viewport = StretchViewport(
        1024f,
        900f,
        gameCam
    )

    override fun show() {

    }

    override fun render(p0: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        game.batch.projectionMatrix = gameCam.combined
        game.batch.begin()
        game.batch.draw(texture, 0f, 0f)
        game.batch.end()


    }

    override fun resize(p0: Int, p1: Int) {
        gamePort.update(p0, p1)

    }

    override fun pause() {
    }

    override fun resume() {
    }

    override fun hide() {
    }

    override fun dispose() {
    }
}