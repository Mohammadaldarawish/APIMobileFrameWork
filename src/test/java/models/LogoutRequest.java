package models;

public class LogoutRequest {
    private String client_id;
    private String client_secret;
    private String refresh_token;

    public LogoutRequest(String client_id, String client_secret, String refresh_token) {
        this.client_id = client_id;
        this.client_secret = client_secret;
        this.refresh_token = refresh_token;
    }

    public String getClient_id() {
        return client_id;
    }

    public void setClient_id(String client_id) {
        this.client_id = client_id;
    }

    public String getClient_secret() {
        return client_secret;
    }

    public void setClient_secret(String client_secret) {
        this.client_secret = client_secret;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
}