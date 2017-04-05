package entities;

public class Teacher extends Entity{
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Course trainingCourse;

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public Course getTrainingCourse() {
        return trainingCourse;
    }

    public void setTrainingCourse(Course trainingCourse) {
        this.trainingCourse = trainingCourse;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        return id == teacher.id
                && firstName.equals(teacher.firstName)
                && lastName.equals(teacher.lastName)
                && middleName.equals(teacher.middleName)
                && (trainingCourse != null ? trainingCourse.equals(teacher.trainingCourse) : teacher.trainingCourse == null);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + middleName.hashCode();
        result = 31 * result + (trainingCourse != null ? trainingCourse.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return id + ". " + firstName + ' ' + lastName + ' ' + middleName + "\n" +
                "- training course: " + trainingCourse.getCourseName() + " (" + trainingCourse.getSubject() + ")";
    }
}
