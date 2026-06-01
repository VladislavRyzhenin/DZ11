package ryzhenin.dz11.dto;

public class UserResponse {
    private long id;
    private String login;
    public UserResponse(long id, String login) { this.id = id; this.login = login; }
    public long getId() { return id; }
    public String getLogin() { return login; }
}