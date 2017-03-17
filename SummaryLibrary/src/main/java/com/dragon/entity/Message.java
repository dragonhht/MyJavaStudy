package com.dragon.entity;

/**
 * ClassDescription
 * <p>
 * User : Dragon_hht
 * Date : 17-3-17
 * Time : 下午8:57
 */
public class Message {
    /** 留言编号 */
    private long messageId;
    /** 留言日期 */
    private String messageDate;
    /** 读者编号 */
    private long readerId;
    /** 留言信息 */
    private String message;

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
        this.messageId = messageId;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public long getReaderId() {
        return readerId;
    }

    public void setReaderId(long readerId) {
        this.readerId = readerId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageDate='" + messageDate + '\'' +
                ", readerId=" + readerId +
                ", message='" + message + '\'' +
                '}';
    }
}
