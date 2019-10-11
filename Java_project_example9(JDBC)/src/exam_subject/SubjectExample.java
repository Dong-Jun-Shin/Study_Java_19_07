package exam_subject;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectExample {
	static Scanner scan = new Scanner(System.in);

	public static void showMenu() {
		System.out.println("선택하세요...");
		System.out.println("1. 데이터 조회");
		System.out.println("2. 데이터 입력");
		System.out.println("3. 데이터 수정");
		System.out.println("4. 데이터 삭제");
		System.out.println("5. 데이터 검색(학과명)");
		System.out.println("6. 프로그램 종료");
		System.out.print("선택 : ");
	}

	public static void main(String[] args) {
		SubjectDAO dao = SubjectDAO.getInstance();
		int menuChoice;

		while (true) {
			showMenu();
			menuChoice = scan.nextInt();
			scan.nextLine();

			switch (menuChoice) {
			case 1:
				read(dao);
				break;
			case 2:
				create(dao);
				break;
			case 3:
				update(dao);
				break;
			case 4:	
				delete(dao);
				break;
			case 5:
				search(dao);
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			}
		}
	}
	
	private static void read(SubjectDAO dao) {
		try {
			ArrayList<SubjectVO> svo = dao.getSubjectTotal();
			System.out.println("\n**** subject 테이블 데이터 출력 ****");
			System.out.println("번호\t학과번호\t학과명");
			
			if(svo.size()>0) {
//				for (int i = 0; i < svo.size(); i++) {
//				SubjectVO sub = svo.get(i);
				for (SubjectVO sub : svo) {
					System.out.print(sub.getNo()+"\t");
					System.out.print(sub.getS_num()+"\t");
					System.out.println(sub.getS_name()+"\t");
				}
			}else {
				System.out.println("학과 정보가 존재하지 않습니다.\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void create(SubjectDAO dao) {
		try {
			SubjectVO svo = new SubjectVO();
			
			System.out.print("추가할 학과번호 입력 : ");
			svo.setS_num(scan.nextLine());
			System.out.print("추가할 학과명 입력 : ");
			svo.setS_name(scan.nextLine());
			
			boolean success = dao.subjectInsert(svo);
			if(success)
				System.out.println("학과 데이터 입력 성공.\n");
			else
				System.out.println("학과 데이터 입력 실패.\n");
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void delete(SubjectDAO dao) {
		try {
			System.out.print("삭제할 학과명을 입력해주세요. ");
			String s_name = scan.nextLine();
			boolean success = dao.subjectDelete(s_name);
			
			if(success)
				System.out.println("학과 데이터 삭제 성공");
			else
				System.out.println("학과 데이터 삭제 실패");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void update(SubjectDAO dao) {
		try {
			SubjectVO svo = new SubjectVO();
			System.out.print("수정할 기준이 되는 번호를 입력해주세요. ");
			svo.setNo(scan.nextInt());
			scan.nextLine();
			
			System.out.print("수정할 학과번호를 입력해주세요. ");
			svo.setS_num(scan.nextLine());
			System.out.print("수정할 학과명을 입력해주세요. ");
			svo.setS_name(scan.nextLine());
			
			dao.subjectUpdate(svo);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void search(SubjectDAO dao) {
		//TODO getSubjectSearch 활용
		ArrayList<SubjectVO> list = null;
		try {
			System.out.println("조회할 학과명을 입력해주세요.");
			String s_name = scan.nextLine();
			list = dao.subjectSelect(s_name);
			
			if(list.size() > 0) {
				System.out.println("\n**** subject 테이블 데이터 출력 ****");
				System.out.println("번호\t학과번호\t학과명");
				for (SubjectVO subjectVO : list) {
					System.out.print(subjectVO.getNo() + "\t");
					System.out.print(subjectVO.getS_num() + "\t");
					System.out.println(subjectVO.getS_name());
				}
				System.out.println();
			}else {
				System.out.println("일치하는 결과가 없습니다.\n");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
