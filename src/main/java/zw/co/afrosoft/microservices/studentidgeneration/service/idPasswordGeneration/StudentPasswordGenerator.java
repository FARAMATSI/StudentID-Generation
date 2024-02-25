package zw.co.afrosoft.microservices.studentidgeneration.service.idPasswordGeneration;

import org.apache.commons.text.RandomStringGenerator;

public class StudentPasswordGenerator {
        public static String generatePassword() {
        // Define the character set for the password
        int minCodePoint = 33; // ASCII value of '!'
        int maxCodePoint = 122; // ASCII value of 'z'
        // Define the length of the password
        int length = 12;

        // Create a random string generator
        RandomStringGenerator generator = new RandomStringGenerator.Builder()
                .withinRange(minCodePoint, maxCodePoint)
                .build();

        return generator.generate(length);
    }
}
