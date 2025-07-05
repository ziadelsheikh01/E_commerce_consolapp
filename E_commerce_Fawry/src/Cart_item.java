public class Cart_item {
    Product product ;
    private int quantity ;

    Cart_item (Product product , int quantity)
    {
        this.product = product ;
        this.quantity = quantity;
    }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return product.getPrice() * quantity; }

}
