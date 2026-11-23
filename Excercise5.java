import java.util.*;

class Student{
    private String id;
    private String name;
    private Double gpa;
    public Student(String id, String name, Double gpa){
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }
    public String getID(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public Double getGPA(){
        return this.gpa;
    }
    @Override
    public String toString(){
        return String.format("%s | %s       | GPA: %.2f ", this.id, this.name, this.gpa);
    }
}

class GPAcomparator implements Comparator<Student>{
    @Override
    public int compare(Student a, Student b){
        if(a.getGPA() != b.getGPA()) return Double.compare(b.getGPA(), a.getGPA());
        return a.getID().compareTo(b.getID());
    }
}
class CheckkNumber{
    public static boolean checkNumber(String value){
        try{
            Double res = Double.parseDouble(value);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}

public class Excercise5{
    private static Scanner sc = new Scanner(System.in);
    private static List<Student> list = new ArrayList<>();
    public static void main(String[] args){
        while(true){
            String name, id, gpa;
            boolean ok = true;
            System.out.println("---- BẢNG ĐIỂM SINH VIÊN ----");
            System.out.println("1. THÊM SINH VIÊN. ");
            System.out.println("2. DANH SÁCH SINH VIÊN CHƯA SẮP XẾP. ");
            System.out.println("3. DANH SÁCH SINH VIÊN ĐÃ SẮP XẾP. ");
            System.out.print("LỰA CHỌN CỦA BẠN: ");
            String option = sc.nextLine();
            switch (option){
                case "1":
                    while(true){
                        System.out.println("--- THÊM SINH VIÊN ---");
                        while(true){
                            System.out.print(" Nhập tên: ");
                            name = sc.nextLine();
                            if(!name.isEmpty()) break;
                            System.out.println(" Tên không được để trống !");
                        }
                        while(true){
                            System.out.print(" Nhập ID (SV-XX): ");
                            id = sc.nextLine();
                            if(!id.isEmpty()){
                                String res = id.substring(2);
                                if(CheckkNumber.checkNumber(res)) break;
                                System.out.println(" Mã được sử dụng không hợp lệ !");
                            }
                            else{
                                System.out.println(" Mã không được để trống !");
                            }
                        }
                        while(true){
                            System.out.print(" Nhập GPA của sinh viên: ");
                            gpa = sc.nextLine();
                            if(!gpa.isEmpty()){
                                if(CheckkNumber.checkNumber(gpa)) break;
                                System.out.println(" GPA của sinh viên không hợp lệ !");
                            }
                            else{
                                System.out.println(" GPA của sinh viên không được để trống !");
                            }
                        }
                        Student x = new Student(id, name, Double.parseDouble(gpa));
                        list.add(x);
                        String next;
                        while (true){
                            System.out.print("Lệnh continue/ exit: ");
                            next = sc.nextLine();
                            if(next.equals("continue") || next.equals("exit")){
                                if(next.equals("exit")) ok = false;
                                break;
                            }
                            System.out.println("Lệnh không hợp lệ !");
                        }
                        if(!ok) break;
                    }
                    break;
                case "2":
                    System.out.println("THÔNG TIN CHƯA SẮP XẾP :");
                    for(var x : list){
                        System.out.println(x.toString());
                    }
                    System.out.println("-------------------------------");
                    break;
                case "3":
                    System.out.println("--- THÔNG TIN SINH VIÊN ĐÃ SẮP XẾP: ");
                    Collections.sort(list, new GPAcomparator());
                    int i = 0;
                    for(var x : list){
                        System.out.println("Hạng" + ++i + "|" + x);
                    }
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ !");
            }
        }
    }
}
