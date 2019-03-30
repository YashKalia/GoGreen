package entity;

public class Feature {
    private String feature;

    public Feature() {
    }

    public Feature(String feature) {
        this.feature = feature;
    }

    public String getFeatureName() {
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
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature other = (Feature) obj;
        if (!feature.equals(other.feature)) {
            return false;
        }
        return true;
    }
}
