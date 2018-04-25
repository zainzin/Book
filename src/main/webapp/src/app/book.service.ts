import {Injectable} from '@angular/core';
import {Http} from '@angular/http';
import {Observable} from "rxjs/Observable";
import 'rxjs/add/operator/map';

@Injectable()
export class BookService {

  constructor(private http: Http) {
  }

  getAllBooks(): Observable<Book[]> {
    return this.http.post('http://localhost:8080/rest/books', `{
      allBooks {
        isbn,
        title,
        publisher,
        publishedDate
      }
      }`).map((resp) => resp.json().data.allBooks);
  }

  oneBook(isbn: string): Observable<Book> {
    return this.http.post('http://localhost:8080/rest/books', `{
      oneBooks(isbn: ${isbn}) {
        isbn,
        title,
        publisher,
        publishedDate
      }
      }`).map((resp) => resp.json().data.oneBook);
  }

  createBook(title: string, publisher: string, publishedDate: string): Observable<Book> {
    return this.http.post('http://localhost:8080/rest/books', `mutation {
  createBook (title: "${title}",  publisher: "${publisher}", publishedDate: "${publishedDate}") {
    isbn,title,publisher,publishedDate
  }
}`).map((resp) => resp.json().data.createBook);
  }

}
