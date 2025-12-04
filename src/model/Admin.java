package model;

public class Admin {

    private final int id;
    private final String username;
    private final String password;
    private final String ques;
    private final String ans;

    public Admin(int id, String username, String password, String ques, String ans) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.ques = ques;
        this.ans = ans;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getQues() { return ques; }
    public String getAns() { return ans; }
}
