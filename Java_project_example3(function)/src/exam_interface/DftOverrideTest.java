package exam_interface;

interface Buy{
	public abstract void buy();
	
	public default void order() {
		System.out.println("구매 주문");
	}
}

interface Sell{
	void sell();
	
	default void order() {
		System.out.println("판매 주문");
	}
}

public class DftOverrideTest implements Buy, Sell{
	@Override
	public void sell() {
		// TODO Auto-generated method stub
		System.out.println("Dft 판매주문");
	}
	
	@Override
	public void buy() {
		// TODO Auto-generated method stub
		System.out.println("Dft 구매주문");
	}
	
	@Override
//	같은 디폴트가 중복(두 개)이여서, 재정의
	public void order() {
		System.out.print("Dft ");
		Buy.super.order();	//Buy의 디폴트 메소드를 불러온다.
		System.out.print("Dft ");
		Sell.super.order();	//Sell의 디폴트 메소드를 불러온다.
	}
	
	public static void main(String[] args) {
		DftOverrideTest customer = new DftOverrideTest();
		
		Buy buyer = customer;
		buyer.buy();	//DftOverrideTest의 buy() -> Dft구매주문
		buyer.order();	//DftOverrideTest의 재정의된 디폴트 -> Buy와 Sell의 디폴트 순차 출력
		
		Sell seller = customer;
		seller.sell();	//DftOverrideTest의 sell() -> Dft판매주문
		seller.order();	//DftOverrideTest의 재정의된 디폴트 -> Buy와 Sell의 디폴트 순차 출력
		
		if(seller instanceof DftOverrideTest) {
			DftOverrideTest customer2 = (DftOverrideTest)seller;
			customer2.buy();	//True로 출력  -> Dft의 buy();
			customer2.sell();	//True로 출력  -> Dft의 sell();
		}
		
		//다형성(업, 다운)에 있어서 항상 구현된 클래스의 대상이 우선순위를 가지고 있다.
	}
}
