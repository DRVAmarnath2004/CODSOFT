import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity;
    List<Student> registeredStudents = new ArrayList<>();

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    boolean registerStudent(Student student) {
        if (registeredStudents.size() < capacity) {
            registeredStudents.add(student);
            return true;
        }
        return false;
    }

    boolean removeStudent(Student student) {
        return registeredStudents.remove(student);
    }

    void displayCourse() {
        System.out.println("Code: " + code + ", Title: " + title + ", Capacity: " + capacity + ", Schedule: " + schedule);
    }
}

class Student {
    String id, name;
    List<Course> enrolledCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }

    boolean registerCourse(Course course) {
        if (course.registerStudent(this)) {
            enrolledCourses.add(course);
            return true;
        }
        return false;
    }

    boolean dropCourse(Course course) {
        if (course.removeStudent(this)) {
            enrolledCourses.remove(course);
            return true;
        }
        return false;
    }

    void displayEnrolledCourses() {
        System.out.println("Enrolled Courses for " + name + " (" + id + "):");
        for (Course course : enrolledCourses) {
            course.displayCourse();
        }
    }
}

public class CourseRegistrationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        
        courses.add(new Course("CS2032", "Java Programming", "Introduction to Javaprogramming", 3, "Mon-Wed 10AM"));
        courses.add(new Course("CS3034", "Data Structures", "Fundamentals of DataStructures1", 2, "Tue-Thu 2PM"));
        
        students.add(new Student("22BCE8654", "AMARNATH"));
        students.add(new Student("22BCE20047", "SANDEEP"));
        
        while (true) {
            System.out.println("1. List Courses 2. Register Course 3. Drop Course 4. View Enrolled Courses 5. Exit");
            int choice = scanner.nextInt();
            if (choice == 1) {
                for (Course c : courses) c.displayCourse();
            } else if (choice == 2) {
                System.out.println("Enter Student ID:");
                String studentId = scanner.next();
                System.out.println("Enter Course Code:");
                String courseCode = scanner.next();
                Student student = students.stream().filter(s -> s.id.equals(studentId)).findFirst().orElse(null);
                Course course = courses.stream().filter(c -> c.code.equals(courseCode)).findFirst().orElse(null);
                if (student != null && course != null && student.registerCourse(course)) {
                    System.out.println("Registered successfully");
                } else {
                    System.out.println("Registration failed");
                }
            } else if (choice == 3) {
                System.out.println("Enter Student ID:");
                String studentId = scanner.next();
                System.out.println("Enter Course Code:");
                String courseCode = scanner.next();
                Student student = students.stream().filter(s -> s.id.equals(studentId)).findFirst().orElse(null);
                Course course = courses.stream().filter(c -> c.code.equals(courseCode)).findFirst().orElse(null);
                if (student != null && course != null && student.dropCourse(course)) {
                    System.out.println("Course dropped successfully");
                } else {
                    System.out.println("Failed to drop course");
                }
            } else if (choice == 4) {
                System.out.println("Enter Student ID:");
                String studentId = scanner.next();
                Student student = students.stream().filter(s -> s.id.equals(studentId)).findFirst().orElse(null);
                if (student != null) student.displayEnrolledCourses();
                else System.out.println("Student not found");
            } else {
                break;
            }
        }
        scanner.close();
    }
}
