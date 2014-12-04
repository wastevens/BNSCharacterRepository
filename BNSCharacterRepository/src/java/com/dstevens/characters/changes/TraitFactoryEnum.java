package com.dstevens.characters.changes;

import java.util.Set;

import com.dstevens.characters.backgrounds.Background;
import com.dstevens.characters.backgrounds.CharacterBackground;
import com.dstevens.characters.skills.CharacterSkill;
import com.dstevens.characters.skills.Skill;

public enum TraitFactoryEnum implements TraitFactory {

    BACKGROUND {
        @Override
        public CharacterDefinedTrait<?> traitFor(int ordinal, int rating, String specialization, Set<String> focuses) {
            return CharacterBackground.backgroundFor(trait(ordinal), rating, specialization, focuses);
        }

        @SuppressWarnings("unchecked")
        @Override
        public <E extends Enum<?>> E trait(int ordinal) {
            return (E) Background.values()[ordinal];
        }
    },
    SKILL {
        @Override
        public CharacterDefinedTrait<?> traitFor(int ordinal, int rating, String specialization, Set<String> focuses) {
            return CharacterSkill.skillFor(trait(ordinal), rating, specialization, focuses);
        }

        @SuppressWarnings("unchecked")
        @Override
        public <E extends Enum<?>> E trait(int ordinal) {
            return (E) Skill.values()[ordinal];
        }
    };
}
