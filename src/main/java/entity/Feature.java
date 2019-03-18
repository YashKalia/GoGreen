package entity;

public class Feature {
        String feature;
    private long id;
    private int featureValue;

    public Feature() {}

    public Feature(String feature){
        this.feature=feature;
    }

    public Feature(String feature,int featureValue) {
        this.feature = feature;
        this.featureValue=featureValue;

    }

    public String getFeature() {
        return feature;
    }
    public void setFeature(String feature) {
        this.feature = feature;
    }


    public long getFeatureId(){
        return this.id;
    }

    public void setFeatureId(long id){
       this.id=id;
        
    }

    public int getfeatureValue(){
        return this.featureValue;
    }
    public void setFeatureValue(int featureValue){
        this.featureValue=featureValue;
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
