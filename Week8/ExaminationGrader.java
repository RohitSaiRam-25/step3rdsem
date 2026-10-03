import java.util.Scanner;

interface Question {

    double evaluate(
        String correctAnswer,
        String studentAnswer,
        double points
    );
}

class MCQQuestion implements Question {

    public double evaluate(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class TFQuestion implements Question {

    public double evaluate(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {

        if (studentAnswer.equals(correctAnswer)) {
            return points;
        }

        return 0;
    }
}

class EssayQuestion implements Question {

    public double evaluate(
        String correctAnswer,
        String studentAnswer,
        double points
    ) {

        String[] keywords =
            correctAnswer.split(",");

        int matched = 0;

        String answer =
            studentAnswer.toLowerCase();

        for (String keyword : keywords) {

            if (answer.contains(
                keyword.trim().toLowerCase()
            )) {
                matched++;
            }
        }

        if (matched >= 2) {
            return points * 0.75;
        }
        else if (matched == 1) {
            return points * 0.50;
        }
        else {
            return 0;
        }
    }
}

public class ExaminationGrader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        double totalScore = 0;

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String[] parts =
                line.split("\"");

            String type =
                parts[0].trim().split(" ")[0];

            String questionText =
                parts[1];

            String correctAnswer =
                parts[3];

            String studentAnswer =
                parts[5];

            double points =
                Double.parseDouble(
                    parts[6].trim()
                );

            Question question;

            if (type.equals("MCQ")) {
                question = new MCQQuestion();
            }
            else if (type.equals("TF")) {
                question = new TFQuestion();
            }
            else {
                question = new EssayQuestion();
            }

            double score =
                question.evaluate(
                    correctAnswer,
                    studentAnswer,
                    points
                );

            totalScore =
                totalScore + score;

            System.out.printf(
                "%s: %.2f%n",
                type,
                score
            );
        }

        System.out.printf(
            "Total Score: %.2f%n",
            totalScore
        );

        sc.close();
    }
}