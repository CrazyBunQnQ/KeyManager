package com.crazybunqnq.entity;

import java.awt.Color;
import java.awt.Font;

public class ImgStringSetting {
	private Font f;
	private int x;
	private int y;
	private Color color;

	public ImgStringSetting(Font f, int x, int y) {
		this.f = f;
		this.x = x;
		this.y = y;
		this.color = Color.BLACK;
	}

	public ImgStringSetting(Font f, int x, int y, Color color) {
		this.f = f;
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public Font getF() {
		return f;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Color getColor() {
		return color;
	}
}
