package com.mygdx.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer
import com.badlogic.gdx.physics.box2d.World
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.MyGdxGame
import com.mygdx.game.Tools.B2WorldCreator
import com.mygdx.game.scenes.Hud
import com.mygdx.game.sprites.Mario

class PlayScreen(private val game: MyGdxGame) : Screen {

    private var gameCam: OrthographicCamera = OrthographicCamera()
    private var gamePort: Viewport = FitViewport(
        MyGdxGame.V_WIDTH / MyGdxGame.PPM,
        MyGdxGame.V_HEIGHT / MyGdxGame.PPM,
        gameCam
    )
    var hud: Hud = Hud(game.batch)

    //tile map
    private var mapLoader: TmxMapLoader = TmxMapLoader()
    private var map: TiledMap = mapLoader.load("level1.tmx")
    private var renderer: OrthogonalTiledMapRenderer = OrthogonalTiledMapRenderer(map, 1 / MyGdxGame.PPM)

    //box2d
    private var world:World = World(Vector2(0f, -10f ), true)
    private var b2dr:Box2DDebugRenderer = Box2DDebugRenderer()

    private var player: Mario = Mario(world)

    init {
        gameCam.position.set(
            (gamePort.worldWidth / 2),
            (gamePort.worldHeight / 2), 0f
        )

        B2WorldCreator(world, map)
    }



    private fun handleInput(dt: Float) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            player.b2body.applyLinearImpulse(Vector2(0f, 4f), player.b2body.worldCenter, true)
        }
        if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && player.b2body.linearVelocity.x <= 2)
        {
            player.b2body.applyLinearImpulse(Vector2(0.1f, 0f), player.b2body.worldCenter, true)
        }
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && player.b2body.linearVelocity.x >= -2) {
            player.b2body.applyLinearImpulse(Vector2(-0.1f, 0f), player.b2body.worldCenter, true)
        }
    }

    private fun update(dt: Float){
        handleInput(dt)
        world.step(1/60f, 6, 2)
        gameCam.position.x = player.b2body.position.x
        gameCam.update()
        renderer.setView(gameCam)

    }

    override fun show() {

    }

    override fun render(deltaTime: Float) {

        update(deltaTime)

        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        game.time += Gdx.graphics.deltaTime
        game.shader.setUniformf("u_amount", 10.0f)
        game.shader.setUniformf("u_speed", 0.5f)
        game.shader.setUniformf("u_time", game.time)
        game.batch.shader = game.shader

        renderer.render()
        b2dr.render(world,gameCam.combined)

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
        map.dispose()
        renderer.dispose()
        world.dispose()
        b2dr.dispose()
        hud.dispose()
    }
}