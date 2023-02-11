package Stock.model.DVD;

import Stock.model.Product;
//DVD: String Titolo, String Categoria, double Peso, double Costo, double Durata
public class DVD extends Product {
   private double duration;
   public DVD(){
      super();
   }
   public DVD(double weight, double cost, String title, String category,  double duration){
      super(weight,cost, title, category);
      this.duration = duration;
   }
   public String getTitle(){ //per una questione di coerenza, e venga più facile da usare
      return this.getname(); //useremo un equivalente di set/get name per il titolo
   }
   public void setTitle(String title){
      this.name = title;
   }

   public void setDuration(int duration){
      this.duration = duration;
   }
   public double getDuration(){
      return duration;
   }
}
