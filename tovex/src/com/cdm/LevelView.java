package com.cdm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class LevelView {
	private LevelMap level;
	private Texture texture;
	private Sprite sprite;
	private SpriteBatch batch;
	private TextureRegion freeRegion;
	private TextureRegion blockedRegion;
	private TextureRegion enemyRegion;
	private TextureRegion playerRegion;

	public LevelView(LevelMap l) {
		level = l;

		texture = new Texture(Gdx.files.internal("data/tiles.png"));
		texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		batch = new SpriteBatch();

		freeRegion = new TextureRegion(texture, 0, 0, 32, 32);
		blockedRegion = new TextureRegion(texture, 32, 0, 32, 32);
		playerRegion = new TextureRegion(texture, 64, 0, 32, 32);
		enemyRegion = new TextureRegion(texture, 96, 0, 32, 32);

		sprite = new Sprite(freeRegion);
		sprite.setSize(1.0f/16,1.0f/16);
		sprite.setOrigin(0,0); // 1.0f/8,1.0f/8);
		sprite.setPosition(0,0); //-sprite.getWidth() / 2, -sprite.getHeight() / 2);
		

	}

	public void draw(OrthographicCamera camera) {
		batch.setProjectionMatrix(camera.combined);
		//batch.
		batch.begin();
		//sprite.draw(batch);
		for(int x=0;x<level.width();x++)
			for(int y=0;y<level.height();y++) {
				TextureRegion r;
				if(level.get(x,y)==LevelMap.FieldType.EMPTY)
					r=freeRegion;
				else
					r=blockedRegion;
				batch.draw(r, x,y,1,1);
			}
		
		batch.end();
	}
}
