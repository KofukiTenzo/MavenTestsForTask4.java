import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class StudentTest {
    
    private static Stream<Arguments> generatorForMarksAverage() throws Exception {
        return Stream.of(
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {2, 3, 2, 4, 5}), 3.2f),
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {4, 5, 5, 4, 5}), 4.6f),
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {2, 5, 5, 5, 5}), 4.4f));
    }

    @ParameterizedTest
    @MethodSource("generatorForMarksAverage")
    void getMarksAverageSouldReturnAverage(Student student, float expected) {
        Assertions.assertEquals(expected, student.getMarksAverage());
    }

    private static Stream<Arguments> generatorForExcelentStudentOrNot() throws Exception {
        return Stream.of(
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {2, 3, 2, 4, 5}), false),
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {4, 5, 5, 4, 5}), true),
                Arguments.of(new Student("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21, "CS", new byte[] {2, 5, 5, 5, 5}), true));
    }

    @ParameterizedTest
    @MethodSource("generatorForExcelentStudentOrNot")
    void isExcelentStudentShouldReturnTrue(Student student, boolean expected) {
        Assertions.assertEquals(expected, student.isExcelentStudent());
    }

    private static Stream<Arguments> generatorForBetterStudent() throws Exception {
        return Stream.of(
                Arguments.of(new Student("Ivanov", "Ivan", "Ivanovich", (byte) 21, "CS1", new byte[]{1, 2, 1, 2, 1}),
                        new Student("Vladimirov", "Vladimir", "Vladimirovich", (byte) 21, "CS1", new byte[]{1, 2, 2, 2, 3}),
                        new Student("Olegov", "Oleg", "Olegovich", (byte) 21, "CS1", new byte[]{3, 2, 3, 2, 3}),
                        "Olegov Oleg Olegovich"
                ),
                Arguments.of(new Student("Ivanov", "Ivan", "Ivanovich", (byte) 21, "CS1", new byte[]{4, 4, 4, 4, 4}),
                        new Student("Vladimirov", "Vladimir", "Vladimirovich", (byte) 21, "CS1", new byte[]{3, 3, 3, 3, 3}),
                        new Student("Olegov", "Oleg", "Olegovich", (byte) 21, "CS1", new byte[]{2, 2, 2, 2, 2}),
                        "Ivanov Ivan Ivanovich"),
                Arguments.of(new Student("Ivanov", "Ivan", "Ivanovich", (byte) 21, "CS1", new byte[]{4, 4, 5, 4, 5}),
                        new Student("Vladimirov", "Vladimir", "Vladimirovich", (byte) 21, "CS1", new byte[]{4, 5, 5, 4, 5}),
                        new Student("Olegov", "Oleg", "Olegovich", (byte) 21, "CS1", new byte[]{4, 3, 4, 4, 5}),
                        "Vladimirov Vladimir Vladimirovich"));
    }

    @ParameterizedTest
    @MethodSource("generatorForBetterStudent")
    void getBetterStudentByAverageShouldReturnWithBiggestAverage(Student student1, Student student2, Student student3, String expected) throws Exception {
        Assertions.assertEquals(expected, Student.getBetterStudentByAverage(student1, student2, student3));
    }
}
