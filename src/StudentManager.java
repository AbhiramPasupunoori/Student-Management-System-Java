import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    public void viewStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public Student searchStudent(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(int id) {
        Student s = searchStudent(id);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }

    public boolean updateStudent(int id, String name, String email, int age, String course) {
        Student s = searchStudent(id);
        if (s != null) {
            s.setName(name);
            s.setEmail(email);
            s.setAge(age);
            s.setCourse(course);
            return true;
        }
        return false;
    }
    
}
