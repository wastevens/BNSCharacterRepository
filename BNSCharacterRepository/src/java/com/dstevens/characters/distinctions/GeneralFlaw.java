package com.dstevens.characters.distinctions;

@FlawAnnotation("General")
public enum GeneralFlaw implements Flaw<GeneralFlaw> {

    ;

    private int points;

    private GeneralFlaw(int points) {
        this.points = points;
    }
    
    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public GeneralFlaw trait() {
        return this;
    }
}
