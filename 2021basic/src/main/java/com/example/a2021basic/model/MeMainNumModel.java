package com.example.a2021basic.model;

/**
 * desc: 个人中心的数据
 * @author：wangshaojie
 * date:2017/12/27
 * time:10:44
 */
public class MeMainNumModel {

    private String document_num;
    /**
     * 课程数量
     */
    private String course_num;
    /**
     * 练习数量
     */
    private String practice_num;
    /**
     * 落地改进数量
     */
    private String improve_num;
    /**
     * 学习报告数量
     */
    private String report_num;
    /**
     * 购买课程数量
     */
    private String buy_num;
    /**
     * 个人学习总时长
     */
    private String duration;

    /**
     * 免费领取记录总数
     */
    private String free_num;

    /**
     * 是不有待直播的课程
     */
    private String is_live;

    /**
     * 拼课记录数量
     */
    private String pinke_num;

    /**
     * 考试中心的数量
     */
    private String exams_num;

    public String getExams_num() {
        return exams_num;
    }

    public void setExams_num(String exams_num) {
        this.exams_num = exams_num;
    }

    public String getDocument_num() {
        return document_num;
    }

    public void setDocument_num(String document_num) {
        this.document_num = document_num;
    }

    public String getFree_num() {
        return free_num;
    }

    public void setFree_num(String free_num) {
        this.free_num = free_num;
    }

    public String getIs_live() {
        return is_live;
    }

    public void setIs_live(String is_live) {
        this.is_live = is_live;
    }

    public String getPinke_num() {
        return pinke_num;
    }

    public void setPinke_num(String pinke_num) {
        this.pinke_num = pinke_num;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCourse_num() {
        return course_num;
    }

    public void setCourse_num(String course_num) {
        this.course_num = course_num;
    }

    public String getPractice_num() {
        return practice_num;
    }

    public void setPractice_num(String practice_num) {
        this.practice_num = practice_num;
    }

    public String getImprove_num() {
        return improve_num;
    }

    public void setImprove_num(String improve_num) {
        this.improve_num = improve_num;
    }

    public String getReport_num() {
        return report_num;
    }

    public void setReport_num(String report_num) {
        this.report_num = report_num;
    }

    public String getBuy_num() {
        return buy_num;
    }

    public void setBuy_num(String buy_num) {
        this.buy_num = buy_num;
    }

    @Override
    public String toString() {
        return "MeMainNumModel{" +
                "document_num='" + document_num + '\'' +
                ", course_num='" + course_num + '\'' +
                ", practice_num='" + practice_num + '\'' +
                ", improve_num='" + improve_num + '\'' +
                ", report_num='" + report_num + '\'' +
                ", buy_num='" + buy_num + '\'' +
                ", duration='" + duration + '\'' +
                ", free_num='" + free_num + '\'' +
                ", is_live='" + is_live + '\'' +
                ", pinke_num='" + pinke_num + '\'' +
                ", exams_num='" + exams_num + '\'' +
                '}';
    }
}
