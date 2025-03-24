public class PremiumCutomer extends Customer {
    private int percentage = 5;

    public PremiumCutomer(int percentage) {
        this.percentage = percentage;
    }
    public int getPercentage(){
        return this.percentage;
    }

    public PremiumCutomer(String name, String idNumber, String city, String phoneNumber) {
        super(name, idNumber, city, phoneNumber);
    }

    @Override
    public String toString() {
        return  getName() +"      "+ getCustomerNumber()+"        "+getIdNumber()+"    "+getCity()+"   "+getPhoneNumber();
    }
}
