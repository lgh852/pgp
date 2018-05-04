package p.g.p.model;

public class Shopping {
	private String total;
	private String start;
	private String display;
	private String title;
	private String link;
	private String image;
	private String lprice;
	private String hprice;
	private String mallName;
	private String productId;
	private String productType;
	private String item;
	private String channel;
	
	@Override
	public String toString() {
		return "Book [total=" + total + ", start=" + start + ", display=" + display + ", title=" + title + ", link="
				+ link + ", image=" + image + ", lprice=" + lprice + ", hprice=" + hprice + ", mallName=" + mallName
				+ ", productId=" + productId + ", productType=" + productType + ", item=" + item + ", channel="
				+ channel + "]";
	}
	public Shopping(String total, String start, String display, String title, String link, String image, String lprice,
			String hprice, String mallName, String productId, String productType, String item, String channel) {
		super();
		this.total = total;
		this.start = start;
		this.display = display;
		this.title = title;
		this.link = link;
		this.image = image;
		this.lprice = lprice;
		this.hprice = hprice;
		this.mallName = mallName;
		this.productId = productId;
		this.productType = productType;
		this.item = item;
		this.channel = channel;
	}
	public Shopping() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getLprice() {
		return lprice;
	}
	public void setLprice(String lprice) {
		this.lprice = lprice;
	}
	public String getHprice() {
		return hprice;
	}
	public void setHprice(String hprice) {
		this.hprice = hprice;
	}
	public String getMallName() {
		return mallName;
	}
	public void setMallName(String mallName) {
		this.mallName = mallName;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	
}
