package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;
import com.dstevens.characters.PlayerCharacter;

public abstract class SetBNSCharacterTrait extends SetTrait {

	protected SetBNSCharacterTrait(TraitChangeStatus status) {
		super(status);
	}
	public abstract PlayerCharacter apply(BNSPlayerCharacter character);
    public abstract PlayerCharacter remove(BNSPlayerCharacter character);
	
	@Override
	public PlayerCharacter apply(PlayerCharacter character) {
		return this.apply(BNSPlayerCharacter.class.cast(character));
	}
	
	@Override
	public PlayerCharacter remove(PlayerCharacter character) {
		return this.remove(BNSPlayerCharacter.class.cast(character));
	}
	
}
