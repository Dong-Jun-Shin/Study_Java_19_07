﻿package exam_class;

/*
 * 사번과 기본급을 입력해서, 수당, 세금, 본봉, 등급을 구하는 사원 테이블을 
 * 작성하여 다음과 같이 조건에 맞게 결과를 출력하려고 한다.
 * main() 메소드를 실행하여 다음의 결과를 얻을 수 있도록 구현하시오.
 * 
 * [조건]
 * 1.수당은 기본급의 15%
 * 2.세금은 기본급의 20%
 * 3.본봉은 기본급 + 수당 - 세금
 * 4.등급은 본봉이 500000 이상이면 관리, 나머지는 영업으로 계산한다.
 * 5.각 멤버 변수명은 사번(empno), 기본급(gi), 수당(su), 세금(se), 본봉(bong), 등급(grad)으로 지정한다.
 */
public class EmpMain {
	private String empno;
	private int gi;
	private double su, se, bong;
	private String grad;

	//생성자
	public EmpMain() {

	}

	public EmpMain(String empno, int gi) {
		this.empno = empno;
		this.gi = gi;
	}

	//getter, setter
	public String getEmpno() {
		return empno;
	}

	public void setEmpno(String empno) {
		this.empno = empno;
	}

	public int getGi() {
		return gi;
	}

	public void setGi(int gi) {
		this.gi = gi;
	}

	public double getSu() {
		su = gi * 0.15;
		return su;
	}

	public void setSu(double su) {
		this.su = su;
	}

	public double getSe() {
		se = gi * 0.2;
		return se;
	}

	public void setSe(double se) {
		this.se = se;
	}

	public double getBong() {
		bong = gi + su - se;
		return bong;
	}

	public void setBong(double bong) {
		this.bong = bong;
	}

	public String getGrad() {
		if (bong >= 500000) {
			grad = "관리자";
		} else {
			grad = "영업";
		}
		return grad;
	}

	public void setGrad(String grad) {
		this.grad = grad;
	}

	//메소드
	public String toString() {
		return String.format("%4s   |   %8d   |   %8d   |   %8d   |   %8d   |   %4s   ", empno, gi, (int)getSu(), (int)getSe(), (int)getBong(), getGrad());
	}

	public static void showFrame() {
		System.out.println("\t\t\t\t            봉급계산서");
		System.out.println("=================================================================================");
		System.out.println("사번\t           기본급\t             수당\t           세금\t                         본봉\t                    등급");
		System.out.println("=================================================================================");
	}
}
