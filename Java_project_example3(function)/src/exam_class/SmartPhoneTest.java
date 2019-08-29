﻿package exam_class;

public class SmartPhoneTest {
	public static void main(String[] args) {
		//생성자 (매개변수 4개)
		
		SmartPhone phone1 = new SmartPhone("삼성", "갤럭시노트9", 1094500);
		System.out.println("============제품목록===========");
		System.out.println("----------------------------");
		phone1.show();
		
		//생성자 (매개변수 3개)
		SmartPhone phone2 = new SmartPhone("애플", "아이폰XS", 1364000, 10);
		phone2.show();
		
		//getter, setter
		SmartPhone phone3 = new SmartPhone();
		phone3.setMaker("삼성");
		String maker = phone3.getMaker();

		phone3.setNmae("갤럭시S8");
		String name = phone3.getName();
		
		phone3.setPrice(935000);
		int price = phone3.getPrice();
		
		phone3.setDiscountRate(35);
		int discountRate = phone3.getDiscountRate();		
		
		int tempNum = (int)((double)price/100 * (100-discountRate))/10*10;
		System.out.printf("%s [%s]\n", name, maker);
		System.out.printf("가격 : %d\n", price);
		if(discountRate != 0) {
			System.out.printf("할인가격(%d%%) : %d\n", discountRate, tempNum);			
		}
		System.out.println("----------------------------");		
	}
}
