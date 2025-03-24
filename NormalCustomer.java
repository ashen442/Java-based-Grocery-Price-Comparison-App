public class NormalCustomer extends  Customer{
    private int percentage = 2;

    public NormalCustomer(int percentage) {
        this.percentage = percentage;
    }
    public int getPercentage(){
        return this.percentage;
    }

    public NormalCustomer(String name, String idNumber, String city, String phoneNumber) {
        super(name, idNumber, city, phoneNumber);
        percentage=getPercentage();
    }




    @Override
    public String toString() {
        return  getName() +"      "+ getCustomerNumber()+"        "+getIdNumber()+"    "+getCity()+"   "+getPhoneNumber();
    }
}
