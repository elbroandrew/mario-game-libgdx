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

    private var mapLoader: TmxMapLoader = TmxMapLoader()
    private var map: TiledMap = mapLoader.load("level1.tmx")
    private var renderer: OrthogonalTiledMapRenderer = OrthogonalTiledMapRenderer(map)

    init {
        gameCam.position.set(
            (gamePort.worldWidth /2),
            (gamePort.worldHeight /2), 0f
        )

    }

    fun handleInput(dt: Float) {
        if (Gdx.input.isTouched){
            gameCam.position.x += 50f * dt
        }

    }

    fun update(dt: Float){
        handleInput(dt)
        gameCam.update()
        renderer.setView(gameCam)

    }

    override fun show() {

    }

    override fun render(deltaTime: Float) {

        update(deltaTime)

        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        renderer.render()

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