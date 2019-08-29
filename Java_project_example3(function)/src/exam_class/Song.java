﻿package exam_class;

/*
 * 생성자는 기본 생성자와 모든 필드를 초기화하는 생성자를 작성하고, 노래의 정보를 화면에 출력하는
 * show() 메소드도 작성하라. 각자 원하는 노래로 Song 객체를 생성하고 show()를 이용하여
 * 이 노래의 정보를 출력하는 프로그램을 작성하라.
 * 
 * [출력 결과]
 * 노래 제목 : Dansing Queen
 * 가수 : ABBA
 * 앨범 : Arrival
 * 작곡자 : Benny Andersson, Bjorn Ulaveus
 * 년도 : 1977
 * 트랙 번호 : 2
 */
public class Song {
	private String title;
	private String artist;
	private String album;
	private String[] composer;
	private int year;
	private int track;
	
	//디폴트 생성자
	public Song() {

	}

	//생성자 (매개변수 전부)
	public Song(String title, String artist, String album, String[] composer, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.composer = composer;
		this.year = year;
		this.track = track;
	}

	//getter, setter
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String[] getComposer() {
		return composer;
	}

	//여러명이 될 수 있는 작곡가 배열로 받기
	public static String[] setComposer(String... composer) {
		String[] temp = composer;

		return temp;
	}
	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}


	//메소드 (보여주기)
	public void show() {
		System.out.printf("노래 제목 : %s\n", title);
		System.out.printf("가수 : %s\n", artist);
		System.out.printf("앨범 : %s\n", album);
		System.out.printf("작곡가 : ");
		for (int i = 0; i < composer.length; i++) {
			System.out.printf("%s", composer[i]);
			if (i == composer.length - 1)
				System.out.printf("\n");
			else
				System.out.printf(", ");

		}
		System.out.printf("년도 : %d\n", year);
		System.out.printf("트랙 번호 : %d\n", track);
	}
}
