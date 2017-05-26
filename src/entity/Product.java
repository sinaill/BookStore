package entity;



public class Product {
	private int id;
	private String name;
	private String author;
	private String publisher;
	private String publish_time;
	private String description;
	private float price;
	private String picture;
	
	
	private String words;
	private int revision;//版次
	private int impression;//印次
	private int total_page;
	private String print_time;
	private String ISBN;
	private String sumary;
	private String paper;//纸张类型
	private String packaging;//包装类型
	private int stock;//库存
	
	private Category category;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}




	public Product(){
		
	}
	
	public Product(String name, String author, String publisher, String publish_time, String description, float price,
			String picture) {
		super();
		this.name = name;
		this.author = author;
		this.publisher = publisher;
		this.publish_time = publish_time;
		this.description = description;
		this.price = price;
		this.picture = picture;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getWords() {
		return words;
	}
	public void setWords(String words) {
		this.words = words;
	}
	public int getRevision() {
		return revision;
	}
	public void setRevision(int revision) {
		this.revision = revision;
	}
	public int getImpression() {
		return impression;
	}
	public void setImpression(int impression) {
		this.impression = impression;
	}
	public int getTotal_page() {
		return total_page;
	}
	public void setTotal_page(int total_page) {
		this.total_page = total_page;
	}

	public String getPublish_time() {
		return publish_time;
	}

	public void setPublish_time(String publish_time) {
		this.publish_time = publish_time;
	}

	public String getPrint_time() {
		return print_time;
	}

	public void setPrint_time(String print_time) {
		this.print_time = print_time;
	}

	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}
	public String getSumary() {
		return sumary;
	}
	public void setSumary(String sumary) {
		this.sumary = sumary;
	}
	public String getPaper() {
		return paper;
	}
	public void setPaper(String paper) {
		this.paper = paper;
	}
	public String getPackaging() {
		return packaging;
	}
	public void setPackaging(String packaging) {
		this.packaging = packaging;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
}
