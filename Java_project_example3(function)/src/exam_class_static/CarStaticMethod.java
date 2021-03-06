﻿package exam_class_static;

public class CarStaticMethod {
	private int speed;
	private int gear;
	private String color;
	private static int numberOfCars;
	
	public CarStaticMethod(int s, int g, String c) {
		speed = s;
		gear = g;
		color = c;
		++numberOfCars;
	}
	
	public static int getNumberOfCars() {
		return numberOfCars;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	public int getGear() {
		return gear;
	}
	
	public void setGear(int gear) {
		this.gear = gear;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String toString() {
		return "자동차 정보 : " + numberOfCars + " 속도: " + speed + " 기어: " + gear + " 색상: " + color;
	}
	
}
