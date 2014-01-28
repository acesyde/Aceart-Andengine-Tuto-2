package com.formation.andengine;

import org.anddev.andengine.engine.Engine;
import org.anddev.andengine.engine.camera.Camera;
import org.anddev.andengine.engine.options.EngineOptions;
import org.anddev.andengine.engine.options.EngineOptions.ScreenOrientation;
import org.anddev.andengine.engine.options.resolutionpolicy.RatioResolutionPolicy;
import org.anddev.andengine.entity.primitive.Line;
import org.anddev.andengine.entity.primitive.Rectangle;
import org.anddev.andengine.entity.scene.Scene;
import org.anddev.andengine.entity.sprite.Sprite;
import org.anddev.andengine.opengl.texture.Texture;
import org.anddev.andengine.opengl.texture.TextureOptions;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasFactory;
import org.anddev.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.atlas.buildable.BuildableTextureAtlasTextureRegionFactory;
import org.anddev.andengine.opengl.texture.region.TextureRegion;
import org.anddev.andengine.opengl.texture.region.TextureRegionFactory;
import org.anddev.andengine.ui.activity.BaseGameActivity;

public class MonJeuActivite extends BaseGameActivity {

	private Camera camera;
	private static final int CAMERA_LARGEUR = 480;
	private static final int CAMERA_HAUTEUR = 320;
	private TextureRegion regionImage;
	
	@Override
	public void onLoadComplete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Engine onLoadEngine() {
		camera = new Camera(0, 0, CAMERA_LARGEUR, CAMERA_HAUTEUR);
		return new Engine(new EngineOptions(true, 
				ScreenOrientation.LANDSCAPE, 
				new RatioResolutionPolicy(CAMERA_LARGEUR, CAMERA_HAUTEUR), 
				camera));
	}

	@Override
	public void onLoadResources() {
		
		final BitmapTextureAtlas textureImage = new BitmapTextureAtlas(64, 64,TextureOptions.BILINEAR);
		
		regionImage = BitmapTextureAtlasTextureRegionFactory.createFromAsset(textureImage, this, "gfx/andengine.png",0,0);
		
		this.getEngine().getTextureManager().loadTexture(textureImage);
		
	}

	@Override
	public Scene onLoadScene() {
		final Scene scene = new Scene();
		
		final Rectangle rectangle = new Rectangle(CAMERA_LARGEUR/2, CAMERA_HAUTEUR/2, 100, 50);		
		rectangle.setColor(0.8f, 0.4f, 0.2f);
		
		final Line line = new Line(0, 0, CAMERA_LARGEUR, CAMERA_HAUTEUR);		
		line.setColor(0.5f, 0.5f, 0.5f);
		
		final Sprite sprite = new Sprite(50, 50, regionImage);
		
		scene.getLastChild().attachChild(rectangle);
		scene.getLastChild().attachChild(line);
		scene.getLastChild().attachChild(sprite);
		
		return scene;
	}

}