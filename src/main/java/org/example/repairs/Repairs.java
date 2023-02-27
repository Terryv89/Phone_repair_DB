package org.example.repairs;

import java.util.Date;

public class Repairs {

    public int repair_id;
    public int repair_cost; // cost för företaget, timmar, anställd, delar
    public Date repair_start;
    public Date repair_finished;
    public int customer_id;
    public int mobile_id;

    public Repairs(int repair_id, int repair_cost, Date repair_start,
                   Date repair_finished, int customer_id, int mobile_id) {
        this.repair_id = repair_id;
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
}
