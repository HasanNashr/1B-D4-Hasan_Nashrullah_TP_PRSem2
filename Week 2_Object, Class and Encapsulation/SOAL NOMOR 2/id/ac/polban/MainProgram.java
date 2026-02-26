package id.ac.polban;

import id.ac.polban.employee.service.EmployeeService;

import id.ac.polban.employee.model.Department;
import id.ac.polban.employee.model.Employee;
import id.ac.polban.employee.model.EmploymentType;
    
public class MainProgram {  
    public static void main(String[] args) {
        // Tambahkan Department dari method Department.java
        Department ahliIT = new Department("Bidang Informatika");
        Department ahliHumas = new Department("Hubungan Masyarakat");

        // Tipe Employmentnya
        EmploymentType tetap = new EmploymentType("Hasan Nashrullah");
        EmploymentType magang = new EmploymentType("Anak magang 123");

        // Atribut yang dimiliki sang Employee
        Employee pegawai1 = new Employee(101, "Hasan Nashrullah", ahliIT, tetap, 500000000);
        Employee pegawai2 = new Employee(102, "Anak Magang 123", ahliHumas, magang, 50000000);

        // Method dan Perilaku pada masing-masing pegawai
        EmployeeService service = new EmployeeService ();
        service.addEmployee(pegawai1);
        service.addEmployee(pegawai2);

        // Akses pegawai_1        
        Employee dataHasan = service.getEmployee(101);
        System.out.println("\nID: " + dataHasan.getId());
        System.out.println ("\nNama: " + dataHasan.getName());
        System.out.printf("\nGaji: %.2f", dataHasan.getSalary());

        //Hasan mendapat bonus gaji!
        service.raiseSalary(101, 10.0);
        System.out.println("\nNaik!");
        System.out.printf("\nGaji: %.2f", service.getEmployee(101).getSalary());

        // Akses Pegawai_2
        Employee anakMagang = service.getEmployee(102);
        System.out.println("\nID: " + anakMagang.getId());
        System.out.println("\nNama: " + anakMagang.getName());
        System.out.printf("\nGaji: %.2f", anakMagang.getSalary());

        //Anak magang mendapat bonus gaji!
        service.raiseSalary(102, 15.0);
        System.out.println("\nNaik!");
        System.out.printf("\nGaji: %.2f", service.getEmployee(102).getSalary());

    }
}