package ua.opnu;

import java.util.ArrayList;

public class Student {
    private String name;
    private int year;
    private ArrayList<String> courses;

    public Student(String name, int year) {
        this.name = name;
        if (year >= 1 && year <= 4) {
            this.year = year;
        } else {
            this.year = 1;
        }
        this.courses = new ArrayList<>();
    }

    public void addCourse(String courseName) {
        if (courseName != null && !courseName.isEmpty()) {
            courses.add(courseName);
        }
    }

    public void dropAll() {
        courses.clear();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public int getTuition() {
        return year * 20000;
    }

    public static void main(String[] args) {
        Student student = new Student("Alice", 2);

        student.addCourse("Mathematics");
        student.addCourse("Physics");
        student.addCourse("Computer Science");

        System.out.println(student.getName() + ": number of courses - " + student.getCourseCount());
        System.out.println(student.getName() + ": year of study - " + student.getYear());
        System.out.println(student.getName() + ": tuition paid - " + student.getTuition());
    }
}