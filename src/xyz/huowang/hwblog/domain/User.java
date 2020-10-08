package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:29
 * @description：TODO
 * @version: 1.0
 */
public class User {
    private String userID;//用户ID
    private String userIP;//用户IP
    private String userName;//用户名
    private String userNickName;//用户昵称
    private String userPassWord;//用户密码
    private String userTelNum;//用户电话号
    private String userEmail;//用户邮箱
    private String userBirthday;//用户生日
    private String userRight;//用户权限
    private String userRegisterTime;//注册时间
    private String userIntroduction;//用户简介
    private String userHeadImage;//用户头像
    private String userGender;//用户性别

    public String getUserID() {
        return userID;
    }
    public void setUserID(String userID) {
        this.userID = userID;
    }
    public String getUserIP() {
        return userIP;
    }
    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserNickName() {
        return userNickName;
    }
    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
    public String getUserPassWord() {
        return userPassWord;
    }
    public void setUserPassWord(String userPassWord) {
        this.userPassWord = userPassWord;
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
    public String getUserRight() {
        return userRight;
    }
    public void setUserRight(String userRight) {
        this.userRight = userRight;
    }
    public String getUserRegisterTime() {
        return userRegisterTime;
    }
    public void setUserRegisterTime(String userRegisterTime) {
        this.userRegisterTime = userRegisterTime;
    }
    public String getUserIntroduction() {
        return userIntroduction;
    }
    public void setUserIntroduction(String userIntroduction) {
        this.userIntroduction = userIntroduction;
    }
    public String getUserHeadImage() {
        return userHeadImage;
    }
    public void setUserHeadImage(String userHeadImage) {
        this.userHeadImage = userHeadImage;
    }
    public String getUserGender() {
        return userGender;
    }
    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID='" + userID + '\'' +
                ", userIP='" + userIP + '\'' +
                ", userName='" + userName + '\'' +
                ", userNickName='" + userNickName + '\'' +
                ", userPassWord='" + userPassWord + '\'' +
                ", userTelNum='" + userTelNum + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userBirthday='" + userBirthday + '\'' +
                ", userRight='" + userRight + '\'' +
                ", userRegisterTime='" + userRegisterTime + '\'' +
                ", userIntroduction='" + userIntroduction + '\'' +
                ", userHeadImage='" + userHeadImage + '\'' +
                ", userGender='" + userGender + '\'' +
                '}';
    }


}
