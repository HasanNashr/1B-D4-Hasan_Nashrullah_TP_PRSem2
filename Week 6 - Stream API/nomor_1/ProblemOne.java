import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProblemOne {
    public static void main(String[] args) {
        ArrayList<Employee> list = new ArrayList<>();

        list.add(new Employee("John", 10000));
        list.add(new Employee("Rob", 40000));
        list.add(new Employee("Bob", 70000));
        list.add(new Employee("Alice", 50000));


        // Melakukan proses filtering/sorting menggunakan Stream API
        List<Employee> sortedEmp =
                // Ubah list ke stream
                list.stream()
                        // Mengurutkan employee berdasarkan nama
                        .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                        // Mengumpulkan hasil akhir
                        .collect(Collectors.toList());

        for (Employee e : sortedEmp) {
            System.out.println(e);
        }
    }
}
