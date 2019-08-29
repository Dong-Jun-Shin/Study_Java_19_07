﻿package exam_class;

/*
 * 제작사(예를 들어 에어버스), 모델(A380). 최대 승객수(500)를 필드로 가지고 있다.
 * 
 * 1.필드를 정의하라. 모든 핀드는 전용 멤버로 하라.
 * 2.모든 필드에 대한 점근자와 설정자 메소드를 작성한다.
 * 3.Plane 클래스의 생성자를 몇 개를 중복 정의하라.
 *   생성자는 모든 데이터를 받을 수도 있고 아니면 하나도 받지 않을 수 있다.
 * 4.PlaneTest라는 이름의 테스트 클래스를 만드는데 main()에서 
 *   Plane 객체 여러 개를 생성하고 접근자와 설정자를 호출하여 보라.
 * 5.Plane 클래스에 지금까지 생성된 비행기의 개수를 나타내는 정적 변수인 
 *   planes를 추가하고 생성자에서 증가시켜 보자.
 * 6.Plane 클래스에 정적 변수 planes의 값을 반환하는 정적 메소드인 
 *   getPlanes()를 추가하고 main()에서 호출하여 보라.
 * 
 * [실행결과]
 * 항공정보[제작사 : 에어버스, 모델 : A380, 최대 승객수 : 500]
 * 항공정보[제작사 : BOEING, 모델 : B737, 최대 승객수 : 0]
 * 항공정보[제작사 : BOMBARDIER, 모델 : CS300, 최대 승객수 : 150]
 */
public class Plane {
	private String productComp;
	private String model;
	private int personNum;
	private static int planes;

	//생성자 설정
	public Plane() {
		++planes;
	}
	public Plane(String productComp, String model) {
		this(productComp, model, 0);
	}

	public Plane(String productComp, String model, int personNum) {
		this.productComp = productComp;
		this.model = model;
		this.personNum = personNum;
		++planes;
	}

	//getter, setter
	public void setProductComp(String productComp) {
		this.productComp = productComp;
	}

	public String getProductComp() {
		return productComp;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setPersonNum(int personNum) {
		this.personNum = personNum;
	}

	public int getPersonNUm() {
		return personNum;
	}

	public static int getPlanes() {
		return planes;
	}
	//메소드
	public String toString() {
		return String.format("항공정보[제작사 : %s\t, 모델 : %s\t, 최대 승객수 : %3d]", productComp, model, personNum);
	}
}