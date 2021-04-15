public class AndroidOS {
    public AndroidOS() {
        System.out.println("AndroidOS Booting Up...");
    }

    public void runQuizApp() {
        // Create three questions here
    	Question quest1 = new Question(9211238, "How tall is the Eiffel tower?", "1024 ft", "1063 ft", "1124 ft", "1163 ft", 1);
    	Question quest2 = new Question(107343, "Who invented the computer algorithm?", "Charles Babbage", "John Carmack", "Alan Turing", "Ada Lovelace", 3);
    	Question quest3 = new Question(748294, "What is the name for the patch of skin found on your elbow?", "Elbow Skin", "Fascia Elbora", "Wenis", "Todd", 2);
    	

        // System.out.println("Question 1: "" + ...)
    	System.out.println("Question 1: " + quest1.questionText);
    	System.out.println("Question 1 Answer: " + quest1.correctAnswer);
    	System.out.println("Question 2: " + quest2.questionText);
    	System.out.println("Question 2 Answer: " + quest2.correctAnswer);
    	System.out.println("Question 3: " + quest3.questionText);
    	System.out.println("Question 3 Answer: " + quest3.correctAnswer);
    }

    public static void main(String[] args) {
        System.out.println("Starting: AndroidOS");
        AndroidOS androidOS = new AndroidOS();
        androidOS.runQuizApp();
    }
}