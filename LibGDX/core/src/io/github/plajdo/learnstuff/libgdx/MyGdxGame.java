package io.github.plajdo.learnstuff.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class MyGdxGame extends ApplicationAdapter {
	
	Camera camera;
	Model model;
	ModelInstance instance;
	ModelBatch modelBatch;
	
	@Override
	public void create () {
		modelBatch = new ModelBatch();
		
		camera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(10, 10, 10);
		camera.lookAt(0, 0, 0);
		camera.near = 1.0f;
		camera.far = 300.0f;
		camera.update();
		
		ModelBuilder modelBuilder = new ModelBuilder();
		model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.GOLD)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		instance = new ModelInstance(model);
		
	}

	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		modelBatch.begin(camera);
		modelBatch.render(instance);
		modelBatch.end();
		
	}
	
	@Override
	public void dispose () {
		modelBatch.dispose();
		model.dispose();
		
	}
	
}
