package com.dstevens.characters.backgrounds;

import com.dstevens.characters.traits.DetailLevel;

public enum Background {

    ;
    
    private final DetailLevel detailLevel;

    private Background() {
        this(DetailLevel.NONE);
    }

    private Background(DetailLevel detailLevel) {
        this.detailLevel = detailLevel;
    }
    
    public DetailLevel detailLevel() {
    	return detailLevel;
    }
}
