﻿package exam_class_extends;

public class CarExtend {
	public int speed;
	public int gear;
	private String color;
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public void speedUp(int increment) {
		speed += increment;
	}
	
	public void speedDown(int increment) {
		speed -= increment;
	}

	//final 메소드
	public final void stop() {
		System.out.println("차를 멈춤");
		speed = 0;
	}
	
	@Override
	public String toString() {
		return "CarExtend [speed=" + speed + ", gear=" + gear + ", color=" + color + "]";
	}
}

class SportsCar extends CarExtend{
	public boolean turbo;

	public void setTurbo(boolean turbo) {
		this.turbo = turbo;
	}

//	종단메소드를 재정의 할 수 없다.
//	public void stop() {
//		System.out.println("나는 종단메소드를 재정의하겠다!!");
//	}
	
	@Override
	public String toString() {
		return "SportsCar [turbo=" + turbo + ", speed=" + speed + ", gear=" + gear + ", getColor()=" + getColor() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
}
