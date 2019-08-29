package exam_class_basic;

public class AddressTest {
	public static void main(String[] args) {
		Address nancyAdd = new Address();
		nancyAdd.getData("Nancy", "LA", "322-668-9903");
		System.out.println(nancyAdd.toString());
		
		Address janeAdd = new Address();
		janeAdd.getData("Jane", "California", "322-558-1929");
		System.out.println(janeAdd.toString());
		System.out.println(String.format("%s %-20s %s \n", janeAdd.name, janeAdd.addr, janeAdd.tel));
		
		Address ae = new Address();
		ae.getData("ȫ�浿", "����� ������ ������ 77-23����", "02-777-2452");
		System.out.println(String.format("%s %-20s %s \n", ae.name, ae.addr, ae.tel));
	}
}
