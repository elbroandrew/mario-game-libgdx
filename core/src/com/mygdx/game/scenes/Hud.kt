package com.mygdx.game.scenes

import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Label
import com.badlogic.gdx.scenes.scene2d.ui.Table
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.mygdx.game.MyGdxGame

class Hud(sb: SpriteBatch) {

    private var viewport: Viewport = FitViewport(
        MyGdxGame.V_WIDTH,
        MyGdxGame.V_HEIGHT,
        OrthographicCamera()
    )
    var stage: Stage = Stage(viewport, sb)

    private var worldTimer: Int = 300
    private var score: Int = 0
    private var timeCount: Float = 0f

    var countdownLabel: Label = Label(
        String.format("%03d", worldTimer),
        Label.LabelStyle(BitmapFont(), Color.WHITE)
    )
    var scoreLabel: Label = Label(
    String.format("%06d", score),
    Label.LabelStyle(BitmapFont(), Color.WHITE)
    )

    var timeLabel: Label = Label(
        "TIME",
        Label.LabelStyle(BitmapFont(), Color.WHITE)
    )
    var levelLabel: Label= Label(
        "1-1",
        Label.LabelStyle(BitmapFont(), Color.WHITE)
    )
    var worldLabel: Label = Label(
        "WORLD",
        Label.LabelStyle(BitmapFont(), Color.WHITE)
    )
    var marioLabel: Label = Label(
        "MARIO",
        Label.LabelStyle(BitmapFont(), Color.WHITE)
    )

    var table: Table = Table()
    init {
        table.top()
        table.setFillParent(true)
        table.add(marioLabel).expandX().padTop(10f)
        table.add(worldLabel).expandX().padTop(10f)
        table.add(timeLabel).expandX().padTop(10f)
        table.row()
        table.add(scoreLabel).expandX()
        table.add(levelLabel).expandX()
        table.add(countdownLabel).expandX()

        stage.addActor(table)
    }




}