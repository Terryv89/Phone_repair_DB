package org.example.payments;

public class Payments {

    public int payment_id;
    public int amount_due; // hur mkt som ska betalas
    public String payment_method;
    public String payment_date;
    public int repair_id;

    public Payments(int payment_id, int amount_due,
                    String payment_method, String payment_date,
                    int repair_id) {
        this.payment_id = payment_id;
        this.amount_due = amount_due;
        this.payment_method = payment_method;
        this.payment_date = payment_date;
        this.repair_id = repair_id;
    }

    public Payments(int amount_due, String payment_method, String payment_date, int repair_id) {
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

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getAmount_due() {
        return amount_due;
    }

    public void setAmount_due(int amount_due) {
        this.amount_due = amount_due;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }

    public int getRepair_id() {
        return repair_id;
    }

    public void setRepair_id(int repair_id) {
        this.repair_id = repair_id;
    }
}
