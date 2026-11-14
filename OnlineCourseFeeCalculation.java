import java.util.Scanner;

abstract class Course {
    protected double courseFee;

    public Course(double courseFee) {
        this.courseFee = courseFee;
    }

    public abstract double calculateDiscount();

    public abstract String getCourseType();

    public double calculateFinalFee() {
        return courseFee - calculateDiscount();
    }
}

class ProgrammingCourse extends Course {
    public ProgrammingCourse(double courseFee) {
        super(courseFee);
    }

    @Override
    public double calculateDiscount() {
        return courseFee * 10.0 / 100.0;
    }

    @Override
    public String getCourseType() {
        return "Programming";
    }
}

class DataScienceCourse extends Course {
    public DataScienceCourse(double courseFee) {
        super(courseFee);
    }

    @Override
    public double calculateDiscount() {
        return courseFee * 15.0 / 100.0;
    }

    @Override
    public String getCourseType() {
        return "Data Science";
    }
}

class CloudCourse extends Course {
    public CloudCourse(double courseFee) {
        super(courseFee);
    }

    @Override
    public double calculateDiscount() {
        return courseFee * 5.0 / 100.0;
    }

    @Override
    public String getCourseType() {
        return "Cloud";
    }
}

public class OnlineCourseFeeCalculation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int courseType = scanner.nextInt();
        double courseFee = scanner.nextDouble();

        Course course = null;

        if (courseType == 1) {
            course = new ProgrammingCourse(courseFee);
        } else if (courseType == 2) {
            course = new DataScienceCourse(courseFee);
        } else if (courseType == 3) {
            course = new CloudCourse(courseFee);
        }

        if (course != null) {
            System.out.println("Course Type: " + course.getCourseType());
            System.out.printf("Discount: %.2f%n", course.calculateDiscount());
            System.out.printf("Final Fee: %.2f%n", course.calculateFinalFee());
        }

        scanner.close();
    }
}