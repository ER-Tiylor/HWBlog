package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/10/6 20:29
 * @description：TODO
 * @version: 1.0
 */
public class Blog {
    private String blogID;
    private String blogUser;
    private String blogDate;
    private String blogTitle;
    private String blogContent;
    private String blogViewNum;
    private String blogLikeNum;
    private String blogCommentNum;
    private String blogAttachFile;
    private String blogSort;
    private String blogLabel;

    public String getBlogID() {
        return blogID;
    }
    public void setBlogID(String blogID) {
        this.blogID = blogID;
    }
    public String getBlogUser() {
        return blogUser;
    }
    public void setBlogUser(String blogUser) {
        this.blogUser = blogUser;
    }
    public String getBlogDate() {
        return blogDate;
    }
    public void setBlogDate(String blogDate) {
        this.blogDate = blogDate;
    }
    public String getBlogTitle() {
        return blogTitle;
    }
    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }
    public String getBlogContent() {
        return blogContent;
    }
    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }
    public String getBlogViewNum() {
        return blogViewNum;
    }
    public void setBlogViewNum(String blogViewNum) {
        this.blogViewNum = blogViewNum;
    }
    public String getBlogLikeNum() {
        return blogLikeNum;
    }
    public void setBlogLikeNum(String blogLikeNum) {
        this.blogLikeNum = blogLikeNum;
    }
    public String getBlogCommentNum() {
        return blogCommentNum;
    }
    public void setBlogCommentNum(String blogCommentNum) {
        this.blogCommentNum = blogCommentNum;
    }
    public String getBlogAttachFile() {
        return blogAttachFile;
    }
    public void setBlogAttachFile(String blogAttachFile) {
        this.blogAttachFile = blogAttachFile;
    }
    public String getBlogSort() {
        return blogSort;
    }
    public void setBlogSort(String blogSort) {
        this.blogSort = blogSort;
    }
    public String getBlogLabel() {
        return blogLabel;
    }
    public void setBlogLabel(String blogLabel) {
        this.blogLabel = blogLabel;
    }

}
