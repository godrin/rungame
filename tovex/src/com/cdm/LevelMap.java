package com.cdm;

public class LevelMap {
	public enum FieldType {
		EMPTY, WALL
	};

	public static class Cell {
		FieldType fieldType;
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

	public FieldType get(int x, int y) {
		return cells[x + y * w].fieldType;
	}

	public int width() {
		return w;
	}

	public int height() {
		return h;
	}
}
