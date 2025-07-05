import java.time.LocalDate;

public class Shippable_product extends Product
{
    private final double weight;
    Shippable_product(String name , double price , int quantity , double weight)
    {
        super(name, price, quantity);
        this.weight = weight ;
    }

    @Override
    public double get_weight() {
        return this.weight;
    }

       @Override
    public void view_product()
    {
        System.out.println("product name : " + this.get_name() + "  price : " + this.getPrice() + " weight : " + this.weight  );
        if (this.getQuantity() == 0)
        {
            System.out.println(" the product is not avilable ") ;
        }
        System.out.println("#################################");
    }
}
