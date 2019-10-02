package exam_object_stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamExample {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		FileOutputStream fos = new FileOutputStream("C:/Temp/object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(new Integer(10));
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[] { 1, 2, 3 });
		oos.writeObject(new String("홍길동"));

		oos.flush();
		oos.close();
		fos.close();

		FileInputStream fis = new FileInputStream("C:/Temp/object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Integer num = (Integer)ois.readObject();
		Double dou = (Double)ois.readObject();
		int[] numbers = (int[])ois.readObject();
		String str = (String)ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(num);
		System.out.println(dou);
		for (int i : numbers) {
			System.out.print(i + " ");			
		}
		System.out.println();
		System.out.println(str);
	}
}
