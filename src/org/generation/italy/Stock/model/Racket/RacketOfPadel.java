package org.generation.italy.Stock.model.Racket;
import java.util.Scanner;
import org.generation.italy.Stock.model.Product;
//Racchetta da padel: String Marca, double Peso, double Costo, Tipo (Rotonda, A Goccia, A Diamante)
// nota -> se non é inserito il tipo di racchetta, che mi chieda di inserirlo da tastiera, perché no?
//nota bis: e se faccio quelle forme un array list che mi permetta di aggiungere in futuro nuove forme?
public class RacketOfPaddington extends Product {
// Marca sostituirà -> nome, tipo -> categorìa
   public RacketOfPaddington(){
      super();
   }
   public RacketOfPaddington(double weight, double cost, String brand, String shapeType){
      super(weight,cost, brand, shapeType);
   }
   public String getBrand(){ //per una questione di coerenza, e venga più facile da usare
      return this.getname(); //useremo un equivalente di set/get name per il brand
   }
   public void setBrand(String brand){
      this.name = brand;
   }
   public String getShapeType(){
      return category;
   }
   public void setShapeType(String shapeType){
      if(!isValidShape(shapeType)){
         Scanner input = new Scanner(System.in);
         System.out.println("Mi dispiace, sono accettati solamente parametri quali \"Rotonda\", \"Goccia\" o " +
               "\"Diamante\" per quanto vale il valore della forma della racchetta");
         while(!isValidShape(shapeType)){ //finché è vero che non è vero, quidni finché é vero XD lo avevo sempre letto come non é vero!
            System.out.println("Prego inserisci la forma: ");//ma se ci pensi entra se è vero, quindi da true per la doppia negazione oOo
            shapeType = input.nextLine();
         }
      }
      this.category = shapeType;
   }
   private boolean isValidShape(String shapeType) {
      return shapeType.equalsIgnoreCase("Rotonda") || shapeType.equalsIgnoreCase("Goccia") ||
            shapeType.equalsIgnoreCase("Diamante"); //sinceramente me l'ha consigliato intelliJ, ma in effetti
   }                                                           //ha molto più senso che fare un if, tanto ritornerà
}                                                              //sempre o true o false, ed è ciò che mi serve
                                                               //mi sento scemo a non averci pensato .-. avevamo anche
                                                               //visto qualcosa del genere -.-"


