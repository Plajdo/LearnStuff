package io.github.plajdo.learnstuff.libgdx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;

class Block{
	
	private ModelBuilder modelBuilder = new ModelBuilder();
	private ModelInstance instance;
	private Model model;
	private Vector3 blockPosition;
	
	public enum Colours {
		RED,
		GREEN,
		BLUE,
		ORANGE,
		YELLOW,
		WHITE;
		
		public static Colours getRandomColour() {
			int randomNumber = RandomContainer.RANDOM.nextInt(6);
			
			switch(randomNumber) {
				case 0:{
					return RED;
					
				}
				case 1:{
					return GREEN;
					
				}
				case 2:{
					return BLUE;
					
				}
				case 3:{
					return ORANGE;
					
				}
				case 4:{
					return YELLOW;
					
				}
				case 5:{
					return WHITE;
					
				}
				default:{
					return RED;
					
				}
				
			}
			
		}
		
	}
	
	Block(Vector3 pos, Colours... blockColours) {
		blockPosition = pos;
		
		setCubeColour(blockColours);
		replaceInstance();
		
	}
	
	public void setCubeColour(Colours... toColours) {
		model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.WHITE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		
		
		replaceInstance();
		
	}
	
	public void replaceInstance(){
		instance = new ModelInstance(model, blockPosition);
		
	}
	
	ModelInstance getModel() {
		return instance;
		
	}
	
	void dispose() {
		model.dispose();
		
	}
	
}
