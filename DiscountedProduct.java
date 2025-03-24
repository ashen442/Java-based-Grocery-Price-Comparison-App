public class DiscountedProduct extends Product {
    private int discountPercentage;

    public DiscountedProduct(String name, String category, int price, int discountPercentage) {
        super(name, category, price);
        this.discountPercentage = discountPercentage;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double getPrice() {
        return super.getPrice() - (super.getPrice() * discountPercentage / 100);
    }
}


