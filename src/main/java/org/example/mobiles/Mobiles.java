package org.example.mobiles;

public class Mobiles {

    public int mobile_id;
    public String brand_name;
    public String model_name;

    public Mobiles(String brand_name, String model_name) {
        this.brand_name = brand_name;
        this.model_name = model_name;
    }
    public Mobiles(int mobile_id, String brand_name, String model_name) {
        this.mobile_id = mobile_id;
        this.brand_name = brand_name;
        this.model_name = model_name;
    }



    @Override
    public String toString() {
        return "Mobiles{" +
                "mobile_id=" + mobile_id +
                ", brand_name='" + brand_name + '\'' +
                ", model_name='" + model_name + '\'' +
                '}';
    }

    public int getMobile_id() {
        return mobile_id;
    }

    public void setMobile_id(int mobile_id) {
        this.mobile_id = mobile_id;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getModel_name() {
        return model_name;
    }

    public void setModel_name(String model_name) {
        this.model_name = model_name;
    }
}
