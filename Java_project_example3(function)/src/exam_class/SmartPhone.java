﻿package exam_class;

public class SmartPhone {
	private String maker;
	private String name;
	private int price;
	private int discountRate;

	//생성자
	public SmartPhone() {

	}

	public SmartPhone(String maker, String name, int price) {
		this(maker, name, price, 0);
	}

	public SmartPhone(String maker, String name, int price, int discountRate) {
		this.maker = maker;
		this.name = name;
		this.price = price;
		this.discountRate = discountRate;
	}

	//getter, setter
	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getName() {
		return name;
	}

	public void setNmae(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscountRate() {
		return discountRate;
	}

	public void setDiscountRate(int discountRate) {
		this.discountRate = discountRate;
	}

	public void show() {
		//					정확한 계산을 위해 실수,        할인된 후 금액율,    십자리 미만 내림
		int tempNum = (int) ((double) price / 100 * (100 - discountRate));

		System.out.println(name + " [" + maker + "]");
		System.out.printf("%s [%s]\n", name, maker);
		System.out.printf("가격 : %d\n", price);
		
		if (discountRate != 0) {
			System.out.printf("할인가격(%d%%) : %d\n", discountRate, tempNum);
		}
		System.out.println("----------------------------");
	}
}
