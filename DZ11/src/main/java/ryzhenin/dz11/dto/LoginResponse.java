package ryzhenin.dz11.dto;

public class LoginResponse {
    private long userId;
    private String login;
    public LoginResponse(long userId, String login) { this.userId = userId; this.login = login; }
    public long getUserId() { return userId; }
    public String getLogin() { return login; }
}