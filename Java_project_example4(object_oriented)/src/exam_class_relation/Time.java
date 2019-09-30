﻿package exam_class_relation;

public class Time {
	private int hour; //0~23
	private int minute; //0~59
	private int second; //0~59

	//첫번째 생성자
	public Time() {
		this(0, 0, 0);
	}

	//두번째 생성자
	public Time(int h, int m, int s) {
		setTime(h, m, s);
	}

	//시간 설정 함수
	public void setTime(int h, int m, int s) {
		hour = ((h >= 0 && h < 24) ? h : 0);	//시간 검증
		minute = ((m >= 0 && m < 60) ? m : 0);	//분 검증
		second = ((s >= 0 && s < 60) ? s : 0);	//초 검증
	}
	
	//"시:분:초"의 형식으로 출력
	public String toString() {

//		형식에서 %:형식지정자, 
//		0:채우고자 하는 문자(0만 가능),
//		2d:자릿수와 형
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}
}