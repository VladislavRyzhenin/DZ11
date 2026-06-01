package ryzhenin.dz11.entity;

public class UserEntity {
    private long id;
    private String login;
    private String password;

    public UserEntity() {}

    public UserEntity(long id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
    public String getLogin() { return login; }
    public void setLogin(String login) { this.login = login; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}