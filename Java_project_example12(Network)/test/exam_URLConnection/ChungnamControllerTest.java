package exam_URLConnection;

import java.util.List;

import org.junit.Test;

public class ChungnamControllerTest {
	@Test
	public void dataProcess() {
		ChungnamController chungnam = new ChungnamController();
		List<ChungnamVO> data = chungnam.dataProcess();
		
		for (ChungnamVO vo : data) {
			System.out.println(vo.toString());
		}
	}
}
