package models;

public class LoginRequest {
    private String contact_id;
    private String otp;

    public LoginRequest(String contact_id, String otp) {
        this.contact_id = contact_id;
        this.otp = otp;
    }

    public String getContact_id() {
        return contact_id;
    }

    public void setContact_id(String contact_id) {
        this.contact_id = contact_id;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}