package exam_api_string.exam02_method;

public class StringEqualsExample {
	//File Extension Check
	public static boolean fileExtCheck(String fileName) {
		String[] fileNameExt = {"gif","jpg","png","jpeg"};
		//찾는 문자의 마지막 위치를 찾는다.
		String ext = fileName.substring(fileName.lastIndexOf(".")+1, fileName.length());
		
		for (int i = 0; i < fileNameExt.length; i++) {
			//확장자의 대소문자를 구분하지 않는다.
			if(ext.equalsIgnoreCase(fileNameExt[i])) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		//같은 리터럴의 주소를 가리킴
		String str1 = "Java";
		String str2 = "Java";
		
		//주소값 같음
		if(str1 == str2) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		//기본적으로 == 연산자와 동일한 결과 리턴(주소값 비교)
		//서로 각각의 객체를 생성해서 각 주소를 가리킴
		String strData1 = new String("Java");
		String strData2 = new String ("Java");
		
		//주소값 다름
		if(strData1 == strData2) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		
		//논리적 동등이란? 저장된 데이터가 동일한 것(같은 객체이건 다른 객체이건 상관없이)
		//equals() 메소드를 사용한다.
		//데이터 같음
		if(strData1.equals(strData2)) {
			System.out.println("동일 객체");
		}else {
			System.out.println("서로 다른 객체");
		}
		System.out.println();
		
		//-----------------------------------------------------------------------------
		
		String oldStr = "자바는 객체지향언어 입니다. 자바는 풍부한 API를 지원합니다.";
		String newStr = oldStr.replace("자바",  "JAVA");
		System.out.println("기존글 : " + oldStr);
		System.out.println("변환글 : " + newStr);
		
		//-----------------------------------------------------------------------------
		
		String cStr1 = "Java Programming";
		String cStr2 = "JAVA Programming";
		
		//내용값을 대소문자까지 비교
		System.out.println("문자비교:" + cStr1.equals(cStr2));
		//내용값을 대소문자 신경 안 쓰고 비교
		System.out.println("문자비교(대소문자 관계없이):" + cStr1.equalsIgnoreCase(cStr2));
		//대,소문자 변환
		System.out.println("소문자변환:" + cStr2.toLowerCase());
		System.out.println("대문자변환:" + cStr1.toUpperCase());
		
		System.out.println();
		//-----------------------------------------------------------------------------
		
		String tel1 = "  02  ";
		System.out.println("tel1의 문자수 : "+tel1.length());
		System.out.println("tel1의 공백 제거 후 문자수 : "+tel1.trim().length());
		
		System.out.println();
		
		//-----------------------------------------------------------------------------
		// 변수 fileName에 저장된 파일명에서 확장자 체크하여 이미지 파일(gif/jpg/png/jpeg)
		// 외 나머지 확장자를 가진 파일인 경우 "이미지 파일만 등록가능합니다."라는 메시지를 출력하도록 작성해 보세요.
		// 파일 확장자를 체크하는 메소드 호출(fileExtCheck)
		
		String fileName = "test.txt";
		System.out.println("파일명 : "+fileName);
		
		//확장자가 지정 이외의 값인 false이면 반전시켜서 실행
		if(!fileExtCheck(fileName)) {
			System.out.println("이미지 파일만 등록가능합니다.");
		}
		
//		System.out.println();
	}
}
