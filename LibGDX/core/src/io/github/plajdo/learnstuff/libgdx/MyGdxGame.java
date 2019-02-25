package io.github.plajdo.learnstuff.libgdx;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.CameraInputController;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class MyGdxGame extends ApplicationAdapter {
	
	CameraInputController inputController;
	Environment environment;
	DirectionalLight light;
	static Camera camera;
	ModelBatch modelBatch;
	
	ArrayList<Block> blockStorage = new ArrayList<Block>();
	
	@Override
	public void create () {
		modelBatch = new ModelBatch();
		
		camera = new PerspectiveCamera(70, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.position.set(4, 4, 4);
		camera.lookAt(0, 0, 0);
		camera.near = 0.1f;
		camera.far = 50.0f;
		camera.update();
		
		//Move the light up a bit
		light = new DirectionalLight().set(1.0f, 1.0f, 1.0f, camera.direction.x, camera.direction.y - 1.0f, camera.direction.z);
		
		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1.0f));
		environment.add(light);
		
		for(int i = -1; i <= 1; i++){
			for(int j = -1; j <= 1; j++){
				for(int k = -1; k <= 1; k++){
					blockStorage.add(new Block(new Vector3(i, k, j), Block.Colours.getRandomColour()));
					
				}
				
			}
			
		}
		
		//TODO: input controller?
		inputController = new CameraInputController(camera);
		Gdx.input.setInputProcessor(inputController);
		
	}

	@Override
	public void render () {
		inputController.update();
		
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
		
		//Move the light up a bit
		light.setDirection(camera.direction.x, camera.direction.y - 1.0f, camera.direction.z);
		
		modelBatch.begin(camera);
		for(int i = 0; i < blockStorage.size(); i++){
			Block block = blockStorage.get(i);
			modelBatch.render(block.getModel(), environment);
			
		}
		modelBatch.end();
		
	}
	
	@Override
	public void dispose () {
		modelBatch.dispose();
		for(int i = 0; i < blockStorage.size(); i++){
			Block block = blockStorage.get(i);
			block.dispose();
			
		}
		
	}
	
}
