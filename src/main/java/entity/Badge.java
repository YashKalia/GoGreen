package entity;

public class Badge {
    private String badgeName;

    private int pointsNeeded;

    public Badge() {}

    public Badge(String badgeName, int pointsNeeded) {
        this.badgeName = badgeName;
        this.pointsNeeded = pointsNeeded;
    }

    public String getBadgeName() {
        return badgeName;
    }

    public void setBadgeName(String badgeName) {
        this.badgeName = badgeName;
    }

    public int getPointsNeeded() {
        return pointsNeeded;
    }

    public void setPointsNeeded(int points) {
        this.pointsNeeded = points;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Badge)) {
            return false;
        }
        Badge other = (Badge) obj;
        if (!badgeName.equals(other.badgeName)) {
            return false;
        }
        if (pointsNeeded != other.pointsNeeded) {
            return false;
        }
        return true;
    }

}
