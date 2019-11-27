package exam_Function;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

public class ConsumerExample {
	public static void main(String[] args) {
		Consumer<Date> date = (d) -> {
			String s = new SimpleDateFormat("YYYY-MM-dd").format(d);
			System.out.println(s);
		};
		date.accept(new Date());
	}
}
