public class Main {

    public static void main(String[] args) throws Exception {
//        Person person = new Person("", "Ruslan", "Kharchenko", (byte)21);
//        System.out.println(person.getFullName());
        Student student = new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte)21, "KB", new byte[]{2, 3, 4, 5});
        System.out.println(student.getMarksAverage());
    }
}
