package com.mygdx.game.sprites

import com.badlogic.gdx.graphics.g2d.Sprite
import com.badlogic.gdx.physics.box2d.*
import com.mygdx.game.MyGdxGame

class Mario (private val world:World) : Sprite() {
    lateinit var b2body: Body

    private fun defineMario(){
        val bdef = BodyDef()
        bdef.position.set(32f / MyGdxGame.PPM, 32f / MyGdxGame.PPM)
        bdef.type = BodyDef.BodyType.DynamicBody
        b2body = world.createBody(bdef)

        val fdef  = FixtureDef()
        val shape = CircleShape()
        shape.radius = 5f / MyGdxGame.PPM

        fdef.shape = shape
        b2body.createFixture(fdef)

    }

    init {
        defineMario()
    }


}