package org.generation.italy.Stock.model.Racket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import org.generation.italy.Stock.model.Product;
//Racchetta da padel: String Marca, double Peso, double Costo, Tipo (Rotonda, A Goccia, A Diamante)
// nota -> se non é inserito il tipo di racchetta, che mi chieda di inserirlo da tastiera, perché no?
//nota bis: e se faccio quelle forme un array list che mi permetta di aggiungere in futuro nuove forme?
public class RacketOfPadel extends Product {
//  tipo -> categorìa
   private String brand;
   private ArrayList<String> shapes;//nel caso un giorno spuntasse una nuova forma potremmo aggiungerla
   public RacketOfPadel(){
      super();
      this.setIDNumber(3,"4dm1n");
   }
   public RacketOfPadel(double weight, double cost, String nome, String shapeType, String brand){
      super(weight,cost, nome, shapeType,3);
      this.brand = brand;
      shapes = new ArrayList<>(Arrays.asList("Rotonda","Goccia","Diamante"));
      if(!this.isValidShape(this.getShapeType())){
         setShapeType(shapeType);
      }
   }
   public String getBrand(){
      return this.brand;
   }
   public void setBrand(String brand){
      this.brand = brand;
   }
   public String getShapeType(){
      return category;
   }
   public void setShapeType(String shapeType){
      shapes = new ArrayList<>(Arrays.asList("Rotonda","Goccia","Diamante"));
      if(!isValidShape(shapeType)){
         Scanner input = new Scanner(System.in);
         System.out.printf("***\"%s\" FORMA NON VALIDA***\n", shapeType);
         System.out.println("Mi dispiace, sono accettati solamente parametri quali \"Rotonda\", \"Goccia\" o " +
               "\"Diamante\" per quanto vale il valore della forma della racchetta");
         while(!isValidShape(shapeType)){//finché è vero che non è vero, quidni finché é vero XD lo avevo sempre letto come non é vero!
            System.out.println("Prego inserisci la forma: ");//ma se ci pensi entra se è vero, quindi da true per la doppia negazione oOo
            shapeType = input.nextLine();
         }
      }
      this.category = shapeType;
   }
   private boolean isValidShape(String shapeType) {
      //***ci ho ripensato, per le forme userò un arrayList***
      for (String s : shapes) {
         if (shapeType.equalsIgnoreCase(s)){
            return true;
         }
      }
      return false;
      //return shapeType.equalsIgnoreCase("Rotonda") || shapeType.equalsIgnoreCase("Goccia") || *--> lo voglio conservare per non dimenticare
        //    shapeType.equalsIgnoreCase("Diamante"); //sinceramente me l'ha consigliato intelliJ, ma in effetti
   }                                                           //ha molto più senso che fare un if, tanto ritornerà
}                                                              //sempre o true o false, ed è ciò che mi serve
                                                               //mi sento scemo a non averci pensato .-. avevamo anche
                                                               //visto qualcosa del genere -.-"


