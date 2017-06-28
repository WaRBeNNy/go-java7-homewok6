package model;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private String specialty;
    private Double salary;

    public Developer() {
    }

    public Developer(Long id, String firstName, String lastName, String specialty, Double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialty = specialty;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + specialty + "," + salary + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Developer developer = (Developer) o;

        if (!id.equals(developer.id)) return false;
        if (!firstName.equals(developer.firstName)) return false;
        if (!lastName.equals(developer.lastName)) return false;
        if (!specialty.equals(developer.specialty)) return false;
        return salary.equals(developer.salary);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + specialty.hashCode();
        result = 31 * result + salary.hashCode();
        return result;
    }
}
