package university.subjects;

public enum SubjectType {
    MATHEMATICS("Mathematics"),
    PHYSICS("Physics"),
    MATHEMATICAL_MODELING("Mathematical modeling"),
    WEB_DESIGN("WEB design"),
    JAVA("Java"),
    ECONOMY("Economy"),
    ENERGETICS("Energetics"),
    PHILOSOPHY("Philosophy"),
    HISTORY("History"),
    ENGLISH("English");

    private String subjectName;
    SubjectType(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectName() {
        return subjectName;
    }
}
