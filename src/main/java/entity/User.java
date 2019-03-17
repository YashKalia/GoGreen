package entity;

public class User {
    private String username=null;
    private String password=null;

    public User() {}

    public User(String username, String password) {
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User other = (User) obj;
        if (!username.equals(other.username)) {
            return false;
        }
        if (!password.equals(other.password)) {
            return false;
        }
        return true;
    }

}
