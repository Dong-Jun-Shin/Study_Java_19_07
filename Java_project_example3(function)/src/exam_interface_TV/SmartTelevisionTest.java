package exam_interface_TV;

public class SmartTelevisionTest {
	public static void main(String[] args) {
		SmartTelevision st = new SmartTelevision();
		String url = "https://www.naver.com/";
				
		st.search(url);
		
		st.setMute(true);
		st.setMute(false);
	}
}
