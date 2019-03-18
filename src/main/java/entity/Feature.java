package entity;

public class Feature {
    String feature;
    private long id;

    public Feature() {}

    public Feature(String feature,long id) {
        this.feature = feature;
        this.id=id
    }

    public String getFeature() {
        return feature;
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
