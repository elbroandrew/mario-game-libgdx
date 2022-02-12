package com.mygdx.game.Tools

import com.badlogic.gdx.maps.MapObject
import com.badlogic.gdx.maps.objects.RectangleMapObject
import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.physics.box2d.*
import com.mygdx.game.MyGdxGame

class B2WorldCreator(world:World, map:TiledMap) {

    //body
    private var bDef: BodyDef = BodyDef()
    private var shape: PolygonShape = PolygonShape()
    private var fdef: FixtureDef = FixtureDef()
    private lateinit var body: Body

    init {

        //create ground bricks/fixtures (that is on a ground layer of the map)
        for (obj: MapObject in map.layers.get(2).objects.getByType(RectangleMapObject::class.java)) {
            val rect: Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                (rect.getX() + rect.getWidth() / 2) / MyGdxGame.PPM,
                (rect.getY() + rect.getHeight() / 2) / MyGdxGame.PPM
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth() / 2 / MyGdxGame.PPM, rect.getHeight() / 2 / MyGdxGame.PPM)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //create pipes
        for (obj: MapObject in map.layers.get(3).objects.getByType(RectangleMapObject::class.java)) {
            val rect: Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                (rect.getX() + rect.getWidth() / 2) / MyGdxGame.PPM,
                (rect.getY() + rect.getHeight() / 2) / MyGdxGame.PPM
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth() / 2 / MyGdxGame.PPM, rect.getHeight() / 2 / MyGdxGame.PPM)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //bricks
        for (obj: MapObject in map.layers.get(5).objects.getByType(RectangleMapObject::class.java)) {
            val rect: Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                (rect.getX() + rect.getWidth() / 2) / MyGdxGame.PPM,
                (rect.getY() + rect.getHeight() / 2) / MyGdxGame.PPM
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth() / 2 / MyGdxGame.PPM, rect.getHeight() / 2 / MyGdxGame.PPM)
            fdef.shape = shape
            body.createFixture(fdef)

        }

        //coins (layer 4)
        for (obj: MapObject in map.layers.get(4).objects.getByType(RectangleMapObject::class.java)) {
            val rect: Rectangle = (obj as RectangleMapObject).rectangle

            bDef.type = BodyDef.BodyType.StaticBody
            bDef.position.set(
                (rect.getX() + rect.getWidth() / 2) / MyGdxGame.PPM,
                (rect.getY() + rect.getHeight() / 2) / MyGdxGame.PPM
            )

            body = world.createBody(bDef)
            shape.setAsBox(rect.getWidth() / 2 / MyGdxGame.PPM, rect.getHeight() / 2 / MyGdxGame.PPM)
            fdef.shape = shape
            body.createFixture(fdef)

        }
    }
}
