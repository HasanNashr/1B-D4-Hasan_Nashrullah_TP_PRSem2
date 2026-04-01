public class Employee {
    protected String employeeName;
    protected Integer payAmount;

    public Employee(String name, Integer pay) {
        this.employeeName = name;
        this.payAmount = pay;
    }

    public String getName() {
        return this.employeeName;
    }

    public double getSalary() {
        return this.payAmount;
    }

    public void setName(String name) {
        this.employeeName = name;
    }

    public void setSalary(Integer pay) {
        this.payAmount = pay;
    }

    @Override
    public String toString() {
        return "Employee{" + "name='" + employeeName + '\'' + ", salary=" + payAmount + '}';
    }

}
