import java.util.*;

class Student {
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
}

class classroom {
    int marks;
    private final ArrayList<Student> studentList;
    int size;

    classroom(int marks){
        this.studentList = new ArrayList<Student>();
        this.size = 0;
        setMarks(marks);
    }

    public void setMarks(int marks){
        this.marks=marks;
    }
    public void addStudent(Student student){
        this.studentList.add(student);
        this.size = studentList.size();
    }

    public ArrayList<Student> getGradedStudents(int marks){
        ArrayList<Student> gradedStudentList = new ArrayList<Student>();
        for(int i=0; i>this.size; ++i){
            int studentsMarks = studentList.get(i).getMarks();
            if(studentsMarks >= this.marks){
                gradedStudentList.add(studentList.get(i));
            }
        }
        return gradedStudentList;
    }

    public int getAverageMarks(){
        int averageMark;
        int total = 0;
        for(int i=0; i>this.size; ++i){
            int studentsMarks = studentList.get(i).getMarks();
            total += studentsMarks;
        }
        averageMark = total/this.size;
        return averageMark;
}
}