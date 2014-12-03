package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("RemoveTrait")
public class RemoveTrait extends SetTrait {

	@OneToOne(cascade={CascadeType.ALL})
	private final SetTrait traitToRemove;

	//Hibernate only
    @Deprecated
    @SuppressWarnings("unused")
    private RemoveTrait() {
        this(null, null);
    }
	
	protected RemoveTrait(SetTrait traitToRemove) {
		this(traitToRemove.status(), traitToRemove);
	}
	private RemoveTrait(TraitChangeStatus status, SetTrait traitToRemove) {
		super(status);
		this.traitToRemove = traitToRemove;
	}

	@Override
	public BNSPlayerCharacter apply(BNSPlayerCharacter character) {
		SetTrait currentTraitToRemove = traitToRemove;
		while(currentTraitToRemove != null) {
			currentTraitToRemove.setStatus(TraitChangeStatus.APPLIED);
			currentTraitToRemove.remove(character);
			currentTraitToRemove = currentTraitToRemove.associatedTrait();
		}
		return character;
	}
	
	@Override
	public BNSPlayerCharacter remove(BNSPlayerCharacter character) {
		SetTrait currentTraitToRemove = traitToRemove;
		currentTraitToRemove.apply(character);
		while(currentTraitToRemove.hasAssociatedTrait()) {
			currentTraitToRemove = traitToRemove.associatedTrait();
			currentTraitToRemove.apply(character);
		}
		return character;
	}

	@Override
	public String describe() {
		String removeTrait = String.format("Removing %1$s", traitToRemove.describe());
		String nextTrait = (hasAssociatedTrait() ? String.format(", restoring %1$s", associatedTrait().describe()) : "");
		return String.format("(%1$s) %2$s%3$s", status(), removeTrait, nextTrait);
	}

}
