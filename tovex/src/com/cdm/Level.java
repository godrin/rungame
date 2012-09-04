package com.cdm;

import java.util.ArrayList;
import java.util.List;

public class Level extends LevelMap {
	private List<Entity> entities = new ArrayList<Entity>();

	public Level(int pw, int ph) {
		super(pw, ph);
	}

	public void add(Entity player) {
		entities.add(player);
	}

	public List<Entity> getEntities() {
		return entities;
	}

}
