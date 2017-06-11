package com.zh.young.aidldemo;

import com.zh.young.aidldemo.Book;
interface IBookManager {

   void addBook(in Book book);
   List<Book> getBooks();
}
