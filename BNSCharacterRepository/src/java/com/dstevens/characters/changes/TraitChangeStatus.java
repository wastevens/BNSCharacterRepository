package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;

public enum TraitChangeStatus {

    PENDING() {
        @Override
        public BNSPlayerCharacter apply(BNSPlayerCharacter character, SetTrait event) {
        	SetTrait currentSetTrait = event;
        	while(currentSetTrait != null) {
        		currentSetTrait.setStatus(APPLIED);
        		character = currentSetTrait.apply(character);
        		currentSetTrait = currentSetTrait.associatedTrait();
        	}
            return character;
        }
        
        @Override
        public BNSPlayerCharacter deny(BNSPlayerCharacter character, SetTrait event) {
            event.setStatus(TraitChangeStatus.DENIED);
            return character;
        }
    },
    DENIED() {
        @Override
        public BNSPlayerCharacter apply(BNSPlayerCharacter character, SetTrait event) {
            return character;
        }

        @Override
        public BNSPlayerCharacter deny(BNSPlayerCharacter character, SetTrait traitChangeEvent) {
            return character;
        }
    },
    APPLIED() {
        @Override
        public BNSPlayerCharacter apply(BNSPlayerCharacter character, SetTrait event) {
            return character;
        }

        @Override
        public BNSPlayerCharacter deny(BNSPlayerCharacter character, SetTrait traitChangeEvent) {
            return character;
        }
    };
    
    public abstract BNSPlayerCharacter apply(BNSPlayerCharacter character, SetTrait event);

    public abstract BNSPlayerCharacter deny(BNSPlayerCharacter character, SetTrait traitChangeEvent);
    
}
