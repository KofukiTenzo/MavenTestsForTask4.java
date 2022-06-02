import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;

public class PersonTest extends Person {

    Person person = new Person("Kharchenko", "Ruslan", "", (byte) 18);

    @Test
    void PersonFullNameShouldTrowIncorrectUsernameExceptionIfNameNonFull() {
        Exception e = Assertions.assertThrows(Exception.class, () -> person.getFullName());

        Assertions.assertEquals("Incorrect name enter!", e.getMessage());
    }

    private static Stream<Arguments> generatorForFullName() {
        return Stream.of(
                Arguments.of(new Person("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 16), "Kharchenko Ruslan Viacheslavovich"),
                Arguments.of(new Person("Ivanov", "Ivan", "Ivanovich", (byte) 18), "Ivanov Ivan Ivanovich"),
                Arguments.of(new Person("Vladimirov", "Vladimir", "Vladimirovich", (byte) 21), "Vladimirov Vladimir Vladimirovich"),
                Arguments.of(new Person("Olegov", "Oleg", "Olegovich", (byte) 25), "Olegov Oleg Olegovich"));
    }

    @ParameterizedTest
    @MethodSource("generatorForFullName")
    void PersonFullNameShouldReturnFullName(Person person, String expected) throws Exception {
        Assertions.assertEquals(expected, person.getFullName());
    }

    private static Stream<Arguments> generatorForIsAdult() {
        return Stream.of(
                Arguments.of(new Person("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 16), false),
                Arguments.of(new Person("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 18), false),
                Arguments.of(new Person("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 21), true),
                Arguments.of(new Person("Kharchenko", "Ruslan", "Viacheslavovich", (byte) 25), true));
    }

    @ParameterizedTest
    @MethodSource("generatorForIsAdult")
    void isAdultShouldReturnTrueIfAgeMoreThanTwenty_OneOrEquals(Person person, boolean expected) {
        Assertions.assertEquals(expected, isAdult(person));
    }
}
