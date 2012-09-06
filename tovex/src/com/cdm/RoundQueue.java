package com.cdm;

public class RoundQueue {
	private Position[] ts;
	private int in = 0, out = 0;
	private int size = 0;

	public RoundQueue(int capacity) {
		ts = new Position[capacity];
		for (int i = 0; i < capacity; i++)
			ts[i] = new Position();
	}

	public void add(Position t) {
		if (alreadyIn(t))
			return;

		ts[in].assign(t);
		in++;
		in %= ts.length;
		size++;
	}

	private boolean alreadyIn(Position t) {
		for (int i = out; i != in; i = ((i + 1) % ts.length)) {
			if (ts[i].equals(t))
				return true;
		}
		return false;
	}

	public void cleanup() {
		size = out = in = 0;
	}

	public int capacity() {
		return ts.length;
	}

	public int size() {
		return size;
	}

	public Position first() {
		return ts[out];
	}

	public void removeFirst() {
		if (size > 0) {
			out++;
			out %= ts.length;
			size--;
		}
	}

	public void print() {
		if (true)
			return;
		int i;
		for (i = out; i != in; i = ((i + 1) % ts.length)) {
			System.out.print(ts[i].toString() + " ");
		}
		System.out.println();
	}
}
