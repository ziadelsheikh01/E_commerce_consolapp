import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {


    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        customer_Service customer_service = new customer_Service();


        // adding product
        products.add(new Epirable_Shippable_product("Cheese", 30.0, 10, LocalDate.of(2025, 7, 10), 0.5));
        products.add(new Shippable_product("TV", 5000.0, 5, 12.0));
        products.add(new Normal_product("Scratch Card", 10.0, 50));
        products.add(   new Expirable_product("Biscuits", 15.0, 20, LocalDate.of(2025, 7, 1)));
        System.out.println("Welcome to E_commerce App : ");
        System.out.println("###########################");
        while (true) {

                if (Controller.current_user == null)
                {
                    System.out.println("1- Signup \n2- Login ");
                    int choice = input.nextInt();
                    if (choice == 1) {
                        System.out.println("name : ");
                        String name = input.next();
                        System.out.println("Password : ");
                        String password = input.next();
                        System.out.println("Email : ");
                        String Email = input.next();
                        System.out.println("Address : ");
                        String address = input.next();
                        customer_service.sign_up(name, password, Email, address);
                    }

                    else if (choice == 2)
                    {
                        System.out.println("name : ");
                        String name = input.next();
                        System.out.println("Password : ");
                        String password = input.next();

                        if(customer_service.login(name, password) == false)
                            continue;

                    }
                    else
                    {
                        System.out.println("incorrect option");
                        continue;
                    }

                }

            else
            {

                System.out.println("1- view products \n2- add to cart \n3- checkout \n4- logout");
                int choice = input.nextInt();
                if (choice == 1)
                {
                        if (Controller.current_user == null) {
                            System.out.println("please login or signup to continue ");
                            continue;
                        } else {
                            for (int i = 0; i < products.size(); i++) {
                                System.out.print("(" + i + ")");
                                products.get(i).view_product();
                            }
                        }
                    } else if (choice == 2) {
                        System.out.println(" write the number of the product you want to add : ");
                        int num = input.nextInt();
                        System.out.println("enter the quantity you need : ");
                        int quantity = input.nextInt();
                        customer_service.customers.get(Controller.current_user.getId()).getCart().Add_to_cart(products.get(num), quantity);

                        System.out.println("the product added to item successfully");
                        continue;
                    } else if (choice == 3) {
                    try{
                            customer_service.Checkout();
                    }
                    catch (IllegalArgumentException ex)
                    {
                        System.out.println("your cart is empty");
                        continue;
                    }
                        System.out.print ("press (y/n) if you want to place order or not :" ) ;
                        char b = input.next().charAt(0);

                        customer_service.place_order(b);
                    }
                      else if (choice == 4)
                    {
                        Controller.current_user = null ;
                        continue;
                    }
                      else {
                          System.out.println("invalid option");
                          continue;
                }
                    }

            }

    }
}