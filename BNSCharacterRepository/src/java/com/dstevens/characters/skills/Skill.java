package com.dstevens.characters.skills;

import com.dstevens.characters.changes.DetailLevel;

public enum Skill {
    ;
	
    private final DetailLevel detailLevel;

    private Skill() {
        this(DetailLevel.NONE);
    }

    private Skill(DetailLevel detailLevel) {
        this.detailLevel = detailLevel;
    }
    
    public DetailLevel detailLevel() {
    	return detailLevel;
    }
    
}
