package exam_interface_borrow;

public class BookCDMS {
	public static void main(String[] args) {
		SeparateVolume sv = new SeparateVolume(1, "엄마를 부탁해", "신경숙");
		sv.checkOut("홍길동", "20180201");
		sv.checkIn();
		
		AppCDInfo acd = new AppCDInfo(1, "Redhat Fedora");
		acd.checkOut("박희진", "20180129");
		acd.checkIn();
		
		//String[] songTitle = {"고백","청춘","내 사람"};
		MusicCDInfo cd = new MusicCDInfo(1, "기억속의 음악을 찾아", "김동률", new String[] {"고백","청춘","내 사람"});
		System.out.print(cd.toString());
		
	}
}
