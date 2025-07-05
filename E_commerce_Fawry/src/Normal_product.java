public class Normal_product extends  Product{
    Normal_product(String name , double price , int quantity)
    {
        super(name, price, quantity);
    }
    public void view_product()
    {
        System.out.println("product name : " + this.get_name() + "  price : " + this.getPrice()   );
        if (this.getQuantity() == 0)
        {
            System.out.println(" the product is not avilable ") ;
        }
        System.out.println("#################################");

    }
}
