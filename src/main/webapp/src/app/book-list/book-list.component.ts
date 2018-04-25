import {Component, OnInit} from '@angular/core';
import {BookService} from '../book.service';

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.css'],
  providers: [BookService]
})
export class BookListComponent implements OnInit {

  books: Book[];

  title: string;
  publisher: string;
  publishedDate: string;

  constructor(private bookService: BookService) {
  }

  ngOnInit() {
    this.bookService.getAllBooks().subscribe((books) => {
      this.books = books;
    });
  }

  createBook() {
    if (this.title && this.publisher && this.publishedDate) {
      this.bookService.createBook(this.title, this.publisher, this.publishedDate).subscribe((book) => {
        this.books.push(book);
      });
    }
  }

}
