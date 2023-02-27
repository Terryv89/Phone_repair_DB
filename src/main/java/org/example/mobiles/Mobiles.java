package org.example.mobiles;

public class Mobiles {

    public int mobile_id;
    public String brand_name;

    public String model_name;

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
}
