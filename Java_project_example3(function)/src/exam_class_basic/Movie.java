package exam_class_basic;

import java.util.Scanner;

/*
 * 영화 Movie 클래스를 정의한다.
 * Movie 클래스는 영화제목(movieTitle), 평점(movieGrade), 감독(movieDirector),
 * 발표연도(announcementYear) 필드를 가진다. 영화의 모든 정보를 출력한다.
 * 
 * [요구사항]
 * 1. 2개의 영화 정보를 필드에 직접 대입하여 필드값을 출력한다.
 * 2. 1개의 영화 정보는 사용자로 하여금 영화 정보를 입력받아서 출력한다.
 */
public class Movie {
	public String movieTitle;
	public double movieGrade;
	public String movieDirector;
	public int announcementYear;

	public void set1() {
		movieTitle = "분노의 질주: 홉스&쇼";
		movieGrade = 9.11;
		movieDirector = "데이빗 레이치";
		announcementYear = 2019;
	}

	public void set2() {
		movieTitle = "봉오동 전투";
		movieGrade = 9.20;
		movieDirector = "원신연";
		announcementYear = 2019;
	}

	public void setData(String title, double grade, String director, int year) {
		movieTitle = title;
		movieGrade = grade;
		movieDirector = director;
		announcementYear = year;
	}
	
	public void setUserData() {
		Scanner scan = new Scanner(System.in);
	
		System.out.print("영화 제목 : ");
		movieTitle = scan.nextLine();
		
		System.out.print("영화 평점 : ");
		movieGrade = scan.nextDouble();
		scan.nextLine();
		
		System.out.print("영화 감독 : ");
		movieDirector = scan.nextLine();
		
		System.out.print("발표 연도 : ");
		announcementYear = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
		
		scan.close();
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < (int)movieGrade / 2; i++) {
			temp += "★";
			if (i == (int)movieGrade / 2 - 1) {
				for (int j = 0; j < 5 - (int)movieGrade / 2; j++) {
					temp += "☆";
				}
			}
		}

		return String.format("%-10s\t %s %.2f %-8s\t %d", movieTitle, temp, movieGrade, movieDirector, announcementYear);
	}
}
