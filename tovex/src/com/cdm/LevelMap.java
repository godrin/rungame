package com.cdm;

public class LevelMap {
	public enum FieldType {
		EMPTY, WALL;

		public boolean isPassable() {
			return EMPTY.equals(this);
		}
	};

	public static class Cell {
		FieldType fieldType;
		float distanceToPlayer;
		public float distanceToSinglePlayer;
	}

	private Cell[] cells;
	private int w, h;

	public LevelMap(int pw, int ph) {
		w = pw;
		h = ph;
		cells = new Cell[w * h];
		for (int x = 0; x < w; x++)
			for (int y = 0; y < h; y++)
				cells[x + y * w] = new Cell();
	}

	public void set(int x, int y, FieldType t) {
		cells[x + y * w].fieldType = t;
	}

	public Cell getCell(int x, int y) {
		if (x >= 0 && y >= 0 && x < w && y < h)
			return cells[x + y * w];
		return null;
	}

	public FieldType get(int x, int y) {
		return getCell(x, y).fieldType;
	}

	public int width() {
		return w;
	}

	public int height() {
		return h;
	}

	public boolean posValid(Position p) {
		return p.x >= 0 && p.x < w && p.y >= 0 && p.y < h;
	}
}
