
    public abstract class Customer {
        private String name;
        private String idNumber;
        private String city;
        private String phoneNumber;
        private static int nextCustomerNumber = 2000;
        private  int customerNumber;

        public Customer() {
        }

        public Customer(String name, String idNumber, String city, String phoneNumber) {
            this.name = name;
            this.idNumber = idNumber;
            this.city = city;
            this.phoneNumber = phoneNumber;
            customerNumber = nextCustomerNumber;
            nextCustomerNumber+=10;
        }

        public String getName() {
            return name;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public String getCity() {
            return city;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public int getCustomerNumber() {
            return this.customerNumber;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", idNumber='" + idNumber + '\'' +
                    ", city='" + city + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    '}';
        }
    }


