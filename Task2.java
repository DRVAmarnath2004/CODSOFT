import java.util.Scanner;

public class StudentGradeCalculator{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask for the number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validate marks input
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input! Enter marks between 0 and 100: ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i]; // Calculate total
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Assign Grade based on percentage
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display Results
        System.out.println("\n=== Student Grade Report ===");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        // Feedback based on grade
        switch (grade) {
            case 'A': System.out.println("Excellent work! Keep it up!"); break;
            case 'B': System.out.println("Great job! Try aiming for an A next time."); break;
            case 'C': System.out.println("Good effort! You can do even better!"); break;
            case 'D': System.out.println("You passed, but improvement is needed."); break;
            case 'F': System.out.println("Unfortunately, you failed. Focus on improvement."); break;
        }

        scanner.close();
    }
}