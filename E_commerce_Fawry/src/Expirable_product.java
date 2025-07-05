import java.time.LocalDate;
import java.util.Locale;

public class Expirable_product extends Product implements Expirable
{
    private final LocalDate expiration_date ;
    Expirable_product(String name , double price , int quantity ,LocalDate expiration_date)
    {
        super( name ,  price ,  quantity);
        this.expiration_date = expiration_date ;
    }

    public LocalDate get_expire_date() {
        return expiration_date;
    }

    @Override
    public void view_product()
    {
        System.out.println("product name : " + this.get_name() + "  price : " + this.getPrice() + " expire date : " + this.expiration_date  );
        if (this.getQuantity() == 0)
        {
            System.out.println(" the product is not avilable ") ;
        }
        System.out.println("#################################");

    }
}
