package exam_stack;

import java.util.Stack;

public class StackExample {
	public static void main(String[] args) {
		Stack<Coin> coinBox = new Stack<Coin>();
		
		//push() 메소드 : Stack에 데이터 추가.
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(100));
		
		//pop() 메소드 : Stack에 데이터 반환.
		while(!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼내온 동전(pop) : " + coin.getValue() + "원");
		}
		System.out.println(coinBox.isEmpty());
	}
}
