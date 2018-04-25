class Book {
  public isbn?: string;
  public title?: string;
  public publisher?: string;
  public publishedDate?: string;

  constructor(isbn: string, title: string, publisher: string, publishedDate: string) {
    this.isbn = isbn;
    this.title = title;
    this.publisher = publisher;
    this.publishedDate = publishedDate;
  }
}
