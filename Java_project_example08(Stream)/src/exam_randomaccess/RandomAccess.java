package exam_randomaccess;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
	public static void main(String[] args) throws Exception{
		//파일 생성 및 입력
		FileOutputStream fos = new FileOutputStream("C:/Temp/data.txt");
		String str = " ABC DE ";
		char[] bArr = str.toCharArray();
		for (char c : bArr) {
			fos.write((int)c);			
		}
		System.out.println("생성 완료");
		fos.close();
		
		//예제1
		RandomAccessFile raf1 = null;
		try {
			raf1 = new RandomAccessFile("C:/Temp/data.txt", "r");
			System.out.println("현재 파일 포인터 위치:" + raf1.getFilePointer());
			//파일포인터를 지정위치로 설정, 인덱스 시작은 0부터 
			raf1.seek(2);
			System.out.println((char)raf1.read());
		}catch(IOException io) {
			io.printStackTrace();
		}
		
		//예제2
		File f = new File("C:/Temp/random.txt");
		try(RandomAccessFile raf2 = new RandomAccessFile(f, "rw")){
			String data = "욕심과 불평에는 끝이 없고 감사와 칭찬에는 뒤끝이 없다(비상중)";
			long len = raf2.length();
			System.out.println(len);
			raf2.seek(len);
			raf2.writeUTF(data);
			
			raf2.seek(len);	//len은 데이터를 기록하기 전의 파일 포인터의 위치이다.
			System.out.println(raf2.readUTF());
//			raf.seek(0); //파일 포인터를 파일의 처음으로 이동시킨다.
//			System.out.println(raf.readUTF());
		}catch(FileNotFoundException fn) {
			fn.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
