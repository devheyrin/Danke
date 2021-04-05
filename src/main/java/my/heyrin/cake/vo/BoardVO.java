package my.heyrin.cake.vo;

public class BoardVO {
	
	private long articleno;
	private String id;
	private String title;
	private String cont;
	private String img;
	
	
	
	public BoardVO() {
		super();
	}
	
	

	public BoardVO(long articleno, String id, String title, String cont, String img) {
		super();
		this.articleno = articleno;
		this.id = id;
		this.title = title;
		this.cont = cont;
		this.img = img;
	}
	
	public long getArticleno() {
		return articleno;
	}
	public void setArticleno(long articleno) {
		this.articleno = articleno;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	

}
