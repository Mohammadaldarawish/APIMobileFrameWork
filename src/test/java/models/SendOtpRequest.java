package models;

public class SendOtpRequest {
    private String contact_id;

    public SendOtpRequest(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }
}