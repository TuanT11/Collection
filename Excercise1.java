import java.util.ArrayList;
import java.util.List;

class StudentManager{
    private List<String> listStudent = new ArrayList<>();
    public void addStudent(String student){
        this.listStudent.add(student);
    }
    public void removeStuent(String student){
        this.listStudent.remove(student);
    }
    public boolean checkAttend(String name){
        return this.listStudent.contains(name);
    }
    public void displayAll(){
        System.out.println("Danh sách sinh viên. ");
        for(var x : this.listStudent){
            System.out.println(x);
        }
    }
}

public class Excercise1{
    public static void main(String[] args){
        StudentManager st = new StudentManager();
        st.addStudent("Nguyen Van A");
        st.addStudent("Nguyen Van B");
        st.addStudent("Nguyen Van C");
        st.addStudent("Nguyen Van D");
        st.removeStuent("Nguyen Van A"); //=> Xóa hay thêm một cái gì đó thì sẽ mất O(n)
        st.displayAll();
    }
}
