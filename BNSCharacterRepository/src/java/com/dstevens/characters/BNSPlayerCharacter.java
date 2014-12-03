package com.dstevens.characters;

import static com.dstevens.collections.Lists.list;

import static com.dstevens.collections.Sets.set;

import java.util.Date;
import java.util.List;
import java.util.Set;

import com.dstevens.characters.attributes.MentalAttributeFocus;
import com.dstevens.characters.attributes.PhysicalAttributeFocus;
import com.dstevens.characters.attributes.SocialAttributeFocus;
import com.dstevens.characters.backgrounds.CharacterBackground;
import com.dstevens.characters.changes.SetTrait;
import com.dstevens.characters.distinctions.CharacterFlaw;
import com.dstevens.characters.distinctions.CharacterMerit;
import com.dstevens.characters.skills.CharacterSkill;
import com.dstevens.utilities.ObjectExtensions;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;


public class BNSPlayerCharacter extends PlayerCharacter {

	    @Column(name="physical_attribute")
	    private int physicalAttribute;
	    
	    @Column(name="mental_attribute")
	    private int mentalAttribute;

	    @Column(name="social_attribute")
	    private int socialAttribute;
	    
	    @ElementCollection
	    private Set<PhysicalAttributeFocus> physicalAttributeFocuses;

	    @ElementCollection
	    private Set<MentalAttributeFocus> mentalAttrbuteFocuses;
	    
	    @ElementCollection
	    private Set<SocialAttributeFocus> socialAttributeFocuses;
	    
	    @OneToMany(cascade={CascadeType.ALL})
	    private final Set<CharacterSkill> skills;
	    
	    @OneToMany(cascade={CascadeType.ALL})
	    private final Set<CharacterBackground> backgrounds;

	    @OneToMany(cascade={CascadeType.ALL})
	    @JoinTable(name="PlayerCharacter_Merits")
	    private final Set<CharacterMerit> merits;
	    
	    @OneToMany(cascade={CascadeType.ALL})
	    @JoinTable(name="PlayerCharacter_Flaws")
	    private final Set<CharacterFlaw> flaws;
	    
	    @OneToMany(cascade={CascadeType.ALL})
	    @OrderColumn(name="order_by")
	    private final List<SetTrait> traitChangeEvents;

		private int xp;
	    
	    //Hibernate only
	    @Deprecated
	    public BNSPlayerCharacter() {
	    	this(null, null, 0, 0, 0, 0, set(), set(), set(), set(), set(), set(), set(), list(), null);
	    }
	    
	    BNSPlayerCharacter(String id, String name) {
	        this(id, name, 0, 0, 0, 0, set(), set(), set(), set(), set(), set(), set(),list(), null);
	    }
	    
	    protected BNSPlayerCharacter(String id, String name, int xp,  
	                                 int physicalAttribute, int mentalAttribute, int socialAttribute, 
	                                 Set<PhysicalAttributeFocus> physicalAttrbuteFocuses, Set<MentalAttributeFocus> mentalAttrbuteFocuses,  Set<SocialAttributeFocus> socialAttrbuteFocuses,   
	                                 Set<CharacterSkill> skills, Set<CharacterBackground> backgrounds, Set<CharacterMerit> merits, Set<CharacterFlaw> flaws,
	                                 List<SetTrait> traitChangeEvents, Date deleteTimestamp) {
	    	super(id, name);
	        this.xp = xp;
	        this.physicalAttribute = physicalAttribute;
	        this.mentalAttribute = mentalAttribute;
	        this.socialAttribute = socialAttribute;
	        this.physicalAttributeFocuses = physicalAttrbuteFocuses;
	        this.mentalAttrbuteFocuses = mentalAttrbuteFocuses;
	        this.socialAttributeFocuses = socialAttrbuteFocuses;
	        this.skills = skills;
	        this.backgrounds = backgrounds;
	        this.merits = merits;
	        this.flaws = flaws;
	        this.traitChangeEvents = traitChangeEvents;
	    }
	    
	    @Override
	    public BNSPlayerCharacter withName(String name) {
	        return new BNSPlayerCharacter(getId(), name, xp, physicalAttribute, mentalAttribute, socialAttribute,
	                                      physicalAttributeFocuses, mentalAttrbuteFocuses, socialAttributeFocuses,
	                                      skills, backgrounds, merits, flaws, traitChangeEvents, null);
	    }
	    
	    public int getPhysicalAttribute() {
	        return physicalAttribute;
	    }
	    
	    public int getMentalAttribute() {
	        return mentalAttribute;
	    }
	    
	    public int getSocialAttribute() {
	        return socialAttribute;
	    }
	    
	    public Set<PhysicalAttributeFocus> getPhysicalAttributeFocuses() {
	        return physicalAttributeFocuses;
	    }
	    
	    public Set<MentalAttributeFocus> getMentalAttributeFocuses() {
	        return mentalAttrbuteFocuses;
	    }
	    
	    public Set<SocialAttributeFocus> getSocialAttributeFocuses() {
	        return socialAttributeFocuses;
	    }
	    
	    public BNSPlayerCharacter withPhysicalAttribute(int physicalAttribute) {
	    	this.physicalAttribute = physicalAttribute;
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withMentalAttribute(int mentalAttribute) {
	    	this.mentalAttribute = mentalAttribute;
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withSocialAttribute(int socialAttribute) {
	    	this.socialAttribute = socialAttribute;
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withPhysicalAttributeFocus(PhysicalAttributeFocus focus) {
	    	this.physicalAttributeFocuses.add(focus);
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withMentalAttributeFocus(MentalAttributeFocus focus) {
	    	this.mentalAttrbuteFocuses.add(focus);
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withSocialAttributeFocus(SocialAttributeFocus focus) {
	    	this.socialAttributeFocuses.add(focus);
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withoutPhysicalAttributeFocus(PhysicalAttributeFocus focus) {
	    	this.physicalAttributeFocuses.remove(focus);
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withoutMentalAttributeFocus(MentalAttributeFocus focus) {
	    	this.mentalAttrbuteFocuses.remove(focus);
	    	return this;
	    }
	    
	    public BNSPlayerCharacter withoutSocialAttributeFocus(SocialAttributeFocus focus) {
	    	this.socialAttributeFocuses.remove(focus);
	    	return this;
	    }
	    
	    public Set<CharacterSkill> getSkills() {
	        return skills;
	    }
	    
	    public BNSPlayerCharacter withSkill(CharacterSkill skill) {
	    	this.withoutSkill(skill).skills.add(skill);
	        return this;
	    }

		public BNSPlayerCharacter withoutSkill(CharacterSkill skill) {
			this.skills.removeIf(skill.matches());
	        return this;
	    }

	    public Set<CharacterBackground> getBackgrounds() {
	        return backgrounds;
	    }
	    
	    public BNSPlayerCharacter withBackground(CharacterBackground background) {
	    	this.withoutBackground(background).backgrounds.add(background);
	        return this;
	    }
	    
	    public BNSPlayerCharacter withoutBackground(CharacterBackground background) {
	    	this.backgrounds.removeIf(background.matches());
	        return this;
	    }
	    
	    public Set<CharacterMerit> getMerits() {
	        return merits;
	    }
	    
	    public BNSPlayerCharacter withMerit(CharacterMerit merit) {
	        this.merits.add(merit);
	        return this;
	    }
	    
	    public BNSPlayerCharacter withoutMerit(CharacterMerit merit) {
	        this.merits.removeIf(merit.matches());
	        return this;
	    }
	    
	    public Set<CharacterFlaw> getFlaws() {
	        return flaws;
	    }
	    
	    public BNSPlayerCharacter withFlaw(CharacterFlaw flaw) {
	    	this.withoutFlaw(flaw).flaws.add(flaw);
	        return this;
	    }
	    
	    public BNSPlayerCharacter withoutFlaw(CharacterFlaw flaw) {
	    	this.flaws.removeIf(flaw.matches());
	        return this;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (obj instanceof BNSPlayerCharacter) {
	            BNSPlayerCharacter that = BNSPlayerCharacter.class.cast(obj);
	            return this.getId().equals(that.getId());
	        }
	        return false;
	    }
	    
	    @Override
	    public int hashCode() {
	        return getId().hashCode();
	    }
	    
	    @Override
	    public String toString() {
	        return ObjectExtensions.toStringFor(this);
	    }

	    public int getXp() {
	        return xp;
	    }
	    
	    public BNSPlayerCharacter setXp(int xp) {
	        this.xp = xp;
	        return this;
	    }
}
