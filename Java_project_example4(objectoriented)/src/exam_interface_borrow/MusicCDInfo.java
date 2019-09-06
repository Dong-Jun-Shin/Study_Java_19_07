package exam_interface_borrow;

public class MusicCDInfo extends CDInfo{
	private String artist;
	private String[] songTitle;
	
	public MusicCDInfo(int registerNo, String title, String artist, String[] songTitle) {
		super(registerNo, title);
		this.artist = artist;
		this.songTitle = songTitle;
	}
	
	protected final String getArtist() {
		return artist;
	}
	protected final void setArtist(String artist) {
		this.artist = artist;
	}
	protected final String[] getSongTitle() {
		return songTitle;
	}
	protected final void setSongTitle(String[] songTitle) {
		this.songTitle = songTitle;
	}

	@Override
	public String toString() {
		String sData = "";
		
		for (int i = 0; i < songTitle.length; i++) {
			sData += getSongTitle()[i];
			if(i<songTitle.length-1) {
				 sData += ", ";
			}
		}

		return String.format("%s [ %s ] 음반.\n", getArtist(), sData);
	}
	
	
}
