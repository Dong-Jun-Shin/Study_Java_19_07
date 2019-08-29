package exam_for;

public class GugudanExample2 {
	public static void main(String[] args) {
		int i,j,k;
		
		for(k=0; k<3; k++) {
			for(j=0; j<=9; j++) {
				for(i=k*3+1; i<=(k+1)*3; i++) {
					if(j==0) {
						System.out.printf("%d단\t\t", i);
					}else {
						System.out.printf("%d * %d = %2d\t", i, j, i*j);
					}
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
