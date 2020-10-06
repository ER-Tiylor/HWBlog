package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/10/6 20:40
 * @description：TODO
 * @version: 1.0
 */
public class Comment {
    private String commentID;
    private String parentCommentID;
    private String commentUser;
    private String commentBlog;
    private String commentDate;
    private String commentLikeNum;
    private String commentContent;

    public String getCommentID() {
        return commentID;
    }
    public void setCommentID(String commentID) {
        this.commentID = commentID;
    }
    public String getParentCommentID() {
        return parentCommentID;
    }
    public void setParentCommentID(String parentCommentID) {
        this.parentCommentID = parentCommentID;
    }
    public String getCommentUser() {
        return commentUser;
    }
    public void setCommentUser(String commentUser) {
        this.commentUser = commentUser;
    }
    public String getCommentBlog() {
        return commentBlog;
    }
    public void setCommentBlog(String commentBlog) {
        this.commentBlog = commentBlog;
    }
    public String getCommentDate() {
        return commentDate;
    }
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }
    public String getCommentLikeNum() {
        return commentLikeNum;
    }
    public void setCommentLikeNum(String commentLikeNum) {
        this.commentLikeNum = commentLikeNum;
    }
    public String getCommentContent() {
        return commentContent;
    }
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

}
