package com.mygdx.game.sprites

import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TiledMapTile
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.physics.box2d.*
import com.mygdx.game.MyGdxGame

open class InteractiveTileObject (private var world:World,
                                  private var map:TiledMap,
                                  private var bounds:Rectangle
) {

    private lateinit var tile:TiledMapTile
    private var body:Body
    var bDef:BodyDef = BodyDef()
    var fdef = FixtureDef()
    var shape = PolygonShape()

    init {
        bDef.type = BodyDef.BodyType.StaticBody
        bDef.position.set(
            (bounds.getX() + bounds.getWidth() / 2) / MyGdxGame.PPM,
            (bounds.getY() + bounds.getHeight() / 2) / MyGdxGame.PPM
        )

        body = world.createBody(bDef)
        shape.setAsBox(bounds.getWidth() / 2 / MyGdxGame.PPM, bounds.getHeight() / 2 / MyGdxGame.PPM)
        fdef.shape = shape
        body.createFixture(fdef)
    }

}