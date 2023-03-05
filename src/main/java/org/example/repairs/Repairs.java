package org.example.repairs;

import java.util.Date;

public class Repairs {

    public int repair_id;
    public int repair_cost; // cost för företaget, timmar, anställd, delar
    public String repair_start;
    public String repair_finished;
    public int customer_id;
    public int mobile_id;

    public Repairs(int repair_id, int repair_cost, String repair_start,
                   String repair_finished, int customer_id, int mobile_id) {
        this.repair_id = repair_id;
        this.repair_cost = repair_cost;
        this.repair_start = repair_start;
        this.repair_finished = repair_finished;
        this.customer_id = customer_id;
        this.mobile_id = mobile_id;
    }

    public Repairs(int repair_cost, String repair_start, String repair_finished, int customer_id, int mobile_id) {
        this.repair_cost = repair_cost;
        this.repair_start = repair_start;
        this.repair_finished = repair_finished;
        this.customer_id = customer_id;
        this.mobile_id = mobile_id;
    }

    @Override
    public String toString() {
        return "Repairs{" +
                "repair_id=" + repair_id +
                ", repair_cost=" + repair_cost +
                ", repair_start=" + repair_start +
                ", repair_finished=" + repair_finished +
                ", customer_id=" + customer_id +
                ", mobile_id=" + mobile_id +
                '}';
    }

    public int getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(int repair_id) {
        this.repair_id = repair_id;
    }

    public int getRepair_cost() {
        return repair_cost;
    }

    public void setRepair_cost(int repair_cost) {
        this.repair_cost = repair_cost;
    }

    public String getRepair_start() {
        return repair_start;
    }

    public void setRepair_start(String repair_start) {
        this.repair_start = repair_start;
    }

    public String getRepair_finished() {
        return repair_finished;
    }

    public void setRepair_finished(String repair_finished) {
        this.repair_finished = repair_finished;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getMobile_id() {
        return mobile_id;
    }

    public void setMobile_id(int mobile_id) {
        this.mobile_id = mobile_id;
    }
}
