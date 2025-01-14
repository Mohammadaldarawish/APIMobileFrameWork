package models;

public class SendContactMessageRequest {
    private String contact_id;
    private String message;

    public SendContactMessageRequest(String contact_id, String message) {
        this.contact_id = contact_id;
        this.message = message;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}