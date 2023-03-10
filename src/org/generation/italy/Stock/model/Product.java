package org.generation.italy.Stock.model;

public abstract class Product {
   //Tutti i prodotti hanno un peso, un costo,un nome(titolo/Marca) una categoria (categoria/Tipo)
   protected double weight, cost, originalCost; //originalCost non mi serve adesso, ma se finisse lo sconto vorremmo
                                                //poter tornare al vecchio prezzo, male che va ce lo ritroviamo
   protected final String  PASS = "4dm1n";
   private int iDNumber;
   protected String name, category;

   //costruttori
   public Product(){}
   public Product(double weight, double cost, String name, String category, int iDNumber){ //metto qua id number
      this.weight = weight;                                                //per usarlo quando chiamo il costruttore madre
      this.cost = cost;                                                    //dai figli, ma senza passarlo dall'utente
      this.name = name;                                                    //tutti in quella categorìa ne avranno uno uguale
      this.category = category;                                            //per cambiarlo dovranno mettere una "pass"
      this.originalCost = cost;
      this.iDNumber= iDNumber;
   }
   public void setIDNumber(int newId, String password){
      if(password.equals(PASS)){
         iDNumber = newId;
      }
   }

   public int getiDNumber() {
      return iDNumber;
   }

   public double getWeight(){
      return weight;
   }
   public void setWeight(double weight){
      this.weight = weight;
   }
   public double getCost() {
      return cost;
   }
   public double getOriginalCost(){ //non mi interessa fare un setter perché verrà sempre inizializato o dal costruttore
      return originalCost;          //o al momento di fare un setCost
   }
   public void setCost(double cost) {
      if (originalCost == 0.0){ //vuol dire che cost non è mai stato assegnato per questo oggetto
         originalCost = cost; //lo assegnamo adesso (potrebbe mai verificarsi che a il prezzo originale di
      }                       //un prodotto sìa 0 e poi glielo diamo un valore monetario? forse si, ma noi non glielo
      this.cost = cost;       //diremo mai al cliente, il primo valore maggiore di 0 sarà quello Originale, fidati)
   }
   public String getname(){
      return name;
   }
   public void setName(String name){
      this.name = name;
   }
   public String getCategory(){
      return category;
   }
   public void setCategory(String category){
      this.category = category;
   }

   public void discountPercent(double percentDiscount){
      cost = cost - (cost * (percentDiscount/100));
   }
   public void discountMinus(double discount){
      cost -= discount;
      if (cost < 0){
         cost = 0; //vabbeh lo sconto, madare i soldi in dietro per "venderti" qualcos no .-.
      }
   }

}
