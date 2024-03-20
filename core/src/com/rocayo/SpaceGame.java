package com.rocayo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class SpaceGame extends ApplicationAdapter {
	ShapeRenderer batch;
	OrthographicCamera camera;

	//Like the Start method in Unity
	@Override
	public void create() {
		batch = new ShapeRenderer();
		batch.setAutoShapeType(true);

		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	//Like the Update method in Unity
	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);

		batch.begin();

		batch.setColor(1, 0, 0, 1);
		batch.rect(100, 100, 100, 100);

		batch.end();
	}

	//On window resize event
	@Override
	public void resize(int width, int height) {
		// Update the camera's viewport size without changing its position
		camera.viewportWidth = width;
		camera.viewportHeight = height;
		camera.update();
	}

	//Like the OnDestroy method in Unity, is for cleaning memory and resources when the game is closed
	@Override
	public void dispose () {
		batch.dispose();
	}
}