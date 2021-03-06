﻿package exam_class_relation;

class Dvd {
	private String title;
	private int price;

	public Dvd() {

	}

	public Dvd(String title, int price) {
		this.title = title;
		this.price = price;
	}

	protected final String getTitle() {
		return title;
	}

	protected final void setTitle(String title) {
		this.title = title;
	}

	protected final int getPrice() {
		return price;
	}

	protected final void setPrice(int price) {
		this.price = price;
	}
}

class DvdShop {
	private Dvd[] dvdList;

	public DvdShop(Dvd[] d) {
		dvdList = d;
	}

	public void printDvdList() {
		System.out.println("=========== DVD 목록 ===========");
		for (int i = 0; i < dvdList.length; i++) {
			System.out.printf("%-6s\t%5d\n", dvdList[i].getTitle(), dvdList[i].getPrice());
		}
	}

	public void printTotalPrice() {
		System.out.println("==============================");
		int sum = 0;
		for (int i = 0; i < dvdList.length; i++) {
			sum += dvdList[i].getPrice();
		}
		System.out.println(sum);
	}
}

public class DvdShopTest {
	public static void main(String[] args) {
		Dvd[] d = new Dvd[26];
		for (int i = 0; i < d.length; i++) {
			d[i] = new Dvd("title " + Character.toString((char) (65 + i)), 1000 * (i+1));
		}
		
		DvdShop dl = new DvdShop(d);
		dl.printDvdList();
		dl.printTotalPrice();
	}
}
