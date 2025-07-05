public abstract class Product
{
   private String name ;
    private double price;
    private   int quantity ;

    Product(String name , double price , int quantity)
    {
        this.name = name ;
        this.price = price ;
        this.quantity = quantity ;
    }

    public double get_weight() {
       return 0;
    }



    public String get_name ()
    {
        return  name ;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
    public  void reduce_quantity (int quantity)
    {
        this.quantity -= quantity ;
    }

    public abstract void view_product ();

}
