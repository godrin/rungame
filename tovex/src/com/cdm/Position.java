package com.cdm;

public class Position {
	public static final float MIN_DISTANCE = 0.001f;
	float x;
	float y;

	public Position() {
		x = y = -1;
	}

	public Position(float px, float py) {
		x = px;
		y = py;
	}

	public Position(Position p) {
		x = p.x;
		y = p.y;
	}

	public float distance2To(Position nextPosition) {
		float dx = x - nextPosition.x;
		float dy = y - nextPosition.y;
		return dx * dx + dy * dy;
	}

	public void set(float pX, float pY) {
		x = pX;
		y = pY;

	}

	public String toString() {
		return "[" + x + ";" + y + "]";
	}

	public void getNeighbors(Position[] neighbors) {
		neighbors[0].set(x - 1, y);
		neighbors[1].set(x, y - 1);
		neighbors[2].set(x + 1, y);
		neighbors[3].set(x, y + 1);
	}

	public void assign(Position t) {
		x = t.x;
		y = t.y;

	}

	public void alignToGrid() {
		x = Math.round(x);
		y = Math.round(y);
	}

}
