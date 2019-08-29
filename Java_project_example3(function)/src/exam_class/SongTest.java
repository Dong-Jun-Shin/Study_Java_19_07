package exam_class;

public class SongTest {
	public static void main(String[] args) {
//	static 메소드 활용 배열 대입
//		Song song = new Song("Dansing Queen", "ABBA", "Arrival", 
//				Song.setComposer("Benny Andersson", "Bjorn Ulvaeus"),
//				1977, 2);
//	
//		song.show();

//	new를 활용한 배열선언을 대입
		Song song = new Song("Dansing Queen", "ABBA", "Arrival", 
				new String[] {"Benny Andersson", "Bjorn Ulvaeus"},
				1977, 2);
		
		song.show();
		
		
//	배열을 선언한 후, 배열을 대입
//		String[] composer ={"Benny Andersson", "Bjorn Ulvaeus"};
//		Song song = new Song("Dansing Queen", "ABBA", "Arrival", 
//				composer,	1977, 2);
//		
//		song.show();
//		
	}
}