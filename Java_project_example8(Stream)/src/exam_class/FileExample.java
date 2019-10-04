package exam_class;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/*
 * 랜덤 메소드나 랜덤 클래스 등을 이용하여 10(각자 임의의 수)를 문자열의 형태로 들어있는 파일(input.txt)을 생성한다.
 * 생성된 파일을 읽어서 오름차순으로 정렬한 다음 정렬된 숫자를 문자열의 형태로 파일(output.txt)에 쓰는 프로그램을 작성하라.
 * 
 * input.txt -------------> output.txt
 * 127						0
 * 25						25
 * 10						127
 * 223						223
 */
public class FileExample {
	public static void main(String[] args) {
		BufferedWriter bw = null; 
		BufferedReader br = null;
		Set<Integer> numSet = null;
		
		//Input.txt 생성
		try {
			bw = new BufferedWriter(new FileWriter("C:/Temp/input.txt"));
			
			numSet = new TreeSet<Integer>(); 
			for (int i = 0; i < 10; i++) {
				int num = (int)((Math.random()*300)+1);
				numSet.add(num);
				bw.write(num + "\n");
			}
			bw.flush();
			
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}
		
		//Output.txt 생성
		try {
			br = new BufferedReader(new FileReader("C:/Temp/input.txt"));
			bw = new BufferedWriter(new FileWriter("C:/Temp/output.txt"));
			
			//TreeSet을 비워줌으로써, 다시 읽어오고 정렬하는데 사용한다고 가정
			numSet.clear();
			while(true) {
				String str = br.readLine();
				if(str == null) break;
				numSet.add(Integer.parseInt(str));
			}
			
			Iterator<Integer> it = numSet.iterator();
			while(it.hasNext()) {
				String str = it.next() + "";
				bw.write(str + "\n");
			}
			
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		}catch(IOException io) {
			io.printStackTrace();
		}finally {
			try {
				if(br != null) br.close();
				if(bw != null) bw.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		
		
		
		System.out.println("정렬 완료");
		
		
	}
}
