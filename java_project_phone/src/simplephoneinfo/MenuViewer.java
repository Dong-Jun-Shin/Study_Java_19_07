package simplephoneinfo;

public class MenuViewer {
	public static void showFrame() {
		System.out.println("선택하세요");
		System.out.println("1. 데이터 입력");
		System.out.println("2. 데이터 검색");
		System.out.println("3. 데이터 삭제");
		System.out.println("4. 데이터 조회");
		System.out.println("5. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void showInsertFrame() {
		System.out.println("데이터 입력을 시작합니다.");
		System.out.println("1.일반   2.대학   3.회사");
		System.out.print("선택 >> ");
	}
	
	public static void showSelectFrame() {
		System.out.println("데이터 검색을 시작합니다.");
		System.out.print("이름 : ");
	}
	
	public static void showDeleteFrame() {
		System.out.println("데이터 삭제를 시작합니다.");
		System.out.print("이름 : ");
	}
}
