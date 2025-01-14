package models;

public class VerifyContactRequest {
    private String contactId;

    public VerifyContactRequest(String contactId) {
        this.contactId = contactId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }
}