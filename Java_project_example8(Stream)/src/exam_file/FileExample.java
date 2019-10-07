package exam_file;

import java.io.File;
import java.util.Date;
import java.text.SimpleDateFormat;

public class FileExample {
	public static void main(String[] args) throws Exception{
		File dir = new File("C:/Temp/Dir");
		File file1 = new File("C:/Temp/file1.txt");
		File file2 = new File("C:/Temp/file2.txt");

		//경로상 폴더 있는지 확인
		if(!dir.exists()) {
			//명시한 경로 상 없는 폴더 모두 생성
			System.out.println("경로상 폴더 미확인");
			dir.mkdirs();
			System.out.println("폴더 생성");
		}
		//경로상 파일 있는지 확인
		if(file1.exists()) {
			System.out.println("파일 확인");
			//파일 삭제
			file1.delete();
			System.out.println("파일 삭제");
		}
		//경로상 파일 있는지 확인
		if(!file2.exists()) {
			System.out.println("파일 미확인");
			//파일 생성
			file2.createNewFile();
			System.out.println("파일 생성");
		}
		
		File temp = new File("C:/Temp");
		//날짜 포맷 클래스에 포맷 지정
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a  HH:mm");
		
		File[] contents = temp.listFiles();
		System.out.println("        날짜 \t시간 \t      형태 \t\t크기 \t이름");
		System.out.println("--------------------------------------------------------");
		for (File file : contents) {
			//sdf.format으로 문자열 반환, Date클래스에 매개변수로 마지막 수정날짜를 대입한다.
			System.out.print(sdf.format(new Date(file.lastModified())));
			
			//변수에 담긴게 폴더인지 확인
			if(file.isDirectory()) {
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			}else {
				//.length() = 파일크기
				System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
			}
			System.out.println();
		}
	}
}
