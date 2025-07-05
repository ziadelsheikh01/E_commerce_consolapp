import java.time.LocalDate;

public class Epirable_Shippable_product extends  Product implements  Expirable
{
    private final LocalDate expire_date;
    private final double weight ;
    Epirable_Shippable_product (String name , double price , int quantity, LocalDate expire_date , double weight)
    {
        super(name, price, quantity);
        this.expire_date = expire_date ;
        this.weight = weight ;
    }

    @Override
    public double get_weight() {
        return this.weight;
    }

    @Override
    public LocalDate get_expire_date() {
        return this.expire_date ;
    }
    public void view_product()
    {
        System.out.println("product name : " + this.get_name() + "  price : " + this.getPrice() + " expire date : " + this.expire_date + "Weight : "  + this.weight );
        if (this.getQuantity() == 0)
        {
            System.out.println(" the product is out of stock ") ;
        }
        System.out.println("#################################");

    }
}
