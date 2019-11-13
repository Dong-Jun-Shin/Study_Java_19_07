package exam_URLConnection;

public class ChungnamVO {
//	아이템 고유 번호
	private String mng_no;
//	지역명
	private String local_nm;
//	제목
	private String nm;
//	부제목		관광지, 축제, 충남도보여행길
	private String nm_sub;
//	주소			관광지, 축제, 음식점, 숙박업소, 체험관광, 충남도보여행길
	private String addr;
//	좌표(경도)		관광지, 축제, 음식점, 숙박업소, 충남도보여행길
	private String lat;
//	좌표(위도)		관광지, 축제, 음식점, 숙박업소, 충남도보여행길
	private String lng;
//	전화번호		관광지, 축제, 음식점, 숙박업소, 체험관광, 지역특산물
	private String tel;
//	홈페이지 URL	관광지, 축제, 음식점, 숙박업소, 체험관광, 지역특산물
	private String h_url;
//	상세설명		관광지, 축제, 충남도보여행길
	private String desc;
//	리스트 썸네일 이미지
	private String list_img;
//	등록일
	private String regDate;
//	축제기간
	private String festiavlDate;
//	아이템 이미지
	private String view_img;
	
	public String getMng_no() {
		return mng_no;
	}
	
	public void setMng_no(String mng_no) {
		this.mng_no = mng_no;
	}
	
	public String getLocal_nm() {
		return local_nm;
	}
	
	public void setLocal_nm(String local_nm) {
		this.local_nm = local_nm;
	}
	
	public String getNm() {
		return nm;
	}
	
	public void setNm(String nm) {
		this.nm = nm;
	}
	
	public String getNm_sub() {
		return nm_sub;
	}
	
	public void setNm_sub(String nm_sub) {
		this.nm_sub = nm_sub;
	}
	
	public String getAddr() {
		return addr;
	}
	
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	public String getLat() {
		return lat;
	}
	
	public void setLat(String lat) {
		this.lat = lat;
	}
	
	public String getLng() {
		return lng;
	}
	
	public void setLng(String lng) {
		this.lng = lng;
	}
	
	public String getTel() {
		return tel;
	}
	
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	public String getH_url() {
		return h_url;
	}
	
	public void setH_url(String h_url) {
		this.h_url = h_url;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getList_img() {
		return list_img;
	}
	
	public void setList_img(String list_img) {
		this.list_img = list_img;
	}
	
	public String getRegDate() {
		return regDate;
	}
	
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	
	public String getFestiavlDate() {
		return festiavlDate;
	}
	
	public void setFestiavlDate(String festiavlDate) {
		this.festiavlDate = festiavlDate;
	}
	
	public String getView_img() {
		return view_img;
	}
	
	public void setView_img(String view_img) {
		this.view_img = view_img;
	}
	
	@Override
	public String toString() {
		return "ChungnamVO [mng_no=" + mng_no + ", local_nm=" + local_nm + ", nm=" + nm + ", nm_sub=" + nm_sub
				+ ", addr=" + addr + ", lat=" + lat + ", lng=" + lng + ", tel=" + tel + ", h_url=" + h_url + ", desc="
				+ desc + ", list_img=" + list_img + ", regDate=" + regDate + ", festiavlDate=" + festiavlDate
				+ ", view_img=" + view_img + "]";
	}	
}
