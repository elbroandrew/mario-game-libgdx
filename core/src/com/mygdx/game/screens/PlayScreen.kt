package com.mygdx.game.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.maps.MapObject
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TmxMapLoader
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.physics.box2d.*
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

    //tile map
    private var mapLoader: TmxMapLoader = TmxMapLoader()
    private var map: TiledMap = mapLoader.load("level1.tmx")
    private var renderer: OrthogonalTiledMapRenderer = OrthogonalTiledMapRenderer(map)

    //box2d
    private var world:World = World(Vector2(0f, 0f), true)
    private var b2dr:Box2DDebugRenderer = Box2DDebugRenderer()

    //body
    var bDef:BodyDef = BodyDef()
    var shape:PolygonShape = PolygonShape()
    var fdef:FixtureDef = FixtureDef()
    lateinit var body:Body


    init {
        gameCam.position.set(
            (gamePort.worldWidth /2),
            (gamePort.worldHeight /2), 0f
        )

        //create ground bricks/fixtures (that is on a ground layer of the map)
        for (obj:MapObject in map.layers.get(2).objects.getByType(RectangleMapObject::class.java)){
            val rect:Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                rect.getX() + rect.getWidth() / 2,
                rect.getY() + rect.getHeight() / 2
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //create pipes
        for (obj:MapObject in map.layers.get(3).objects.getByType(RectangleMapObject::class.java)){
            val rect:Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                rect.getX() + rect.getWidth() / 2,
                rect.getY() + rect.getHeight() / 2
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //bricks
        for (obj:MapObject in map.layers.get(5).objects.getByType(RectangleMapObject::class.java)){
            val rect:Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                rect.getX() + rect.getWidth() / 2,
                rect.getY() + rect.getHeight() / 2
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //coins (layer 4)
        for (obj:MapObject in map.layers.get(4).objects.getByType(RectangleMapObject::class.java)){
            val rect:Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                rect.getX() + rect.getWidth() / 2,
                rect.getY() + rect.getHeight() / 2
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth()/2, rect.getHeight()/2)
            fdef.shape = shape
            body.createFixture(fdef)

        }
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