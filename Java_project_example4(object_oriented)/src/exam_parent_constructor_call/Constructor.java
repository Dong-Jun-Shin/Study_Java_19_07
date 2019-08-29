﻿package exam_parent_constructor_call;

class SuperX {
	private int x;

	public SuperX(int x) {
		this.x = x;
		System.out.println("x = " + this.x);
	}
}

class SubY extends SuperX {
	private int y;

	public SubY(int x, int y) {
		super(x);
		this.y = y;
		System.out.println("y = " + this.y);
	}
}

public class Constructor {
	public static void main(String[] args) {
		new SubY(100,200);
		
	}
}
