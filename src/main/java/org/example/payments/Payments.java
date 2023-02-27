package org.example.payments;

public class Payments {

    public int payment_id;
    public int amount_due; // hur mkt som ska betalas
    public String payment_method;
    public int payment_date;
    public int repair_id;

    public Payments(int payment_id, int amount_due,
                    String payment_method, int payment_date,
                    int repair_id) {
        this.payment_id = payment_id;
        this.amount_due = amount_due;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.repair_id = repair_id;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "payment_id=" + payment_id +
                ", amount_due=" + amount_due +
                ", payment_method='" + payment_method + '\'' +
                ", payment_date=" + payment_date +
                ", repair_id=" + repair_id +
                '}';
    }
}
