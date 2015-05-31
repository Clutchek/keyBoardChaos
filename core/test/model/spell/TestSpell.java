package model.spell;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.chl.KeyboardChaos.model.spell.Spell;

public class TestSpell {
	
	Spell testSpell;
	
	@Before
	public void createSpell() {
		testSpell = new Spell(){
			public float getCooldown(){
				return 5f;
			}

			@Override
			public float getDuration() {
				return 0;
			}

			@Override
			public String getDescription() {
				return null;
			}

			@Override
			public String getName() {
				return null;
			}

			@Override
			public boolean equals(Object o) {
				return false;
			}
		};
		
	}
	@Test
	public void testIsOnCoolDownAtStart(){
		assertFalse(testSpell.isOnCoolDown());
	}
	
	@Test
	public void testResetSpellTimer(){
		testSpell.resetCooldownTimer();
		assertTrue(testSpell.isOnCoolDown());
	}
	
	@Test
	public void testTickCooldown(){
		testSpell.resetCooldownTimer();
		for(int i = 0; i < 10; i++){
			testSpell.tickCooldownTimer();
		}
		assertTrue(testSpell.getTicksSpentInCooldown() == 10f);
	}
	
	@Test
	public void testResetAndTickUntilNoCooldown(){
		testSpell.resetCooldownTimer();
		for(int i = 0; i <= testSpell.getCooldown()*60; i++){
			testSpell.tickCooldownTimer();
		}
		assertFalse(testSpell.isOnCoolDown());
	}

}
