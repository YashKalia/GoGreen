package entity;

public class BadgesEarned {

	    private Badge badge;

	    private User user;

	    public BadgesEarned() {}

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

}
