import java.util.EmptyStackException;
import java.util.List;

public  class Customer
{
   private int id ;
   private  double balance = 10000 ;
    private String username ,  password , email ,address ;
   private Cart cart = new Cart();
    Customer (int id ,String username , String password , String email , String Address)
    {
        this.id = id ;
        this.username = username ;
        this.password = password ;
        this.email = email ;
        this.address = Address ;
    }
    public int getId()
    {
        return  id ;
    }
    public String getUsername()
    {
        return  username ;
    }
    public String getPassword()
    {
        return  password ;
    }
    public String getEmail()
    {
        return  email ;
    }
    public String getAddress()
    {
        return  address ;
    }
    public Cart getCart()
    {
        return  cart ;
    }
    public  double getBalance ()
    {
        return  balance ;
    }
    public void update_balance ( double balance)
    {
        this.balance = balance;
    }









}