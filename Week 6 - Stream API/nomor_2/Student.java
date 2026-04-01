public class Student {
    protected Integer id;
    protected String nama;

    public Student (Integer id, String name){
        this.id = id;
        this.nama = name;
    }

    public String getName (){
        return this.nama;
    }

    public Integer getId (){
        return this.id;
    }

    public void setName (String nama){
        this.nama = nama;
    }

    public void setName (Integer id){
        this.id = id;
    }

    @Override

    public String toString(){
        return "Student{" + "id='" + id + '\'' + ", name=" + nama + '}';
    }
}
