package com.mygdx.game.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.*

class Mario (private val world:World) : Sprite() {
    private lateinit var b2body: Body

    private fun defineMario(){
        val bdef = BodyDef()
        bdef.position.set(32f, 32f)
        bdef.type = BodyDef.BodyType.DynamicBody
        b2body = world.createBody(bdef)

        val fdef  = FixtureDef()
        val shape = CircleShape()
        shape.radius = 5f

        fdef.shape = shape
        b2body.createFixture(fdef)

    }

    init {
        defineMario()
    }


}