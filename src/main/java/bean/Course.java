package bean;

import java.util.Date;

public class Course {
    private int classId;
    private String name;
    private String taccount;
    private Date startDate;
    private Date endDate;
    private int studentSum;
    private int studentId;
    private int notificationId;
    private int signId;
    private int discussId;
    private int taskId;

    public int getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public String getTaccount() {
        return taccount;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getStudentSum() {
        return studentSum;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTaccount(String taccount) { this.taccount = taccount;  }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStudentSum(int studentSum) {
        this.studentSum = studentSum;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(int notificationId) {
        this.notificationId = notificationId;
    }

    public int getSignId() {
        return signId;
    }

    public void setSignId(int signId) {
        this.signId = signId;
    }

    public int getDiscussId() {
        return discussId;
    }

    public void setDiscussId(int discussId) {
        this.discussId = discussId;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
}
