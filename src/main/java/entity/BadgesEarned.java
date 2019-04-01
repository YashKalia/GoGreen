package entity;

public class BadgesEarned {

    private Badge badge;

    private User user;

    public BadgesEarned() {
    }

    public BadgesEarned(Badge badge, User user) {
        this.user = user;
        this.badge = badge;
    }

    public Badge getBadge() {
        return badge;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BadgesEarned)) {
            return false;
        }
        BadgesEarned other = (BadgesEarned) obj;
        if (!badge.equals(other.badge)) {
            return false;
        }
        if (!user.equals(other.user)) {
            return false;
        }
        return true;
    }

}
