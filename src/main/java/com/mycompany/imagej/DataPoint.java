package com.mycompany.imagej;

import ij.IJ;

public class DataPoint {
	private final int WHITE = 255; 
	private final int BLACK = 0;
	
	private int posX;
	private int posY;
	private int[] color = new int[3];
	
	DataPoint(int x, int y) {
		setPosX(x);
		setPosY(y);
		generateColor();
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
	
	public int[] getColor() {
		return color;
	}
	
	private void generateColor() {
		for(int i = 0; i < color.length; i++) {
			int c = (int)(Math.random() * (WHITE - BLACK + 1) + BLACK);
			IJ.log("Color " + i + " for point (" + posX + ", " + posY + "): " + c);
			color[i] = c;
		}
	}
	
	public double calculateDistance(int x, int y) {
		double dx = Math.abs(x - posX);
		double dy = Math.abs(y - posY);
		
		return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
	}
}