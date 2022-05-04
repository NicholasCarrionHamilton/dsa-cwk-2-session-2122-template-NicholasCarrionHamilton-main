package model;

public class StudentMarks implements Comparable<StudentMarks> {
    private String StudentID;
    private String GivenName;
    private String Lastname;
    private int CT1;
    private int CT2;
    private int CT3;
    private int ModuleMark;

    public StudentMarks() {
        this.StudentID = "";
        this.GivenName = "";
    }

    public StudentMarks(String glossaryEntry, String glossaryDefinition) {
        this.StudentID = glossaryEntry;
        this.GivenName = glossaryDefinition;
    }

    public String getStudentID() {
        return this.StudentID;
    }

    public void setStudentID(String studentID) {
        this.StudentID = studentID;
    }

    public String getGivenName() {
        return this.GivenName;
    }

    public void setGivenName(String givenName) {
        this.GivenName = givenName;
    }

    public String getLastname() {
        return this.Lastname;
    }

    public void setLastname(String lastname) {
        this.Lastname = lastname;
    }

    public int getCT1() {
        return this.CT1;
    }

    public void setCT1(int CT1) {
        this.CT1 = CT1;
    }

    public int getCT2() {
        return this.CT2;
    }

    public void setCT2(int CT2) {
        this.CT2 = CT2;
    }

    public int getCT3() {
        return this.CT3;
    }

    public void setCT3(int CT3) {
        this.CT3 = CT3;
    }

    public int getModuleMark() {
        return this.ModuleMark;
    }

    public void setModuleMark(int moduleMark) {
        this.ModuleMark = moduleMark;
    }

    public void calculateModuleMark() {
        int modMark = Math.toIntExact(Math.round((double)this.CT1 * 0.3D + (double)this.CT2 * 0.3D + (double)this.CT3 * 0.4D));
        this.setModuleMark(modMark);
    }

    public String CSVFormat() {
        String outputStr = this.StudentID + "," + this.GivenName + "," + this.Lastname + "," + this.CT1 + "," + this.CT2 + "," + this.CT3 + "," + this.ModuleMark;
        return outputStr;
    }

    public String toString() {
        return "StudentMarks{StudentID='" + this.StudentID + '\'' + ", GivenName='" + this.GivenName + '\'' + ", Lastname='" + this.Lastname + '\'' + ", CT1=" + this.CT1 + ", CT2=" + this.CT2 + ", CT3=" + this.CT3 + ", ModuleMark=" + this.ModuleMark + '}';
    }

    public int compareTo(StudentMarks anEntry) {
        if (this.ModuleMark == anEntry.getModuleMark()) {
            return 0;
        } else {
            return this.ModuleMark > anEntry.getModuleMark() ? 1 : -1;
        }
    }
}

