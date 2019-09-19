package exam_printpage;

class Player {
	private PlayerLevel level;

	public Player() {
		level = new BeginnerLevel();
	}

	public PlayerLevel getLevel() {
		return this.level;
	}

	public void upgradeLevel(PlayerLevel level) {
		String sLevel = "";
		
		if (level instanceof BeginnerLevel) {
			sLevel = "BeginnerLevel";
			return;
		} else if (level instanceof AdvancedLevel) {
			sLevel = "AdvancedLevel";
		} else if (level instanceof SuperLevel) {
			sLevel = "SuperLevel";
		}
		
		System.out.println("\n-----------------------------");
		System.out.println("선택한 레벨(" + sLevel + ")로 변경합니다.");
		System.out.println("-----------------------------\n");
		
		this.level = level;
	}

	public void play() {
		level.showLevelMessage();
	}
}
public class PlayerTest {
	public static void main(String[] args) {
		Player p1 = new Player();

		p1.play();
		p1.getLevel().go(1);

		p1.upgradeLevel(new BeginnerLevel());
		p1.upgradeLevel(new AdvancedLevel());

		p1.play(); 
		p1.getLevel().go(2);

		p1.upgradeLevel(new SuperLevel());

		p1.play();
		p1.getLevel().go(3);
	}
}
