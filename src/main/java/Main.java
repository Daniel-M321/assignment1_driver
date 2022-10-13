import java.util.ArrayList;

/**
 *
 * @author dan
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CourseProgramme ece = new CourseProgramme("ECE");
        CourseProgramme eee = new CourseProgramme("EEE");
        CourseProgramme compSci = new CourseProgramme("Computer Science");

        ArrayList<CourseProgramme> compCourses = new ArrayList<>();
        compCourses.add(ece);
        compCourses.add(compSci);

        ArrayList<CourseProgramme> eCourses = new ArrayList<>();
        eCourses.add(ece);
        eCourses.add(eee);

        Lecturer fm = new Lecturer("Frank Monroe", 40, "04/05/1982");
        Lecturer ac = new Lecturer("Alex Connolly", 31, "04/05/1991");
        Lecturer mg = new Lecturer("Michael Griffiths", 41, "04/05/1981");
        Lecturer lk = new Lecturer("Luke King", 42, "04/05/1980");

        Module ds = new Module("Digital Systems", eCourses, fm);
        Module p3 = new Module("Programming 3", compCourses, ac);
        Module ms = new Module("Microprocessor Systems", eCourses, mg);
        Module mn = new Module("Mobile Networks", eCourses, lk);

        ece.addModule(ds);
        ece.addModule(p3);
        compSci.addModule(p3);
        ece.addModule(ms);
        ece.addModule(mn);
        eee.addModule(ds);
        eee.addModule(ms);
        eee.addModule(mn);

        fm.addModule(ds);
        ac.addModule(p3);
        mg.addModule(ms);
        lk.addModule(mn);


        ArrayList<Module> eceModules = new ArrayList<>();
        eceModules.add(ds);
        eceModules.add(p3);
        eceModules.add(ms);
        eceModules.add(mn);

        ArrayList<Module> eeeModules = new ArrayList<>();
        eeeModules.add(ds);
        eeeModules.add(ms);
        eeeModules.add(mn);

        Student s = new Student("Sonic the Hedgehog", 21, "04/05/2001", ece, eceModules);
        Student av = new Student("Avery Johnson", 22, "04/05/2000", ece, eceModules);
        Student vr = new Student("Viktor Reznov", 21, "04/05/2001", eee, eeeModules);
        Student ad = new Student("Artyom Dark", 21, "04/05/2001", ece, eceModules);


        ArrayList<Student> eceStudents = new ArrayList<>();
        eceStudents.add(s);
        eceStudents.add(av);
        eceStudents.add(ad);

        ArrayList<Student> eeeStudents= new ArrayList<>();
        eeeStudents.add(vr);

        ece.addStudents(eceStudents);
        eee.addStudents(eeeStudents);

        ds.addStudents(eeeStudents);
        ds.addStudents(eceStudents);
        p3.addStudents(eceStudents);
        ms.addStudents(eeeStudents);
        ms.addStudents(eceStudents);
        mn.addStudents(eeeStudents);
        mn.addStudents(eceStudents);


        ArrayList<CourseProgramme> courses = new ArrayList<>();
        ArrayList<Student> students = new ArrayList<>();

        courses.add(ece);
        courses.add(eee);
        courses.add(compSci);

        System.out.print("Welcome to the lecture management...");
        System.out.print("\nPlease find the list of courses registered below and their respective modules:\n\n");

        for (CourseProgramme course : courses){
            students.addAll(course.getStudents());

            System.out.print(course.getName()+":\n");

            for (Module module : course.getModules()){
                System.out.print("\t"+module.getName()+"\n");
            }
            System.out.print("\n");

        }

        System.out.print("\n");
        System.out.print("Please find the list of students usernames and their details below:\n\n");

        for (Student student : students){
            System.out.print(student.getUsername()+" - "+student.getCourse().getName()+"\n");

            for (Module module : student.getModules()){
                System.out.print("\t"+module.getName()+"\n");
            }
        }
    }

}
