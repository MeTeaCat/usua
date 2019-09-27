package io;

import java.io.Serializable;

public class Hero implements Serializable {

	private static final long serialVersionUID = 1L;
	public String name;
	public float hp;
	public Hero() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Hero(String name) {
		super();
		this.name = name;
	}
}
