package org.example.customers;

public class Customer {

    public int customer_id;
    public String first_name;
    public String last_name;
    public int phone_number;

    public Customer(int customer_id, String first_name, String last_name, int phone_number) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }

    public Customer(String first_name,
                    String last_name, int phone_number) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", phone_number=" + phone_number +
                '}';
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(int phone_number) {
        this.phone_number = phone_number;
    }
}
