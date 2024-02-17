package com.kandclay.cbcopy;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

public class MainMenuScreen implements Screen {
    private Game game;
    private SpriteBatch batch;
    private Texture logoTexture;
    private Stage stage;
    private Skin skin; // Ensure you have a skin

    public MainMenuScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        logoTexture = new Texture("badlogic.jpg"); // Make sure you have this asset
        stage = new Stage();
        Gdx.input.setInputProcessor(stage); // Set the stage to process inputs

        skin = new Skin(Gdx.files.internal("lgdxs/skin/lgdxs-ui.json")); // Ensure you have a skin

        TextButton playButton = new TextButton("Play", skin);
        TextButton exitButton = new TextButton("Exit", skin);

        // Position your buttons and add listeners
        playButton.setPosition(100, 150); // Example positions
        exitButton.setPosition(100, 100);

        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(new MainGameScreen(game)); // Switch to main game screen
            }
        });

        exitButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit(); // Exit the game
            }
        });

        stage.addActor(playButton);
        stage.addActor(exitButton);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        batch.draw(logoTexture, Gdx.graphics.getWidth() / 2f - logoTexture.getWidth() / 2f, Gdx.graphics.getHeight() - logoTexture.getHeight() - 50); // Adjust as necessary
        batch.end();

        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        batch.dispose();
        logoTexture.dispose();
        stage.dispose();
    }
}
