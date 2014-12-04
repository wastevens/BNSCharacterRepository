package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EnumeratedTrait")
public class SetEnumeratedTrait extends SetBNSCharacterTrait {

    @Column(name="ordinal")
    private final int ordinal;
    
    @Column(name="factory")
    final TraitFactory factory;
    
    //Hibernate only
    @Deprecated
    @SuppressWarnings("unused")
    private SetEnumeratedTrait() {
        this(null, 0, null);
    }
    
    public SetEnumeratedTrait(TraitChangeStatus status, EnumeratedTrait<?> trait, TraitFactory factory) {
        this(status, trait.ordinal(), factory);
    }
    
    protected SetEnumeratedTrait(TraitChangeStatus status, int ordinal, TraitFactory factory) {
        super(status);
        this.ordinal = ordinal;
        this.factory = factory;
    }

    protected final int ordinal() {
        return ordinal;
    }

    public final EnumeratedTrait<?> trait() {
        return factory.traitFor(ordinal);
    }
    
    @Override
    public BNSPlayerCharacter apply(BNSPlayerCharacter character) {
        return factory.traitFor(ordinal).applyTo(character);
    }

	@Override
	public BNSPlayerCharacter remove(BNSPlayerCharacter character) {
		return factory.traitFor(ordinal).removeFrom(character);
	}
    
    @Override
    public String describe() {
        return String.format("(%1$s) Add %2$s", status(), factory.traitFor(ordinal));
    }
}
