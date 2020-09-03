package bean;

import java.sql.Date;

public class Task {
    private int classId;
    private int id;
    private String taskName;
    private Date putDate;
    private Date endDate;
    private int examtime;
    private int questionId;
    private int submitSum;
    private float totalscore;
    private String submitLog;

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

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getPutDate() {
        return putDate;
    }

    public void setPutDate(Date putDate) {
        this.putDate = putDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getExamtime() {
        return examtime;
    }

    public void setExamtime(int examtime) {
        this.examtime = examtime;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getSubmitSum() {
        return submitSum;
    }

    public void setSubmitSum(int submitSum) {
        this.submitSum = submitSum;
    }

    public float getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(float totalscore) {
        this.totalscore = totalscore;
    }

    public String getSubmitLog() {
        return submitLog;
    }

    public void setSubmitLog(String submitLog) {
        this.submitLog = submitLog;
    }
}
