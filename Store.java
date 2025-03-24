import java.util.ArrayList;
import java.util.List;

public class Store {
    private String name;
    private List<Product> products;

    public Store(String name) {
        this.name = name;
        products = new ArrayList<>();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public String getProductList(){
        return this.name;
    }
    public List<Product> getProductsByGroceryItem(String groceryItem) {
        List<Product> matchingProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equals(groceryItem)) {
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public double getProductPrice(String groceryItem) {
        double price = Double.MAX_VALUE;
        for (Product product : products) {
            if (product.getName().equals(groceryItem) && product.getPrice() < price) {
                price = product.getPrice();
            }
        }
        return price;
    }

    public Product getProductByGroceryItem(String groceryItem) {
        Product cheapestProduct = null;
        double cheapestPrice = Double.MAX_VALUE;
        for (Product product : products) {
            if (product.getName().equals(groceryItem) && product.getPrice() < cheapestPrice) {
                cheapestProduct = product;
                cheapestPrice = product.getPrice();
            }
        }
        return cheapestProduct;
    }





}
