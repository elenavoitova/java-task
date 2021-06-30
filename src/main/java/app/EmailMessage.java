package app;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.MessageFormat;
import java.util.Arrays;

import static java.text.MessageFormat.*;

public class EmailMessage {
    private int id;
    private String from;
    private String subject;
    private String date;
    private String body;
    private String textBody;
    private String htmlBody;
    private EmailAttachment[] attachments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EmailAttachment[] getAttachments() {
        return attachments;
    }

    public void setAttachments(EmailAttachment[] attachments) {
        this.attachments = attachments;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTextBody() {
        return textBody;
    }

    public void setTextBody(String textBody) {
        this.textBody = textBody;
    }

    public String getHtmlBody() {
        return htmlBody;
    }

    public void setHtmlBody(String htmlBody) {
        this.htmlBody = htmlBody;
    }

    @Override
    public String toString() {
        return "\n Message { " + "\n" +
                "\t" + "id: " + id + "," + "\n" +
                "\t" + "from: '" + from + '\'' + "\n" +
                "\t" + "subject: '" + subject + '\'' + "\n" +
                "\t" + "date: " + date + "\n" +
                "\t" + "body: " + body.trim() + "\n" +
                "\t" + "textBody: " + textBody.trim() + "\n" +
                "\t" + "htmlBody: " + htmlBody.trim() + "\n" +
                "\t" + "attachments: " + Arrays.toString(attachments) + "\n" +
                "}";
    }
}
