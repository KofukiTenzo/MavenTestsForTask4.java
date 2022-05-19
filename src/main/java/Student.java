public class Student extends Person {
    private String group;
    private byte[] marks;

    public Student() {
    }

    public Student(String group, byte[] marks) {
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

    public static String getBetterStudentByAverage(Student student1, Student student2, Student student3) {
        float marksAverage = Math.max(Math.max(student1.getMarksAverage(),student2.getMarksAverage()), student3.getMarksAverage());
        if (marksAverage == student1.getMarksAverage()) {
            return student1.getFullName();
        } else if (marksAverage == student2.getMarksAverage()) {
            return student1.getFullName();
        } else {
            return student1.getFullName();
        }
    }

    public boolean isExcelentStudent() {
        return getMarksAverage() > 4;
    }
}
