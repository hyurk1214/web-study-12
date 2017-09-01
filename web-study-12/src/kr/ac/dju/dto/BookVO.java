package kr.ac.dju.dto;

public class BookVO {
  private int num;
  private String title;
  private String writer;
  private String publisher;
  private int price;
  private String pictureUrl;
  private String description;
  private int bookcount;
  
  public int getNum() {
    return num;
  }
  public void setNum(int num) {
    this.num = num;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getWriter() {
    return writer;
  }
  public void setWriter(String writer) {
    this.writer = writer;
  }
  public String getPublisher() {
    return publisher;
  }
  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }
  public int getPrice() {
    return price;
  }
  public void setPrice(int price) {
    this.price = price;
  }
  public int getBookcount() {
    return bookcount;
  }
  public void setBookcount(int bookcount) {
    this.bookcount = bookcount;
  }
  public String getPictureUrl() {
    return pictureUrl;
  }
  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  
}
