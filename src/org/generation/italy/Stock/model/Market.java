package org.generation.italy.Stock.model;
import org.generation.italy.Stock.model.Racket.RacketOfPadel;

import java.util.ArrayList;

public class Market {
//   Creare una classe "Negozio" che dovrà avere un unico ArrayList che contiene tutti i suoi
//   prodotti e solo quelli;
   private String marketName;
   private String proprietario;
   private ArrayList<Product> allProducts;

   public Market(){}
   public Market(String marketName, String proprietario){
      this.marketName = marketName;
      this.proprietario = proprietario;
   }

   public void setMarketName(String marketName) {
      this.marketName = marketName;
   }

   public String getMarketName() {
      return marketName;
   }

   public String getProprietario() {
      return proprietario;
   }

   public void setProprietario(String proprietario) {
      this.proprietario = proprietario;
   }

   public ArrayList<Product> getAllProducts() {
      return allProducts;
   }

   public void setAllProducts(ArrayList<Product> allProducts) {
      this.allProducts = allProducts;
   }
   public String[] getAllProductsNames(){
      String[] names = new String[allProducts.size()];
      for (int i = 0; i < allProducts.size(); i++){
         names[i] = allProducts.get(i).name;
      }
      return names;
   }

   //3d. Una che aggiunga un nuovo prodotto alla lista dalla main, non da tastiera
   public void addProductToMarket(Product prod){
      allProducts.add(prod);
   }
// 3a. il numero di prodotti del Negozio
   public int getTotalOfProducts(){
      return allProducts.size();
   }
 //3b. il peso totale di tutti i prodotti al momento nel Negozio
   public double totalWeight(){
      double totalW = 0;
      for(Product prod : allProducts){
         totalW += prod.getWeight();
      }
      return totalW;
   }
//3c. il prodotto più costoso di tutto il negozio
   public Product moreExpensive(){
      Product mE;
      if(allProducts.size()>0) {                //controllo che abbia almeno un elemento
         mE = allProducts.get(0);               //aggiungo il valore nella posizione 0 (ci saràa almeno quella)
         for (Product prod : allProducts) {
            if (mE.getCost() < prod.getCost()) {//se il costo dentro l'array è più grande di quello dentro la pos
               mE = prod;                       //conservo il prodotto dentro la variabile mE
            }
         }
         return mE;                             //finito il for ritorno il prodotto con il costo maggiore
      }
      mE = null;                                //se non c'era nessuno elemento allora posso tornare il valore dell oggetto
      return mE;                                //ritornerà null, non avremo nessun oggetto
   }
   //Non è richiesta, ma metti che poi la voglio usare con un altro prodotto che non è un libro
   //con la categoria fantasy che facciamo? eh? cioè dai, ora l'abbiamo scritto il corrispondente
   //con SoftHouse, è da allocchi non farla, quasi una provocazione! Basta, mi sono arrabbiato, non scivo più!
   public int numberOfProductOnCategory(String categ){
      int prodNum = 0;
      if(allProducts.size()>0){
         for(Product prod : allProducts){
            if(prod.getCategory().equalsIgnoreCase(categ)){
               prodNum++;
            }
         }
      }
      return prodNum;
   }

//3e. il numero di libri nella categoria "Fantasy"
   public int numBookFantasy(String f){
      f="Fantasy";
      return numberOfProductOnCategory(f);
   }
//***********************Il nome è abbastanza explicito***********************
   public Product moreExpensiveOnCategory(String categ){
      Product prod;
      if(allProducts.size()>0){
         prod = allProducts.get(0);
         for(Product p : allProducts){
            if (p.getCost()>prod.getCost()){
               prod = p;
            }
         }
         return prod;
      }
      prod =null;
      return prod;
   }
//3f. un'ArrayList con dentro tutte le Racchette A Goccia, e che costano più di €100,00

   public ArrayList<Product> dropRacket100(){
      ArrayList<Product> dropRacket = new ArrayList<>(allProducts.size());
      if(allProducts.size()>0) {
         for (Product p : allProducts) {
            if(p.getClass() == RacketOfPadel.class) {
               if(((RacketOfPadel) p).getShapeType().equalsIgnoreCase("goccia")){
                  if (p.getCost() > 100.00) {
                     dropRacket.add(p);
                  }
               }
            }
         }
         return dropRacket;
      }
      return dropRacket;
   }

}
