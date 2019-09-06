package exam_array_2Dimension;

public class examArray2D {
	public static int[][] logic(int[][] arr, String sort) {
		int temp = 1;
		if (sort.equals("rows")) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					arr[i][j] = temp;
					temp++;
				}
			}
		} else {
			for (int j = 0; j < arr.length; j++) {
				for (int i = 0; i < arr[j].length; i++) {
					arr[i][j] = temp;
					temp++;
				}
			}
		}
		return arr;
	}

	public static void show(int[][] arr, String Change) {
		if (Change.equals("before")) {
			System.out.println("변경 전");
		} else {
			System.out.println("변경 후");
		}

		System.out.println("---------------------------");
		for (int i = 0; i < arr.length; i++) {
			for (int value : arr[i]) {
				System.out.printf("%4d ", value);
			}
			System.out.println();
		}
		System.out.println("---------------------------\n");
	}

	public static int[][] arraySum(int[][] arr, String sort) {
		switch (sort) {
		case "rows":
			// 가로합
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr[i].length - 1; j++) {
					arr[i][arr[i].length - 1] += arr[i][j];
				}
			}
			break;
		case "columns":
			// 세로합
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr[i].length - 1; j++) {
					arr[arr.length - 1][j] += arr[i][j];
				}
			}
			break;
		case "diagonal":
			// 대각선 합
			for (int i = 0; i < arr.length - 1; i++) {
				for (int j = 0; j < arr[i].length - 1; j++) {
					if (i == j) {
						arr[arr.length - 1][arr[i].length - 1] += arr[i][j];
					}
					continue;
				}
			}
			break;
		}
		return arr;
	}

	public static void insert(int[][] arr) {
		int num = 1;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr[i].length - 1; j++) {
				arr[i][j] = num++;
			}
		}
	}
}
