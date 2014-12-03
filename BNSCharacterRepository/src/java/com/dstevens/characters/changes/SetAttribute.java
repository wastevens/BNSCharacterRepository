package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Attribute")
public class SetAttribute extends SetTrait {

    @Column(name="rating")
    private int rating;

    @Column(name="factory")
    private AttributeFactory factory;
    
    //Hibernate only
    @Deprecated
    @SuppressWarnings("unused")
    private SetAttribute() {
        this(null, 0, null);
    }
    
    public SetAttribute(TraitChangeStatus status, int rating, AttributeFactory factory) {
    	super(status);
    	this.rating = rating;
    	this.factory = factory;
    }
    
    @Override
    public BNSPlayerCharacter apply(BNSPlayerCharacter character) {
        return factory.applyTo(rating, character);
    }
    
    @Override
    public BNSPlayerCharacter remove(BNSPlayerCharacter character) {
    	throw new IllegalStateException("Cannot remove setting an attribute.");
    }
    
    @Override
    public String describe() {
        String nextTrait = (hasAssociatedTrait() ? String.format(" with %1$s", associatedTrait().describe()) : "");
        return String.format("(%1$s) Set %2$s%3$s", status(), factory.attributeName(), nextTrait);
    }
}
