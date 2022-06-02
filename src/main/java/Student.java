public class Student extends Person {
    private String group;
    private byte[] marks;
    private String studentName;
    private static Person student;

    public Student() {
    }

    public Student(String firstName, String name, String lastName, byte age, String group, byte[] marks) throws Exception {
        student = new Person(firstName,  name, lastName, age);
        this.studentName = student.getFullName();
        this.group = group;
        this.marks = marks;
    }

    public float getMarksAverage() {
        byte average = 0;
        int i;
        for (i = 0; i < marks.length; i++) {
            average += marks[i];
        }
        return (float) average / i;
    }

    public static String getBetterStudentByAverage(Student student1, Student student2, Student student3) throws Exception {
        float marksAverage = Math.max(Math.max(student1.getMarksAverage(),student2.getMarksAverage()), student3.getMarksAverage());
        if (marksAverage == student1.getMarksAverage()) {
            return student1.studentName;
        } else if (marksAverage == student2.getMarksAverage()) {
            return student2.studentName;
        } else {
            return student3.studentName;
        }
    }

    public boolean isExcelentStudent() {
        return getMarksAverage() > 4;
    }
}
