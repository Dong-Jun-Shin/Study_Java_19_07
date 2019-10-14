package exam_object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectStreamTest {
	public static void main(String[] args) {
		UserBean user = new UserBean("javauser", "홍길동", "010-1234-9876", "서울시 성동구");
		
		try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("C:/Temp/user.dat"))){
			out.writeObject(user);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("쓰기 완료");

		try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/Temp/user.dat"))){
			UserBean user1 = (UserBean)in.readObject();
			System.out.println(user1);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
