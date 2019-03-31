package entity;

public class Friends {
    private User user;
    private User friend;

    public Friends(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    public Friends() {}

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriend(User friend) {
        this.friend = friend;
    }
}
