package phoneinfoproject9_;

public class MenuChoiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private int wrongChoice;

	public MenuChoiceException(int selNum) {
		super("잘못된 선택이 이뤄졌습니다.");
		wrongChoice = selNum;
	}

	public void showWrongChoice() {
		System.out.println(wrongChoice + "에 해당하는 선택은 존재하지 않습니다.");
	}

}
