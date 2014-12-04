package com.dstevens.characters.changes;

import java.util.Set;

public interface TraitFactory {

    default EnumeratedTrait<?> traitFor(int ordinal) {
        throw new IllegalStateException("Enumerated trait is undefined for " + this.getClass().getName() + " ordinal " + ordinal);
    }
    
    default RatedTrait<?> traitFor(int ordinal, int rating) {
        throw new IllegalStateException("Rated trait is undefined for " + this.getClass().getName() + " ordinal " + ordinal);
    }
    
    default CharacterDefinedTrait<?> traitFor(int ordinal, int rating, String specialization, Set<String> focuses) {
        throw new IllegalStateException("Character defined trait is undefined for " + this.getClass().getName() + " ordinal " + ordinal);
    }
	
	<E extends Enum<?>> E trait(int ordinal);
	
}
