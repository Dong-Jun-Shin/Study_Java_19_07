package exam_class_basic;

import java.util.Scanner;

/*
 * ��ȭ Movie Ŭ������ �����Ѵ�.
 * Movie Ŭ������ ��ȭ����(movieTitle), ����(movieGrade), ����(movieDirector),
 * ��ǥ����(announcementYear) �ʵ带 ������. ��ȭ�� ��� ������ ����Ѵ�.
 * 
 * [�䱸����]
 * 1. 2���� ��ȭ ������ �ʵ忡 ���� �����Ͽ� �ʵ尪�� ����Ѵ�.
 * 2. 1���� ��ȭ ������ ����ڷ� �Ͽ��� ��ȭ ������ �Է¹޾Ƽ� ����Ѵ�.
 */
public class Movie {
	public String movieTitle;
	public double movieGrade;
	public String movieDirector;
	public int announcementYear;

	public void set1() {
		movieTitle = "�г��� ����: ȩ��&��";
		movieGrade = 9.11;
		movieDirector = "���̺� ����ġ";
		announcementYear = 2019;
	}

	public void set2() {
		movieTitle = "������ ����";
		movieGrade = 9.20;
		movieDirector = "���ſ�";
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
	
		System.out.print("��ȭ ���� : ");
		movieTitle = scan.nextLine();
		
		System.out.print("��ȭ ���� : ");
		movieGrade = scan.nextDouble();
		scan.nextLine();
		
		System.out.print("��ȭ ���� : ");
		movieDirector = scan.nextLine();
		
		System.out.print("��ǥ ���� : ");
		announcementYear = scan.nextInt();
		scan.nextLine();
		
		System.out.println();
		
		scan.close();
	}

	public String toString() {
		String temp = "";
		for (int i = 0; i < (int)movieGrade / 2; i++) {
			temp += "��";
			if (i == (int)movieGrade / 2 - 1) {
				for (int j = 0; j < 5 - (int)movieGrade / 2; j++) {
					temp += "��";
				}
			}
		}

		return String.format("%-10s\t %s %.2f %-8s\t %d", movieTitle, temp, movieGrade, movieDirector, announcementYear);
	}
}
