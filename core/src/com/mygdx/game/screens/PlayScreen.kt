package com.mygdx.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.MyGdxGame
import com.mygdx.game.scenes.Hud

class PlayScreen(var game: MyGdxGame) : Screen {
    private var gameCam: OrthographicCamera = OrthographicCamera()
    private var gamePort: Viewport = FitViewport(
        MyGdxGame.V_WIDTH,
        MyGdxGame.V_HEIGHT,
        gameCam
    )
    var hud: Hud = Hud(game.batch)

    private lateinit var mapLoader: TmxMapLoader
    private lateinit var map: TiledMap
    private lateinit var renderer: OrthogonalTiledMapRenderer

    override fun show() {

    }

    override fun render(p0: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        game.batch.projectionMatrix = hud.stage.camera.combined
        hud.stage.draw()

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