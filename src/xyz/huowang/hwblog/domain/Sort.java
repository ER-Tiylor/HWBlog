package xyz.huowang.hwblog.domain;

/**
 * @author ：HW
 * @date ：Created in 2020/10/6 20:40
 * @description：TODO
 * @version: 1.0
 */
public class Sort {
    private String SortID;
    private String SortName;
    private String SortNickName;
    private String SortDescription;

    public String getSortID() {
        return SortID;
    }
    public void setSortID(String sortID) {
        SortID = sortID;
    }
    public String getSortName() {
        return SortName;
    }
    public void setSortName(String sortName) {
        SortName = sortName;
    }
    public String getSortNickName() {
        return SortNickName;
    }
    public void setSortNickName(String sortNickName) {
        SortNickName = sortNickName;
    }
    public String getSortDescription() {
        return SortDescription;
    }
    public void setSortDescription(String sortDescription) {
        SortDescription = sortDescription;
    }

}
