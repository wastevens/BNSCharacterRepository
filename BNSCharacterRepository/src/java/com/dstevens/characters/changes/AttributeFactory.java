package com.dstevens.characters.changes;

import com.dstevens.characters.BNSPlayerCharacter;
import com.dstevens.characters.attributes.AttributeFocus;
import com.dstevens.characters.attributes.MentalAttributeFocus;
import com.dstevens.characters.attributes.PhysicalAttributeFocus;
import com.dstevens.characters.attributes.SocialAttributeFocus;

public enum AttributeFactory {

    PHYSICAL {
        @Override
        public BNSPlayerCharacter applyTo(int rating, BNSPlayerCharacter character) {
            return character.withPhysicalAttribute(rating);
        }

        @Override
        public String attributeName() {
            return "Physical";
        }

        @Override
        public BNSPlayerCharacter applyFocusTo(int attributeFocusOrdinal, BNSPlayerCharacter character) {
            return character.withPhysicalAttributeFocus(PhysicalAttributeFocus.values()[attributeFocusOrdinal]);
        }
        
        @Override
        public BNSPlayerCharacter removeFocusFrom(int attributeFocusOrdinal, BNSPlayerCharacter character) {
        	return character.withoutPhysicalAttributeFocus(PhysicalAttributeFocus.values()[attributeFocusOrdinal]);
        }

        @Override
        public AttributeFocus focusFor(int attributeFocusOrdinal) {
            return PhysicalAttributeFocus.values()[attributeFocusOrdinal];
        }

        @Override
        public BNSPlayerCharacter increase(BNSPlayerCharacter character) {
            return character.withPhysicalAttribute(character.getPhysicalAttribute()+1);
        }
        
        @Override
        public BNSPlayerCharacter decrease(BNSPlayerCharacter character) {
        	return character.withPhysicalAttribute(character.getPhysicalAttribute()-1);
        }
    },
    SOCIAL {
        @Override
        public BNSPlayerCharacter applyTo(int rating, BNSPlayerCharacter character) {
            return character.withSocialAttribute(rating);
        }

        @Override
        public String attributeName() {
            return "Social";
        }

        @Override
        public BNSPlayerCharacter applyFocusTo(int attributeFocusOrdinal, BNSPlayerCharacter character) {
            return character.withSocialAttributeFocus(SocialAttributeFocus.values()[attributeFocusOrdinal]);
        }
        
        @Override
        public BNSPlayerCharacter removeFocusFrom(int attributeFocusOrdinal, BNSPlayerCharacter character) {
        	return character.withoutSocialAttributeFocus(SocialAttributeFocus.values()[attributeFocusOrdinal]);
        }

        @Override
        public AttributeFocus focusFor(int attributeFocusOrdinal) {
            return SocialAttributeFocus.values()[attributeFocusOrdinal];
        }

        @Override
        public BNSPlayerCharacter increase(BNSPlayerCharacter character) {
            return character.withSocialAttribute(character.getSocialAttribute()+1);
        }
        
        @Override
        public BNSPlayerCharacter decrease(BNSPlayerCharacter character) {
        	return character.withSocialAttribute(character.getSocialAttribute()-1);
        }
    },
    MENTAL {
        @Override
        public BNSPlayerCharacter applyTo(int rating, BNSPlayerCharacter character) {
            return character.withMentalAttribute(rating);
        }
        
        @Override
        public String attributeName() {
            return "Mental";
        }

        @Override
        public BNSPlayerCharacter applyFocusTo(int attributeFocusOrdinal, BNSPlayerCharacter character) {
            return character.withMentalAttributeFocus(MentalAttributeFocus.values()[attributeFocusOrdinal]);
        }
        
        @Override
        public BNSPlayerCharacter removeFocusFrom(int attributeFocusOrdinal, BNSPlayerCharacter character) {
        	return character.withoutMentalAttributeFocus(MentalAttributeFocus.values()[attributeFocusOrdinal]);
        }

        @Override
        public AttributeFocus focusFor(int attributeFocusOrdinal) {
            return MentalAttributeFocus.values()[attributeFocusOrdinal];
        }

        @Override
        public BNSPlayerCharacter increase(BNSPlayerCharacter character) {
            return character.withMentalAttribute(character.getMentalAttribute()+1);
        }
        
        @Override
        public BNSPlayerCharacter decrease(BNSPlayerCharacter character) {
        	return character.withMentalAttribute(character.getMentalAttribute()-1);
        }
    };

    public abstract BNSPlayerCharacter applyTo(int rating, BNSPlayerCharacter character);

    public abstract String attributeName();

    public abstract BNSPlayerCharacter applyFocusTo(int attributeFocusOrdinal, BNSPlayerCharacter character);
    public abstract BNSPlayerCharacter removeFocusFrom(int attributeFocusOrdinal, BNSPlayerCharacter character);

    public abstract AttributeFocus focusFor(int attributeFocusOrdinal);

    public abstract BNSPlayerCharacter increase(BNSPlayerCharacter character);
    
    public abstract BNSPlayerCharacter decrease(BNSPlayerCharacter character);
    
}
