package org.generation.italy.Stock;

import org.generation.italy.Stock.model.Books.Book;
import org.generation.italy.Stock.model.DVD.DVD;
import org.generation.italy.Stock.model.Market;
import org.generation.italy.Stock.model.Product;
import org.generation.italy.Stock.model.Racket.RacketOfPadel;

import java.util.ArrayList;
import java.util.Arrays;

public class ConsultingStock {
   public static void main(String[] args) {
//      Book vuoto = new Book();
//      System.out.println(vuoto.getIsbn()); //giusto per vedere che lo posso inizializzare vuoto
      Book HeadFirstJava = new Book(1.47,72.5,"Head First Java: A Learner's Guide to Real-World" +
            " Programming","Programmazione","***ISBN-10: 1491910771 *** ISBN-13: 978-1491910771***",
            716);
      Book ilSignoreDegliAnelli1 = new Book();
      ilSignoreDegliAnelli1.setWeight(0.430);
      ilSignoreDegliAnelli1.setIsbn("***ISBN-10: 8830105260 *** ISBN-13: 978-8830105263***");
      ilSignoreDegliAnelli1.setPages(606);
      ilSignoreDegliAnelli1.setTitle("La compagnia dell'anello: Vol. 1 ");
      ilSignoreDegliAnelli1.setCost(15.2);
      ilSignoreDegliAnelli1.setCategory("Fantasy");
      Book loSqualificato = new Book(0.120,9.5,"Lo squalificato", "Romanzo", "***ISBN-10: " +
            "8807889994 *** ISBN-13: 978-8807889998***", 160);
      DVD matrixper4 = new DVD(0.16,21.76,"MATRIX 4 FILM COLLECTION","Fantascienza",563);
      DVD hPx8 = new DVD(0.8,49.85,"Harry Potter 1-8 Collezione Completa (Box 16 Blu-Ray 4K Ultra-HD)",
            "Fantasy",1100);
      DVD juOn = new DVD();
      juOn.setDuration(91);
      juOn.setTitle("Ju-On - the Grudge");
      juOn.setCategory("J-Horror");
      juOn.setCost(12.2);
      juOn.setWeight(0.18144); //erano molto specifici coi grammi, ma dato che 4 (shi) i giapponese vuol dire morte
                              // forse l'hanno fatto apposta a mettere 181.44gr
      RacketOfPadel kontrolTonda = new RacketOfPadel(0.530, 58.64, "KONTROL 50", "Rotonda",
            "MAS Padel");
      RacketOfPadel reflexDiamante = new RacketOfPadel(0.355, 92.90, "RACCHETTA PADEL REFLEX",
            "Diamante", "Babolat");
      RacketOfPadel diamanteDiNome = new RacketOfPadel();
      diamanteDiNome.setWeight(0.83);
      diamanteDiNome.setCost(119.0);
      diamanteDiNome.setName("Racchetta PADEL DIAMOND");
      diamanteDiNome.setShapeType("Tonda di fatto");
      diamanteDiNome.setBrand("Rossini Sport");
      RacketOfPadel sky = new RacketOfPadel(0.370, 69.95,"Sky, Racchetta da padel con Overgrip",
            "goccia","Padel Nuestro ");
      RacketOfPadel fasulla =new RacketOfPadel(0,2999.99,"Fasullissima", "Goccia",
            "Fasulla's Corp.");

      Market jetMarket = new Market("Jet-Market", "Apu Nahasapeemapetilon");

      ArrayList<Product> prodottiVari = new ArrayList<>(Arrays.asList(HeadFirstJava, ilSignoreDegliAnelli1,
            loSqualificato, matrixper4, hPx8, juOn, kontrolTonda, reflexDiamante));
      jetMarket.setAllProducts(prodottiVari);
      jetMarket.addProductToMarket(diamanteDiNome);
      jetMarket.addProductToMarket(sky);
      jetMarket.addProductToMarket(fasulla);

      System.out.printf("Benvenuto a %s di %s!!!\nEcco alcune curiosit?? che potrebbero interessarti!\n",
            jetMarket.getMarketName(),jetMarket.getProprietario());

      System.out.printf("In totale nel negozio ci sono %d meravigliosi prodotti!!!\n", jetMarket.getTotalOfProducts());

      System.out.printf("Prova indovinare quanto pesano in totale... Nah tanto non ci arrivi, sono ben %,.3f kg!\n",
            jetMarket.totalWeight());

      System.out.println("Il nostro prodotto che costa di pi?? ?? " + jetMarket.moreExpensive().getname() +
            " ma tanto si vede che sei un poveraccio, non guardarlo neanche!");

      System.out.print("Ecco un elenco delle nostre racchette da padel a Goccia che valgono pi?? di 100 euro: \n");
      for (Product p : jetMarket.dropRacket()){
         System.out.printf("-%s che vale %,.2f???\n", p.getname(),p.getCost());
      }
      int numOfFantasyBooks = jetMarket.numBookFantasy();
      switch (numOfFantasyBooks){
         case 0:
            System.out.printf("Mi dispiace, non abbiamo libri Fantasy. %do%d",numOfFantasyBooks,numOfFantasyBooks);
            break;
         case 1:
            System.out.printf("Abbiamo solo %d libro Fantasy...\n", numOfFantasyBooks);
            break;
         default:
            System.out.printf("Abbiamo ben %d libri Fantasy...\n", numOfFantasyBooks);
      }
      Book temp = new Book();
      for(Product p : jetMarket.getAllProducts()){
         if(p.getCategory().equalsIgnoreCase("Fantasy" )&& p.getiDNumber() == temp.getiDNumber()){
            System.out.println(p.getname());
         }
      }
      temp = null; //non mi piace questa soluzione, come posso accedere alla variabile id senza un oggetto?
      System.out.println();
      jetMarket.setProprietario("Homer");
      System.out.printf("%s ha nu nuovo proprietario: %s\n",jetMarket.getMarketName(), jetMarket.getProprietario());

      int posizione = -1, posizione2= -1;
      posizione = jetMarket.getPositionOnArray(HeadFirstJava.getname());
      jetMarket.getAllProducts().get(posizione).discountPercent(83);
      posizione2 = jetMarket.getPositionOnArray(hPx8.getname());
      jetMarket.getAllProducts().get(posizione2).discountMinus(35);
      System.out.printf("%s ?? proprio un genio degli affari! Ha deciso di scontare:\n \"%s\" del 83%% e \n\"%s\" di 35???!!! " +
            "Approfittane!\n", jetMarket.getProprietario(), HeadFirstJava.getTitle(), hPx8.getTitle());
      System.out.printf("         ***Adesso costano*** \n*** %s: %,.2f??? --> %,.2f???\n*** %s:  %,.2f???--> %,.2f???\n",
            jetMarket.getAllProducts().get(posizione).getname(),
            jetMarket.getAllProducts().get(posizione).getOriginalCost(),
            jetMarket.getAllProducts().get(posizione).getCost(),
            jetMarket.getAllProducts().get(posizione2).getname(),
            jetMarket.getAllProducts().get(posizione2).getOriginalCost(),
            jetMarket.getAllProducts().get(posizione2).getCost());

//      System.out.println(Arrays.toString(jetMarket.getAllProductsNames()));

   }
}
