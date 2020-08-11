package com.mycompany.imagej;

public class DataPoint {
	private int posX;
	private int posY;
	
	DataPoint(int x, int y) {
		setPosX(x);
		setPosY(y);
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}	
}