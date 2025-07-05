import java.util.ArrayList;
import java.util.List;

public class Cart
{
   private List<Cart_item> cart_items = new ArrayList<Cart_item>();
    public void Add_to_cart (Product p , int quantity)
    {
        if (quantity > p.getQuantity()||p.getQuantity()== 0)
        {
            throw  new IllegalArgumentException("the product is out of stock") ;
        }
        cart_items.add(new Cart_item(p, quantity)) ;
        for (Cart_item i: cart_items)
        {
            System.out.println(i.getQuantity());

        }
    }
    public boolean empty_card ()
    {
        return cart_items.isEmpty();
    }

    public List<Cart_item> getCart_items() {
        return cart_items;
    }
    public double get_cart_price ()
    {
        double price = 0 ;
        for (Cart_item i: cart_items)
        {
            price += i.getTotalPrice() ;

        }
        return  price ;
    }
}
