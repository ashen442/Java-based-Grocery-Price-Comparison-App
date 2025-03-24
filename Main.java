import javax.lang.model.element.Name;
import javax.xml.namespace.QName;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        // Create stores
        Store store1 = new Store("Store 1");
        Store store2 = new Store("Store 2");
        Store store3 = new Store("Store 3");


        // Add products to stores
        //store1.addProduct(new Product("Apple", "Fruit", 0.75));
        //store1.addProduct(new Product("Banana", "Fruit", 0.60));
        store1.addProduct(new DiscountedProduct("Apple", "Fruit", 75, 10));
        store1.addProduct(new DiscountedProduct("Banana", "Fruit", 60, 5));
        store1.addProduct(new Product("Carrot", "Vegetable", 125));
        store1.addProduct(new Product("Broccoli", "Vegetable", 250));
        store1.addProduct(new Product("Chicken", "Meat", 475));
        store1.addProduct(new Product("Beef", "Meat", 550));

        store2.addProduct(new Product("Apple", "Fruit", 65));
        store2.addProduct(new Product("Banana", "Fruit", 75));
        store2.addProduct(new Product("Carrot", "Vegetable", 100));
        store2.addProduct(new Product("Broccoli", "Vegetable", 225));
        store2.addProduct(new Product("Chicken", "Meat", 450));
        store2.addProduct(new Product("Beef", "Meat", 500));

        store3.addProduct(new Product("Apple", "Fruit", 80));
        store3.addProduct(new Product("Banana", "Fruit", 70));
        store3.addProduct(new Product("Carrot", "Vegetable", 150));
        store3.addProduct(new Product("Broccoli", "Vegetable", 275));
        store3.addProduct(new Product("Chicken", "Meat", 500));
        store3.addProduct(new Product("Beef", "Meat", 575));

        ArrayList<NormalCustomer> normalCustomers = new ArrayList<>();
        ArrayList<PremiumCutomer> premiumCutomers = new ArrayList<>();
        int normalcustomerCount = 0;
        int premiumCustomerCount = 0;
        Scanner input = new Scanner(System.in);
        int response;
        String password = "admin";
        try {
            do {
                System.out.println("----------------Welcome To Price Comparison App-------------------");
                System.out.println("(1) New Customer\n(2) Existing Customer\n(3) Show All Customers Details\n(4) Show All Shopping Items");
                System.out.print("Select: ");
                response = input.nextInt();
                switch (response) {
                    case 1: {
                        System.out.println("(1) Normal Customer\n(2) Premium Customer");
                        int customerSelection = input.nextInt();
                        input.nextLine();
                        if (customerSelection == 1) {
                            System.out.print("Enter your name: ");
                            String name = input.nextLine();
                            System.out.print("Enter your ID Number: ");
                            String idNumber = input.nextLine();
                            System.out.print("Enter your City: ");
                            String city = input.nextLine();
                            System.out.print("Enter your Phone Number: ");
                            String phoneNumber = input.nextLine();
                            NormalCustomer normalCustomer = new NormalCustomer(name, idNumber, city, phoneNumber);
                            normalCustomers.add(normalCustomer);
                            normalcustomerCount++;
                            System.out.println("Your Customer Number: " + normalCustomer.getCustomerNumber());
                            System.out.print("Enter the Customer Number: ");
                            int customerNumberInput = input.nextInt();
                            input.nextLine();
                            for (NormalCustomer normalCustomer1 : normalCustomers) {
                                if (customerNumberInput == normalCustomer1.getCustomerNumber()) {
                                    // Find cheapest store for a given grocery item
                                    System.out.print("Enter the GroceryItem:");

                                    String groceryItem = input.nextLine();
                                    // String groceryItem = "Apple";
                                    List<Product> products = new ArrayList<>();
                                    products.addAll(store1.getProductsByGroceryItem(groceryItem));
                                    products.addAll(store2.getProductsByGroceryItem(groceryItem));
                                    products.addAll(store3.getProductsByGroceryItem(groceryItem));
                                    if (products.isEmpty()) {
                                        System.out.println("Grocery item not found.");
                                    } else {
                                        Product cheapestProduct = products.get(0);
                                        Store cheapestStore = store1;
                                        for (Product product : products) {
                                            if (product.getPrice() < cheapestProduct.getPrice()) {
                                                cheapestProduct = product;
                                                if (store1.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store1;
                                                } else if (store2.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store2;
                                                } else if (store3.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store3;
                                                }
                                            }

                                        }
                                        // System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + store1.getProductPrice(groceryItem) * normalCustomers.get(0).getPercentage());
                                        System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + (store1.getProductPrice(groceryItem) - (store1.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));
                                        System.out.println("The Store 2" + " " + groceryItem + " price is" + " " + (store2.getProductPrice(groceryItem) - (store2.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));
                                        System.out.println("The Store 3" + " " + groceryItem + " price is" + " " + (store3.getProductPrice(groceryItem) - (store3.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));

                                        System.out.println("The cheapest store for " + groceryItem + " is " + cheapestStore.getName() + " at " + (cheapestProduct.getPrice()-(cheapestProduct.getPrice()*normalCustomers.get(0).getPercentage()/100)));
                                    }
                                }
                            }
                        }
                        if (customerSelection == 2) {
                            System.out.print("Enter your name: ");
                            String name = input.nextLine();
                            System.out.print("Enter your ID Number: ");
                            String idNumber = input.nextLine();
                            System.out.print("Enter your City: ");
                            String city = input.nextLine();
                            System.out.print("Enter your Phone Number: ");
                            String phoneNumber = input.nextLine();
                            PremiumCutomer premiumCutomer = new PremiumCutomer(name, idNumber, city, phoneNumber);
                            premiumCutomers.add(premiumCutomer);
                            premiumCustomerCount++;
                            System.out.println("Your Customer Number: " + premiumCutomer.getCustomerNumber());
                            System.out.print("Enter the Customer Number: ");
                            int customerNumberInput = input.nextInt();
                            input.nextLine();
                            for (PremiumCutomer premiumCutomer1 : premiumCutomers) {
                                if (customerNumberInput == premiumCutomer1.getCustomerNumber()) {
                                    // Find cheapest store for a given grocery item
                                    System.out.print("Enter the GroceryItem:");

                                    String groceryItem = input.nextLine();
                                    // String groceryItem = "Apple";
                                    List<Product> products = new ArrayList<>();
                                    products.addAll(store1.getProductsByGroceryItem(groceryItem));
                                    products.addAll(store2.getProductsByGroceryItem(groceryItem));
                                    products.addAll(store3.getProductsByGroceryItem(groceryItem));
                                    if (products.isEmpty()) {
                                        System.out.println("Grocery item not found.");
                                    } else {
                                        Product cheapestProduct = products.get(0);
                                        Store cheapestStore = store1;
                                        for (Product product : products) {
                                            if (product.getPrice() < cheapestProduct.getPrice()) {
                                                cheapestProduct = product;
                                                if (store1.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store1;
                                                } else if (store2.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store2;
                                                } else if (store3.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                    cheapestStore = store3;
                                                }
                                            }

                                        }
                                        // System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + store1.getProductPrice(groceryItem) * normalCustomers.get(0).getPercentage());
                                        System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + (store1.getProductPrice(groceryItem) - (store1.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));
                                        System.out.println("The Store 2" + " " + groceryItem + " price is" + " " + (store2.getProductPrice(groceryItem) - (store2.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));
                                        System.out.println("The Store 3" + " " + groceryItem + " price is" + " " + (store3.getProductPrice(groceryItem) - (store3.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));

                                        System.out.println("The cheapest store for " + groceryItem + " is " + cheapestStore.getName() + " at " + (cheapestProduct.getPrice()-(cheapestProduct.getPrice()*premiumCutomers.get(0).getPercentage()/100)));
                                    }
                                }
                            }
                        }
                        break;
                    }
                    case 2: {
                        System.out.print("Enter the Customer Number: ");
                        int customerNumberInput = input.nextInt();
                        input.nextLine();
                        for (NormalCustomer normalCustomer : normalCustomers) {
                            if (customerNumberInput == normalCustomer.getCustomerNumber()) {
                                // Find cheapest store for a given grocery item
                                System.out.print("Enter the GroceryItem:");

                                String groceryItem = input.nextLine();
                                // String groceryItem = "Apple";
                                List<Product> products = new ArrayList<>();
                                products.addAll(store1.getProductsByGroceryItem(groceryItem));
                                products.addAll(store2.getProductsByGroceryItem(groceryItem));
                                products.addAll(store3.getProductsByGroceryItem(groceryItem));
                                if (products.isEmpty()) {
                                    System.out.println("Grocery item not found.");
                                } else {
                                    Product cheapestProduct = products.get(0);
                                    Store cheapestStore = store1;
                                    for (Product product : products) {
                                        if (product.getPrice() < cheapestProduct.getPrice()) {
                                            cheapestProduct = product;
                                            if (store1.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store1;
                                            } else if (store2.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store2;
                                            } else if (store3.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store3;
                                            }
                                        }

                                    }
                                    // System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + store1.getProductPrice(groceryItem) * normalCustomers.get(0).getPercentage());
                                    System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + (store1.getProductPrice(groceryItem) - (store1.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));
                                    System.out.println("The Store 2" + " " + groceryItem + " price is" + " " +(store2.getProductPrice(groceryItem) - (store2.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));
                                    System.out.println("The Store 3" + " " + groceryItem + " price is" + " " +(store3.getProductPrice(groceryItem) - (store3.getProductPrice(groceryItem)*normalCustomers.get(0).getPercentage()/100)));

                                    System.out.println("The cheapest store for " + groceryItem + " is " + cheapestStore.getName() + " at " + (cheapestProduct.getPrice()-(cheapestProduct.getPrice()*normalCustomers.get(0).getPercentage()/100)));
                                }
                            }
                        }
                        for (PremiumCutomer premiumCutomer : premiumCutomers) {
                            if (customerNumberInput == premiumCutomer.getCustomerNumber()) {
                                // Find cheapest store for a given grocery item
                                System.out.print("Enter the GroceryItem:");

                                String groceryItem = input.nextLine();
                                // String groceryItem = "Apple";
                                List<Product> products = new ArrayList<>();
                                products.addAll(store1.getProductsByGroceryItem(groceryItem));
                                products.addAll(store2.getProductsByGroceryItem(groceryItem));
                                products.addAll(store3.getProductsByGroceryItem(groceryItem));
                                if (products.isEmpty()) {
                                    System.out.println("Grocery item not found.");
                                } else {
                                    Product cheapestProduct = products.get(0);
                                    Store cheapestStore = store1;
                                    for (Product product : products) {
                                        if (product.getPrice() < cheapestProduct.getPrice()) {
                                            cheapestProduct = product;
                                            if (store1.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store1;
                                            } else if (store2.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store2;
                                            } else if (store3.getProductsByGroceryItem(groceryItem).contains(product)) {
                                                cheapestStore = store3;
                                            }
                                        }

                                    }
                                    // System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + store1.getProductPrice(groceryItem) * normalCustomers.get(0).getPercentage());
                                    System.out.println("The Store 1" + " " + groceryItem + " price is" + " " + (store1.getProductPrice(groceryItem) - (store1.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));
                                    System.out.println("The Store 2" + " " + groceryItem + " price is" + " " + (store2.getProductPrice(groceryItem) - (store2.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));
                                    System.out.println("The Store 3" + " " + groceryItem + " price is" + " " + (store3.getProductPrice(groceryItem) - (store3.getProductPrice(groceryItem)*premiumCutomers.get(0).getPercentage()/100)));

                                    System.out.println("The cheapest store for " + groceryItem + " is " + cheapestStore.getName() + " at " +(cheapestProduct.getPrice()-(cheapestProduct.getPrice()*premiumCutomers.get(0).getPercentage()/100)));
                                }
                            }
                        }
                        break;
                    }
                    case 3: {
                        input.nextLine();
                        System.out.print("Enter your password: ");
                        String myPassword = input.nextLine();
                        if (myPassword.equals(password)) {
                            System.out.println("Normal Customer: ");
                            for (NormalCustomer normalCustomer : normalCustomers) {
                                System.out.println("Name        Customer Number         ID NUmber             City         Phone Number");
                                System.out.println(normalCustomer);
                            }
                            System.out.println("Premium Customer: ");
                            for (PremiumCutomer premiumCutomer : premiumCutomers) {
                                System.out.println("Name        Customer Number         ID NUmber             City         Phone Number");
                                System.out.println(premiumCutomer);
                            }
                        } else System.out.println("Your password is incorrect!");
                        break;
                    }
                    case 4: {
                        System.out.println("Store 1");
                        System.out.println();
                        for (int i = 0; i < store1.getProducts().size(); i++) {
                            System.out.println(store1.getProducts().get(i).getName());
                        }
                        System.out.println();
                        System.out.println("Store 2");
                        System.out.println();
                        for (int i = 0; i < store2.getProducts().size(); i++) {
                            System.out.println(store2.getProducts().get(i).getName());
                        }
                        System.out.println();
                        System.out.println("Store 3");
                        System.out.println();
                        for (int i = 0; i < store2.getProducts().size(); i++) {
                            System.out.println(store3.getProducts().get(i).getName());
                        }
                    }
                    break;

                }

            } while (response != 0);

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
