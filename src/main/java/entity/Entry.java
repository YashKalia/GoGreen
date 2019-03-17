package entity;

public class Entry {
    String username;
    String feature;

    public Entry() {}

    public Entry(String feature, String username) {
        this.username = username;
        this.feature = feature;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Entry)) {
            return false;
        }
        Entry other = (Entry) obj;
        if (!feature.equals(other.feature)) {
            return false;
        }
        if (!username.equals(other.username)) {
            return false;
        }
        return true;
    }
}
