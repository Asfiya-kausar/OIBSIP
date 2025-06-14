import java.util.*;

import javax.swing.plaf.synth.SynthCheckBoxUI;
public class OnlineExam {
    static Scanner sc = new Scanner(System.in);
    static String username = "user";
    static String password = "pass";
    public static void main(String args[]) {
        if(!login())return;
        while(true) {
            System.out.println("\n--- Main Menu---");
            System.out.println("1.updateProfile");
            System.out.println("2.StartExam");
            System.out.println("3.Logout");
            System.out.println("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch(choice) {
              case 1:
                 updateProfile();
                 break;
              case 2: 
                 StartExam();
                 break;
              case 3:
                System.out.println("Logged out successfully.");
           return;
           default:
           System.out.println("Invalid choice.");
            }
        }
    }
    static boolean login(){
        System.out.println("---Login---");
        System.out.println("Enter username: ");
        String user = sc.nextLine();
        System.out.println("Enter password: ");
        String pass = sc.nextLine();
        if(user.equals(username)&&pass.equals(password)) {
        System.out.println("Login Successful!");
        return true;
        }else{
            System.out.println("Login Failed!");
            return false;
        }
    }
    static void updateProfile(){
        System.out.println("---updateProfile---");
        System.out.println("Enter new password: ");
        password = sc.nextLine();
        System.out.println("Password updated successfully! ");
    }
    static void StartExam(){
        System.out.println("---Exam started(Auto-submit in 30 seconds)---");
        String[] questions = {
            "1. What is the capital of India?\n a)Mumbai\n b)Delhi\n c)Kolkata\n d)Chennai",
            "2. 5*6 = ?\n a)20\n b)10\n c)30\n d)25",
            "3. Python is a:\n a)OS\n b)Programming Language\n c)Compiler\n d)Browser"
        };
        String[] answers = {"b","c","b"};
        int score = 0;
        long startTime = System.currentTimeMillis();
        long allowedTime = 30*10000;
        for(int i = 0;i < questions.length;i++) {
            if(System.currentTimeMillis()-startTime>allowedTime) {
                System.out.println("Time's up! Auto-submitting exam...");
                break;
            }
            System.out.println("\n"+questions[i]);
            System.out.println("Your answer: ");
            String ans = sc.nextLine().toLowerCase();
            if(ans.equals(answers[i]))
            score++;
        }
        System.out.println("\nExam Over! Your Score:" +score+ "/" + questions.length);
    }
}