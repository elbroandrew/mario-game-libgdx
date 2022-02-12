package com.mygdx.game.sprites

import com.badlogic.gdx.maps.tiled.TiledMap
import com.badlogic.gdx.maps.tiled.TiledMapTile
import com.badlogic.gdx.math.Rectangle
import com.badlogic.gdx.physics.box2d.Body
import com.badlogic.gdx.physics.box2d.World

open class InteractiveTileObject (private var world:World,
                                  private var map:TiledMap,
                                  private var bounds:Rectangle
) {

    protected lateinit var tile:TiledMapTile
    protected lateinit var body:Body

}