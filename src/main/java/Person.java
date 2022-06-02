public class Person extends IncorrectUsernameException {
    private String firstName;
    private String name;
    private String lastName;
    private byte age;

    public Person() {
    }

    public Person(String firstName, String name, String lastName, byte age) {
        this.firstName = firstName;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    protected String getFullName() throws Exception {
        String fullName = "";

        if(getFirstName() != ""){
            fullName += getFirstName() + " ";
        }else throw new IncorrectUsernameException("Incorrect name enter!");

        if(getName() != ""){
            fullName += getName() + " ";
        }else throw new IncorrectUsernameException("Incorrect name enter!");

        if(getLastName() != ""){
            fullName += getLastName();
        }else throw new IncorrectUsernameException("Incorrect name enter!");

        return fullName;
    }

    protected boolean isAdult(Person p) {
        return p.getAge() >= 21;
    }

    public String getFirstName() {
        return firstName;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    private void setAge(byte age) {
        this.age = age;
    }
}
