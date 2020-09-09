package src.xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/9/8 22:30
 * @description：TODO
 * @version: 1.0
 */
public class CriteriaUser {

    private String userID;//用户ID
    private String userName;//用户名
    private String userPassWord;//用户密码
    private String userSex;//用户性别
    private String userTelNum;//用户电话号
    private String userEmail;//用户邮箱
    private String userBirthday;//用户生日
    private String userFlag;//用户登录状态

    public String getName() {
        if(userName == null)
            userName = "%%";
        else
            userName = "%" + userName + "%";
        return userName;
    }
    public void setName(String name) {
        this.userName = name;
    }
    public String getEmail() {
        if(userEmail == null)
            userEmail = "%%";
        else
            userEmail = "%" + userEmail + "%";
        return userEmail;
    }
    public void setAddress(String address) {
        this.userEmail = address;
    }
    public String getPhone() {
        if(userTelNum == null)
            userTelNum = "%%";
        else
            userTelNum = "%" + userTelNum + "%";
        return userTelNum;
    }
    public void setPhone(String phone) {
        this.userTelNum = phone;
    }



    public CriteriaUser() {
        super();
    }

    public CriteriaUser(String userName, String userTelNum, String userEmail) {
        this.userName = userName;
        this.userTelNum = userTelNum;
        this.userEmail = userEmail;
    }
}
