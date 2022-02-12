package com.mygdx.game.sprites

import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.physics.box2d.BodyDef
import com.badlogic.gdx.physics.box2d.FixtureDef
import com.badlogic.gdx.physics.box2d.PolygonShape
import com.badlogic.gdx.physics.box2d.World
import com.mygdx.game.MyGdxGame

class Coin(world: World, map: TiledMap, bounds: Rectangle) : InteractiveTileObject(world, map, bounds) {

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