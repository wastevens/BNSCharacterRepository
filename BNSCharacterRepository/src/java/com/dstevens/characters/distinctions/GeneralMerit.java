package com.dstevens.characters.distinctions;

@MeritAnnotation("General")
public enum GeneralMerit implements Merit<GeneralMerit> {
    ;

    private final int points;

    private GeneralMerit(int points) {
        this.points = points;
    }
    
    @Override
    public int getPoints() {
        return points;
    }

    @Override
    public GeneralMerit trait() {
        return this;
    }
}
