package io.github.plajdo.learnstuff.libgdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.attributes.TextureAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Vector3;
import com.sun.org.apache.regexp.internal.RE;

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
	
	Block(Vector3 pos) {
		this(pos, Colours.RED);
		
	}
	
	Block(Vector3 pos, Colours blockColour) {
		blockPosition = pos;
		setCubeColour(blockColour);
		replaceInstance();
		
	}
	
	public void setCubeColour(Colours toColour) {
		switch(toColour) {
			case RED:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			case GREEN:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			case BLUE:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.BLUE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			case ORANGE:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.ORANGE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			case YELLOW:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.YELLOW)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			case WHITE:{
				model = modelBuilder.createBox(1.0f, 1.0f, 1.0f, new Material(ColorAttribute.createDiffuse(Color.WHITE)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
				break;
				
			}
			
		}
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
