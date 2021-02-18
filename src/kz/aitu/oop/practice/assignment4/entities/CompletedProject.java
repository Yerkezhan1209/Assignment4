package kz.aitu.oop.practice.assignment4.entities;

public class CompletedProject extends Project {
    private String start_date;
    private String end_date;
    private int cost;
    private boolean result;

    public CompletedProject() { };

    public CompletedProject(String name, String application, String start_date, String end_date, int cost, boolean result) {
        super(name, application);
        setStart_date(start_date);
        setEnd_date(end_date);
        setCost(cost);
        setResult(result); }

    public CompletedProject(int code, String name, String application, String start_date, String end_date, int cost, boolean result) {
        super(code, name, application);
        setStart_date(start_date);
        setEnd_date(end_date);
        setCost(cost);
        setResult(result); }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "CompletedProject{" + "code=" + code + ", name='" + name + '\'' +
                ", application='" + application + '\'' + ", start-date='" + start_date + '\'' +
                ", end_date='" + end_date + '\'' + ", cost=" + cost +
                ", result=" + (result ? "Success" : "Fail") + '}'; }
}
