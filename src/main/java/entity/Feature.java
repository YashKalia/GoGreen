package entity;

public class Feature {
    String feature;
    private long id;
    private String featureName;

    public Feature() {}

    public Feature(String feature,long id, String featureName) {
        this.feature = feature;
        this.id=id;
        this.featureName=featureName;
    }

    public String getFeature() {
        return this.feature;
    }
    
    public String getFeatureName() {
        return this.featureName;
    }
    
    public String setFeatureName(String featureName) {
        this.featureName=featureName;
    }
    
    public long getFeatureId(){
        return this.id;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
    public void setFeatureId(long id){
        this.id=id;
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
