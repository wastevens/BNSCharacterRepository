package com.dstevens.characters.distinctions;

import com.dstevens.characters.BNSPlayerCharacter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="Merit")
public class CharacterMerit extends CharacterDistinction {
    
    //Hibernate only
    @Deprecated
    @SuppressWarnings("unused")
    private CharacterMerit() {
        this(0, null, null);
    }
    
    public CharacterMerit(Merit<?> merit) {
        this(merit, null);
    }
    
    public CharacterMerit(Merit<?> merit, String details) {
        this(merit.ordinal(), merit.getType(), details);
    }
    
    private CharacterMerit(int meritId, String meritType, String details) {
        super(meritId, meritType, details);
    }
    
    public Distinction<?> getDistinction() {
        return MeritTranslator.ofTypeWithId(type(), ordinal());
    }

    @Override
    public BNSPlayerCharacter applyTo(BNSPlayerCharacter character) {
        return character.withMerit(this);
    }
    
    @Override
    public BNSPlayerCharacter removeFrom(BNSPlayerCharacter character) {
    	return character.withoutMerit(this);
    }
}
