package exam_object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest02 {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// 쓰기
		PhoneInfo[] wpi = { new PhoneInfo("홍길동", "010-3432-8796"),
				new PhoneInfo("김희진", "010-5901-3546"),
				new PhoneInfo("아무개", "010-1111-2222")};

		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:/Temp/object.dat"))) {
			for (PhoneInfo phoneInfo : wpi) {
				oos.writeObject(phoneInfo);
			}
			System.out.println("쓰기 완료");
		} catch (IOException io) {
			io.printStackTrace();
		}

		// 읽기
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:/Temp/object.dat"))) {
			//TODO 바로 0을 리턴하는 것 고치기
			while (ois.available() > 0) {
				PhoneInfo rpi = (PhoneInfo) ois.readObject();
				PhoneInfo.showPhoneInfo(rpi);
			}
//			while(true) {
//				//readObject는 끝까지 읽어들인다.
//				PhoneInfo info = (PhoneInfo)ois.readObject();
//				if(info==null) {break;}
//				PhoneInfo.showPhoneInfo(info);
//			}
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
