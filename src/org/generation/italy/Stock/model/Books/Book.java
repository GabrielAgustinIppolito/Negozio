package org.generation.italy.Stock.model.Books;

import org.generation.italy.Stock.model.Product;
//Libro: String ISBN, String Titolo, String Categoria, double Peso, double Costo, int Pagine
public class Book extends Product {
   private String isbn;
   private int pages;

   public Book(){
      super();
      this.setIDNumber(1,"4dm1n");
   }
   public Book(double weight, double cost, String title, String category, String ISBN, int pages){
      super(weight,cost, title, category,1);
      this.isbn = ISBN;
      this.pages = pages;
   }
   public String getTitle(){ //per una questione di coerenza, e venga più facile da usare
      return this.getname(); //useremo un equivalente di set/get name per il titolo
   }
   public void setTitle(String title){
      this.name = title;
   }
   public void setIsbn(String isbn){
      this.isbn =isbn;
   }
   public String getIsbn(){
      return isbn;
   }

   public void setPages(int pages){
      this.pages = pages;
   }
   public int getPages(){
      return pages;
   }
}
