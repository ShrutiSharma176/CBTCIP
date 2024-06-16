import java.util.*;

class User {
    private String username,password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class Question {
    private String question;
    private List<String> options;
    private int correctAnsIndex;

    public Question(String question, List<String> options, int correctAnsIndex) {
        this.question = question;
        this.options = options;
        this.correctAnsIndex = correctAnsIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnsIndex() {
        return correctAnsIndex;
    }   
}

class UserService {
    Map<Integer, User> users=new HashMap<>();

    public UserService() {
        users.put(101,new User("shruti","shruti@123"));
        users.put(102,new User("andrew","andrew@123"));
        users.put(103,new User("jimin","jimin@123"));
    }

    boolean login(int rno,String username,String password){
        User u = users.get(rno);
        if(u!=null && u.getUsername().equals(username) && u.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    boolean updateProfile(int rno,String username,String password){
        User u = users.get(rno);
        if(u!=null){
            u.setUsername(username);
            u.setPassword(password);
            return true;
        }

        return false;
    }
    
    boolean updatePassword(int rno,String password){
        User u = users.get(rno);
        if(u!=null){
            u.setPassword(password);
            return true;
        }

        return false;
    }
}

class ExamService{
    List<Question> list = new ArrayList<>();
    int selectedAns[];

    ExamService(){
        List<String> options1 = Arrays.asList("4", "6", "1", "0");
        list.add(new Question("What is 2x2?", options1, 0));

        List<String> options2 = Arrays.asList("O2", "CO2", "N2O", "H2O");
        list.add(new Question("What is the formula of water?", options2, 3));

        List<String> options3 = Arrays.asList("Class", "Object", "Constructor", "Inheritance");
        list.add(new Question("Which concept is not an OOPS concept?", options3, 2));

        selectedAns = new int[list.size()];
    }

    public List<Question> getQuestions() {
        return list;
    }

    public void selectAnswer(int questionIndex, int answerIndex) {
        selectedAns[questionIndex] = answerIndex;
    }

    public int[] getSelectedAnswers() {
        return selectedAns;
    }

    public int getScore(){
        int score = 0;
        for(int i =0;i<list.size();i++){
            Question q = list.get(i);

            if(q.getCorrectAnsIndex()==selectedAns[i]){
                score+=10;
            }

        }

        return score;
    }

    public void autoSubmit() {
        System.out.println("Auto-submitting the exam...");
        int score = getScore();
        System.out.println("Score: " + score);
    }
}

class Timer extends Thread {
    private int duration; // in seconds
    private ExamService examService;

    public Timer(int duration, ExamService examService) {
        this.duration = duration;
        this.examService = examService;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(duration * 1000);
            examService.autoSubmit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ExamController {
    ExamService examService;
    Timer timer;

    public ExamController(ExamService examService, int examDuration) {
        this.examService = examService;
        this.timer = new Timer(examDuration, examService);
        timer.start();
    }
}

class Examination{
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);

        System.out.println("Please Enter your Details to proceed exam...");
        System.out.println("Enter your Roll-no: ");
        int rno = sc.nextInt();
        System.out.println("Enter your Username: ");
        sc.nextLine();
        String username = sc.nextLine();
        System.out.println("Enter your Password: ");
        String password = sc.nextLine();

        UserService userService = new UserService();

        if (userService.login(rno, username, password)) {
            ExamService es = new ExamService();
            ExamController ec = new ExamController(es, 60);

            for (int i = 0; i < es.getQuestions().size(); i++) {
                Question q = es.getQuestions().get(i);
                System.out.println(q.getQuestion());
                for (int j = 0; j < q.getOptions().size(); j++) {
                    System.out.println((j + 1) + ". " + q.getOptions().get(j));
                }
                System.out.println("Select correct option: ");
                int selectedOption = sc.nextInt() - 1; // Subtract 1 to match index
                es.selectAnswer(i, selectedOption);
            }

            //ec.timer.interrupt();
            int score = es.getScore();
            System.out.println("Score: " + score);
        } else {
            System.out.println("Sorry, you are not registered for the exam");
        }

   }
}