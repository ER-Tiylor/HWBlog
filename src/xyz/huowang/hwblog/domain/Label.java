package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/10/6 20:40
 * @description：TODO
 * @version: 1.0
 */
public class Label {
    private String LabelID;
    private String LabelName;
    private String LabelNickName;
    private String LabelDescription;

    public String getLabelID() {
        return LabelID;
    }
    public void setLabelID(String labelID) {
        LabelID = labelID;
    }
    public String getLabelName() {
        return LabelName;
    }
    public void setLabelName(String labelName) {
        LabelName = labelName;
    }
    public String getLabelNickName() {
        return LabelNickName;
    }
    public void setLabelNickName(String labelNickName) {
        LabelNickName = labelNickName;
    }
    public String getLabelDescription() {
        return LabelDescription;
    }
    public void setLabelDescription(String labelDescription) {
        LabelDescription = labelDescription;
    }

}
