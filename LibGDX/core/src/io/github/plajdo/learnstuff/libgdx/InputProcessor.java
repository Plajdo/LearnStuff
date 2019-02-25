package io.github.plajdo.learnstuff.libgdx;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector3;

public class InputProcessor implements com.badlogic.gdx.InputProcessor{
	@Override
	public boolean keyDown(int keycode){
		return false;
	}
	
	@Override
	public boolean keyUp(int keycode){
		return false;
	}
	
	@Override
	public boolean keyTyped(char character){
		return false;
	}
	
	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button){
		if(button == Input.Buttons.LEFT) {
			Vector3 unprojectedVector = MyGdxGame.camera.unproject(new Vector3(screenX, screenY, 0));
			System.out.println(unprojectedVector);
			
		}
		return false;
	}
	
	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button){
		return false;
	}
	
	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer){
		return false;
	}
	
	@Override
	public boolean mouseMoved(int screenX, int screenY){
		return false;
	}
	
	@Override
	public boolean scrolled(int amount){
		return false;
	}
}
