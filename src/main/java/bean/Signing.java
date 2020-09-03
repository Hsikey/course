package bean;

import java.sql.Date;
import java.util.BitSet;

public class Signing {
    private int classId;
    private int id;
    private String title;
    private Date startDate;
    private Date endDate;
    private int signSum;
    private BitSet log;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getSignSum() {
        return signSum;
    }

    public void setSignSum(int signSum) {
        this.signSum = signSum;
    }

    public BitSet getLog() {
        return log;
    }

    public void setLog(BitSet log) {
        this.log = log;
    }
}
