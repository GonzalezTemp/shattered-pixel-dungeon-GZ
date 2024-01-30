package com.shatteredpixel.shatteredpixeldungeon.items.weapon.melee;

import com.shatteredpixel.shatteredpixeldungeon.Assets;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.actors.hero.Hero;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.ItemSpriteSheet;

public class Scythe extends MeleeWeapon{
    {
        //TODO add a new sprite to the sprite sheet for scythe
        image = ItemSpriteSheet.WAR_SCYTHE;
        hitSound = Assets.Sounds.HIT_SLASH;
        hitSoundPitch = 0.9f;

        tier = 4;
        ACC = 0.76f; //24% penalty to accuracy
    }

    @Override
    public int max(int lvl) {
        return  Math.round(6.67f*(tier+1)) +    //40 base, up from 30
                lvl*(tier+1);                   //scaling unchanged
    }

    @Override
    protected int baseChargeUse(Hero hero, Char target){
        return 2;
    }

    @Override
    public String targetingPrompt() {
        return Messages.get(this, "prompt");
    }

    @Override
    protected void duelistAbility(Hero hero, Integer target) {
        Sickle.harvestAbility(hero, target, 0.9f, this);
    }
}
