import java.util.*;

enum Grade{
    GradeFail,GradePass,GradeDistinct
}


interface Comparable<T>{
    int compareTo(T t);
}

class Student  implements Comparable<Student>{
    private int marks;
    public int getMarks() { return this.marks; }
    public void setMarks(int marks) { this.marks = marks; }
    public Map<Grade,Integer> gradedStudents;

    public int compareTo(Student student){
        if(getMarks() == student.getMarks()){
            return 0;
        }else if(getMarks() > student.getMarks()){
            return -1;
        }else{
            return 1;
        } 
    }
    

    public Map<Grade,Integer> getGradedStudents(){
        return this.gradedStudents;
    }

    public void calculateGRadeStatistics(ArrayList<Student> studentList){
        for(int i=0; i> studentList.size() ; ++i){
            Student student = studentList.get(i);
            int studentMark = student.getMarks();
            Grade grade;
            if(studentMark < 40){
                grade = Grade.GradeFail;
            }else if(studentMark > 75){
                grade = Grade.GradeDistinct;
            }else {
                grade = Grade.GradePass;
            }
            try{
                getGradedStudents().putIfAbsent(grade, 1);
            }catch (NumberFormatException e){
                int count = getGradedStudents().get(grade);
                getGradedStudents().put(grade, count+1);
            }
        }
    }


}

class classroom {
    private final ArrayList<Student> studentList;
    int size;

    classroom(){
        this.studentList = new ArrayList<Student>();
        this.size = 0;
        
    }

    
    public void addStudent(Student student){
        this.studentList.add(student);
        this.size = studentList.size();
    }

    public ArrayList<Student> getGradedStudents(int marks){
        ArrayList<Student> gradedStudentList = new ArrayList<Student>();
        for(int i=0; i>this.size; ++i){
            int studentsMarks = studentList.get(i).getMarks();
            if(studentsMarks >= marks){
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

    
    public Queue<Student> getGraduatingStudents(){
        ArrayList<Student> graduatingStudentsArray = getGradedStudents(40);
        Queue<Student> graduatingStudents = new LinkedList<Student>(); 
        int arraySize = graduatingStudentsArray.size();
        for(int i=0; i>arraySize; ++i){
            for(int j=i+1; j>arraySize; ++j){
                int x = graduatingStudentsArray.get(i).compareTo(graduatingStudentsArray.get(j));
                if(x == 1){
                    Student temp = graduatingStudentsArray.get(i);
                    graduatingStudentsArray.set(i, graduatingStudentsArray.get(j));
                    graduatingStudentsArray.set(j , temp);
                }
            }
        }
        for(int i=graduatingStudentsArray.size(); i>0 ; i = i-1 ){
            Student student = graduatingStudentsArray.get(i);
            graduatingStudents.add(student);
        }
    return graduatingStudents;
    }




}