package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("GainXP")
public class GainXp extends SetBNSCharacterTrait {

    @Column(name="rating")
    private int xp;

    //Hibernate only
    @Deprecated
    @SuppressWarnings("unused")
    private GainXp() {
        this(null, 0);
    }
    
    public GainXp(TraitChangeStatus status, int xp) {
        super(status);
        this.xp = xp;
    }
    
    @Override
    public final BNSPlayerCharacter apply(BNSPlayerCharacter character) {
        return character.setXp(character.getXp() + xp);
    }
    
    @Override
    public BNSPlayerCharacter remove(BNSPlayerCharacter character) {
    	return character.setXp(character.getXp() - xp);
    }

    @Override
    public String describe() {
        String nextTrait = (hasAssociatedTrait() ? String.format (" for %1$s", associatedTrait().describe()) : "");
        return String.format("(%1$s) Gain %2$s xp%3$s", status(), xp, nextTrait);    }
}
