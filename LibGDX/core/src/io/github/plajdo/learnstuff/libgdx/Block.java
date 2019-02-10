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

class Block{
	
	private ModelInstance instance;
	private Model model;
	
	Block(Vector3 pos) {
		ModelBuilder modelBuilder = new ModelBuilder();
		TextureAttribute textureAttribute = new TextureAttribute(TextureAttribute.Normal, new Texture(Gdx.files.internal("core/assets/badlogic.jpg")));
		
		//TODO: wtf why is the texture white
		model = modelBuilder.createBox(2.0f, 1.0f, 1.0f, new Material(/*ColorAttribute.createDiffuse(Color.GOLD)*/textureAttribute), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal);
		instance = new ModelInstance(model, pos);
		
	}
	
	ModelInstance getModel() {
		return instance;
		
	}
	
	void dispose() {
		model.dispose();
		
	}
	
}
