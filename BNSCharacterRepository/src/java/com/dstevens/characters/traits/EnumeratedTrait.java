package com.dstevens.characters.traits;

import java.util.function.Predicate;

import com.dstevens.characters.BNSPlayerCharacter;



public interface EnumeratedTrait<T extends Enum<?>> {

    int ordinal();
    T trait();
    BNSPlayerCharacter applyTo(BNSPlayerCharacter character);
    BNSPlayerCharacter removeFrom(BNSPlayerCharacter character);
    
    default Predicate<? super EnumeratedTrait<T>> matches() {
		return (EnumeratedTrait<T> t) -> t.trait().equals(this.trait());
	}
    
}
