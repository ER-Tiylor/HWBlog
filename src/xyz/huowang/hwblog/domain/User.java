package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:29
 * @description：TODO
 * @version: 1.0
 */
public class User {
    private String userID;//用户ID
    private String userName;//用户名
    private String userPassWord;//用户密码
    private String userSex;//用户性别
    private String userTelNum;//用户电话号
    private String userEmail;//用户邮箱
    private String userBirthday;//用户生日
    private String userFlag;//用户登录状态

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassWord() {
        return userPassWord;
    }

    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserTelNum() {
        return userTelNum;
    }

    public void setUserTelNum(String userTelNum) {
        this.userTelNum = userTelNum;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(String userFlag) {
        this.userFlag = userFlag;
    }

    public User(String userID, String userName, String userPassWord, String userSex, String userTelNum, String userEmail, String userBirthday, String userFlag) {
        this.userID = userID;
        this.userName = userName;
        this.userPassWord = userPassWord;
        this.userSex = userSex;
        this.userTelNum = userTelNum;
        this.userEmail = userEmail;
        this.userBirthday = userBirthday;
        this.userFlag = userFlag;
    }

    public User() {
        super();
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userTelNum='" + userTelNum + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userFlag='" + userFlag + '\'' +
                '}';
    }
}
