import java.util.Scanner;

abstract class Doctor {
    protected double consultationCharge;

    public Doctor(double consultationCharge) {
        this.consultationCharge = consultationCharge;
    }

    public abstract String getDoctorType();

    public double calculateTotalBill(double testCharges) {
        return consultationCharge;
    }
}

class GeneralPhysician extends Doctor {
    public GeneralPhysician() {
        super(500.0);
    }

    @Override
    public String getDoctorType() {
        return "General Physician";
    }
}

class Specialist extends Doctor {
    public Specialist() {
        super(1000.0);
    }

    @Override
    public String getDoctorType() {
        return "Specialist";
    }
}

class EmergencyDoctor extends Doctor {
    public EmergencyDoctor() {
        super(1500.0);
    }

    @Override
    public String getDoctorType() {
        return "Emergency Doctor";
    }

    @Override
    public double calculateTotalBill(double testCharges) {
        return consultationCharge + testCharges;
    }
}

public class HospitalBillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        if (!scanner.hasNextInt()) {
            scanner.close();
            return;
        }

        int doctorType = scanner.nextInt();
        double testCharges = scanner.nextDouble();

        Doctor doctor = null;

        if (doctorType == 1) {
            doctor = new GeneralPhysician();
        } else if (doctorType == 2) {
            doctor = new Specialist();
        } else if (doctorType == 3) {
            doctor = new EmergencyDoctor();
        }

        if (doctor != null) {
            System.out.println("Doctor Type: " + doctor.getDoctorType());
            System.out.printf("Consultation Charge: %.2f%n", doctor.consultationCharge);
            System.out.printf("Test Charges: %.2f%n", testCharges);
            System.out.printf("Total Bill: %.2f%n", doctor.calculateTotalBill(testCharges));
        }

        scanner.close();
    }
}