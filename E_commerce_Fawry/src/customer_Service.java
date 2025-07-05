import java.util.ArrayList;
import java.util.List;

public class customer_Service
{
    List<Customer> customers = new ArrayList<>();
    public  boolean login (String username , String password)
    {
        for (Customer i : customers)
        {
            if (i.getUsername().equals(username) && i.getPassword().equals(password))
            {
                System.out.println("logged in successfully");
                Controller.current_user = i;
                return  true ;
            }

        }
        System.out.println("incorrect username or password ");
        return  false ;
    }
    public void sign_up (String username ,String password , String email , String address )
    {
        for (Customer i: customers)
        {
            if (i.getUsername().equals(username)|| i.getPassword().equals(password))
            {
                throw  new ArrayStoreException("the user name or password is already exist") ;
            }

        }
        customers.add(new Customer(Controller.user_count , username , password ,email ,address));
        Controller.current_user =customers.get(Controller.user_count);
        Controller.user_count++;
        System.out.println("sign up completed successfully");

    }
    public  void Checkout () throws  IllegalArgumentException
    {
        if (Controller.current_user.getCart().empty_card()==true)
        {
            throw  new IllegalArgumentException("your cart is empty ") ;
        }
        System.out.println("** Shippment Notice ** "  );
        for (Cart_item i: customers.get(Controller.current_user.getId()).getCart().getCart_items())
        {
            if (i.product instanceof Expirable_product || i.product instanceof Epirable_Shippable_product)
            System.out.println(i.getQuantity() + "X  " + i.product.get_name() +"  " +i.product.get_weight()+"g");
        }
        System.out.println("** Checkout receipt ** ");
        for (Cart_item i: customers.get(Controller.current_user.getId()).getCart().getCart_items())
        {
            System.out.println(i.getQuantity() + "X  " + i.product.get_name() +"  " +(i.product.getPrice()*i.getQuantity()));
        }
        System.out.println("----------------------");
        System.out.println("Subtotal : " + customers.get(Controller.current_user.getId()).getCart().get_cart_price());
        System.out.println("Shipping : " + Controller.Shipping_fees);
        System.out.println("Total    : " +(customers.get(Controller.current_user.getId()).getCart().get_cart_price()+Controller.Shipping_fees ) );


    }
    public void place_order (char b)
    {
        if (b == 'y')
        {
            if (customers.get(Controller.current_user.getId()).getCart().get_cart_price()+Controller.Shipping_fees > customers.get(Controller.current_user.getId()).getBalance())
            {
                System.out.println("your balance is insufficient");
                return;
            }
            else
            {

                System.out.println("your order is placed Successfully");
                double new_balance =  customers.get(Controller.current_user.getId()).getBalance()-(customers.get(Controller.current_user.getId()).getCart().get_cart_price()+Controller.Shipping_fees);
                customers.get(Controller.current_user.getId()).update_balance(new_balance);
                System.out.println("your balance after placing order is : " + new_balance);
            }
        }
    }

}
