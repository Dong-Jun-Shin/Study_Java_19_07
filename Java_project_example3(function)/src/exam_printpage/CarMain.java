﻿package exam_printpage;

class Car{
	private String color;
	private int account;
	
	public Car() {
		
	}
	
	public Car(String color, int account) {
		this.color = color;
		this.account = account;
	}

	public String getColor() {
		return color;
	}

	public int getAccount() {
		return account;
	}

	@Override
	public String toString() {
		return "[색상] " + color + "\t[생산수량] " + account + "\t";
	}
}

class Monata extends Car{
	private String series;
	private String use;
	
	public Monata() {
		
	}
	
	public Monata(String color, int account, String series, String use) {
		super(color, account);
		this.series = series;
		this.use = use;
	}

	@Override
	public String toString() {
		String sData = "[용도] "+ use + "\t[시리즈] " + series;
		return super.toString() + sData;
	}
}

public class CarMain {
	public static void main(String[] args) {
		Monata[] monata = new Monata[4];
		monata[0] = new Monata("흰색", 5000, "NF", "승용");
		monata[1] = new Monata("은색", 7000, "Brilliant", "업무");
		monata[2] = new Monata("감홍색", 4000, "EF", "택시");
		monata[3] = new Monata("검정색", 6000, "Hybrid", "승용");
		
		
		System.out.println("========================== Monata 생산 시작 ============================");
		for (int i = 0; i < monata.length; i++) {
			System.out.println(monata[i].toString());
		}
	}
}
