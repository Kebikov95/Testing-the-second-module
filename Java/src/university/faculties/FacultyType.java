package university.faculties;

public enum FacultyType {
    ECONOMY("Economy"),
    ENERGY("Energy"),
    INFORMATION_TECHNOLOGY("Information technology");

    private String facultyName;
    FacultyType(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyName() {
        return facultyName;
    }
}
