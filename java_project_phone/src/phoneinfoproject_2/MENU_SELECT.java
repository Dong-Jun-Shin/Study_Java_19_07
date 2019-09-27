package phoneinfoproject_2;

interface INPUT_SELECT{
	public final int DEFAULT_DATA = 1;
	public final int UNIVERSITY_DATA = 2;
	public final int COMPANY_DATA = 3;
}

public interface MENU_SELECT {
//	int INSERT=1, SEARCH=2, DELETE=3, EXIT=4;
	public final int INSERT_DATA = 1;
	public final int SELECT_DATA = 2;
	public final int DELETE_DATA = 3;
	public final int VIEW_LIST = 4;
	public final int EXIT = 5;
}
