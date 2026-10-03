import java.util.Scanner;

public class TypingSpeedAccuracyChecker {

    public static void checkTypingAccuracy(String original, String typed) {

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatch = -1;

        for (int i = 0; i < totalCharacters; i++) {

            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatch == -1) {
                firstMismatch = i;
            }
        }

        double accuracy =
                (matchedCharacters * 100.0) / totalCharacters;

        System.out.printf(
                "Matched: %d/%d | Accuracy: %.2f%%",
                matchedCharacters,
                totalCharacters,
                accuracy
        );

        if (firstMismatch == -1) {

            System.out.println(" | No Mismatches");

        } else {

            System.out.println(
                    " | First Mismatch at position "
                    + (firstMismatch + 1)
                    + " ('"
                    + original.charAt(firstMismatch)
                    + "' vs '"
                    + typed.charAt(firstMismatch)
                    + "')"
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter original passage: ");
        String original = sc.nextLine();

        System.out.print("Enter typed text: ");
        String typed = sc.nextLine();

        if (original.length() != typed.length()) {

            System.out.println(
                    "Error: Both strings must have the same length."
            );

        } else {

            checkTypingAccuracy(original, typed);
        }

        sc.close();
    }
}
