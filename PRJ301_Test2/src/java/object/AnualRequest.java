/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package object;

import java.sql.Date;

/**
 *
 * @author Khuat Thi Minh Anh
 */
public class AnualRequest {
    private int RequestID;
    private String reason;
    private Date from;
    private Date to;
    private int createdBy;
    private int reviewedBy;
    private String status;

    public AnualRequest() {
    }

    public AnualRequest(int RequestID, String reason, Date from, Date to, int createdBy, int reviewedBy, String status) {
        this.RequestID = RequestID;
        this.reason = reason;
        this.from = from;
        this.to = to;
        this.createdBy = createdBy;
        this.reviewedBy = reviewedBy;
        this.status = status;
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public int getReviewedBy() {
        return reviewedBy;
    }

    public void setReviewedBy(int reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
