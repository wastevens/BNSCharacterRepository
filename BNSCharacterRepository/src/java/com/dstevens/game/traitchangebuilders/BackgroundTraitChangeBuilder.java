package com.dstevens.game.traitchangebuilders;

import static com.dstevens.collections.Sets.set;

import java.util.Set;

import com.dstevens.characters.backgrounds.Background;
import com.dstevens.characters.backgrounds.CharacterBackground;
import com.dstevens.characters.changes.SetCharacterDefinedTrait;
import com.dstevens.characters.changes.SetTrait;
import com.dstevens.characters.changes.SpendXp;
import com.dstevens.characters.changes.TraitChangeStatus;
import com.dstevens.characters.changes.TraitFactory;
import com.dstevens.game.TraitChangeBuilder;

public class BackgroundTraitChangeBuilder implements TraitChangeBuilder {

    private final Background background;
    private String specialization;
    private Set<String> focuses = set();
    private int rating = 0;

    public BackgroundTraitChangeBuilder(Background background) {
		this.background = background;
    }

    public BackgroundTraitChangeBuilder withSpecialization(String specialization) {
        this.specialization = specialization;
        return this;
    }
    
    public BackgroundTraitChangeBuilder withFocus(String focus) {
        this.focuses.add(focus);
        return this;
    }
    
    public BackgroundTraitChangeBuilder withRating(int rating) {
        this.rating = rating;
        return this;
    }
    
    @Override
    public SetTrait buy() {
		return new SpendXp(TraitChangeStatus.PENDING, rating).and(setSkill());
    }

    @Override
    public SetTrait add() {
        return setSkill();
    }

    private SetCharacterDefinedTrait setSkill() {
        return new SetCharacterDefinedTrait(TraitChangeStatus.PENDING, CharacterBackground.backgroundFor(background, rating, specialization, focuses), TraitFactory.BACKGROUND);
    }

	@Override
	public SetTrait sell() {
		throw new IllegalStateException("not yet implemented");
	}

	@Override
	public SetTrait remove() {
		throw new IllegalStateException("not yet implemented");
	}
    
}
