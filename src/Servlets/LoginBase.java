package Servlets;

public class LoginBase {
    private String login;
    private String password;
    private String ip;

    public LoginBase(String login, String password, String ip) {
        this.login = login;
        this.password = password;
        this.ip = ip;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

