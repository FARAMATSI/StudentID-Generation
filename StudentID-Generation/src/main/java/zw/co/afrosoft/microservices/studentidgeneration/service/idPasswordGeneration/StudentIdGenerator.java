package zw.co.afrosoft.microservices.studentidgeneration.service.idPasswordGeneration;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class StudentIdGenerator {
    private static final Random random = new Random();

    public static String generateID(String firstName, String lastName) {
        // Extracting initials from the first name and last name
        String initials = getInitials(firstName, lastName);

        // Generating a unique combination of numbers
        String numbers = generateUniqueNumbers();

        // Generating the student ID
        String studentID = "AFCD" + numbers + initials;

        return studentID;
    }

    private static String getInitials(String firstName, String lastName) {
        return firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase();
    }

    private static String generateUniqueNumbers() {
        // Generate a unique random number between 0 and 9999
        Set<Integer> generatedNumbers = new HashSet<>();
        while (true) {
            int randomNumber = random.nextInt(10000);
            if (!generatedNumbers.contains(randomNumber)) {
                generatedNumbers.add(randomNumber);
                return String.format("%04d", randomNumber); // Pad with leading zeros
            }
        }
    }
}