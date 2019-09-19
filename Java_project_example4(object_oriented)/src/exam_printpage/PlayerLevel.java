package exam_printpage;

public abstract class PlayerLevel{
	public abstract void run();
	public abstract void jump();
	public abstract void turn();
	public abstract void showLevelMessage();
	public void go(int count) {
		run();
		for (int i = 0; i < count; i++) {
			jump();
		}
		turn();
	};
}

class BeginnerLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("Jump 할 수 없습니다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("Turn 할 수 없습니다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("***** 초보자 레벨 입니다. *****");
	}
	
}

class AdvancedLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("빨리 달립니다.");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("높이 Jump 합니다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("Turn 할 수 없습니다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("***** 중급자 레벨 입니다. *****");
	}
	
}

class SuperLevel extends PlayerLevel{

	@Override
	public void run() {
		System.out.println("천천히 달립니다.");
	}

	@Override
	public void jump() {
		// TODO Auto-generated method stub
		System.out.println("아주 높이 Jump 합니다.");
	}

	@Override
	public void turn() {
		// TODO Auto-generated method stub
		System.out.println("한 바퀴 돕니다.");
	}

	@Override
	public void showLevelMessage() {
		// TODO Auto-generated method stub
		System.out.println("***** 고급자 레벨 입니다. *****");
	}
	
}
