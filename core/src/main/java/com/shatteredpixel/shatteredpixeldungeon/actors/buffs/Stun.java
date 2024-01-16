/*
This is the implementation of the stun de-buff
Testing will be required to see if the character's turn is skipped
There is no sprite for the stun de-buff and should be implemented next
 */

package com.shatteredpixel.shatteredpixeldungeon.actors.buffs;

import com.shatteredpixel.shatteredpixeldungeon.Dungeon;
import com.shatteredpixel.shatteredpixeldungeon.actors.Char;
import com.shatteredpixel.shatteredpixeldungeon.messages.Messages;
import com.shatteredpixel.shatteredpixeldungeon.sprites.CharSprite;
import com.shatteredpixel.shatteredpixeldungeon.ui.BuffIndicator;
import com.watabou.utils.Bundle;
import com.watabou.utils.Random;

public class Stun extends FlavourBuff{

    public static final float DURATION	= 20f;

    {
        type = buffType.NEGATIVE;
        announced = true;
    }

    @Override
    public boolean attachTo( Char target ) {
        if (super.attachTo( target )) {
            return true;
        } else {
            return false;
        }
    }

    //Until the target's stunned value reaches zero, the de-buff will not detach and the char will not move
    @Override
    public boolean act() {
        if(target.buff(Stun.class) != null)
        {
            if(target.stunned > 0)
            {
                target.stunned--;
            }
            else
            {
                detach();
            }
        }
        spend(TICK);
        return true;
    }
}
