package exam_object_stream;

import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class ObjectInputOutputStreamExample01 {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		String file = "object.dat";
		output(file);
		input(file);
	}

	public static void output(String file) {
		try (FileOutputStream fos = new FileOutputStream(file); 
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {

			for (int i = 0; i < 2; i++) {
				System.out.print("이름: ");
				String name = scan.nextLine();
				System.out.print("나이: ");
				int age = scan.nextInt();
				scan.nextLine();

				Person person = new Person(name, age);
				oos.writeObject(person);

				System.out.println((i + 1) + "번째 " + "쓰기 완료\n");
			}

		} catch (IOException io) {
			io.printStackTrace();
		}
	}

	public static void input(String file) {
		try (FileInputStream fis = new FileInputStream(file); 
			ObjectInputStream ois = new ObjectInputStream(fis)) {

			// 레코드가 여러개일 경우에, 반복문을 이용해서 출력
			while (true) {
				Person person = (Person) ois.readObject();
				System.out.println("입력한 이름은 " + person.getName() + "입니다.");
				System.out.println("입력한 나이는 " + person.getAge() + "입니다.");
				System.out.println();
			}
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (IOException io) {
			//EOFException(파일끝)도 포함되어 있다.
			//io.printStackTrace();
		}
	}
}
