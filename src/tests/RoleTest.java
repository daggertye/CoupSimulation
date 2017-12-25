package tests;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;

import effects.CallableAction;
import model.Player;
import roles.*;
import roles.Character;

public class RoleTest {
	
	@Test
	public void RuleTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
			if(ac == CallableAction.ASSASSINATE || ac == CallableAction.EXCHANGE || ac == CallableAction.BLOCKSTEAL)
				assert(rules.get(ac));
			else
				assertFalse(rules.get(ac));
		}
	}
	
	@Test
	public void CharacterTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		Character c1 = p.getFirstCharacter();
		Character c2 = p.getSecondCharacter();
		assert(c1.getType().equals("Ambassador") && c2.getType().equals("Assassin"));
		assertFalse(c1.isDead());
		assertFalse(c2.isDead());
	}
	
	@Test
	public void DualRuleTest() {
		Player p = new Player(new Ambassador(), new Ambassador());
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
			if(ac == CallableAction.EXCHANGE || ac == CallableAction.BLOCKSTEAL)
				assert(rules.get(ac));
			else
				assertFalse(rules.get(ac));
		}
	}
	
	@Test 
	public void DualCharacterTest() {
		Player p = new Player(new Ambassador(), new Ambassador());
		Character c1 = p.getFirstCharacter();
		Character c2 = p.getSecondCharacter();
		assert(c1.getType().equals("Ambassador") && c2.getType().equals("Ambassador"));
		assertFalse(c1.isDead());
		assertFalse(c2.isDead());
	}
	
	@Test
	public void DeleteOneTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		p.removeLife(2);
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
			if(ac == CallableAction.EXCHANGE || ac == CallableAction.BLOCKSTEAL)
				assert(rules.get(ac));
			else
				assertFalse(rules.get(ac));
		}
	}
	
	@Test
	public void DeleteOneDualCharTest() {
		Player p = new Player(new Ambassador(), new Ambassador());
		p.removeLife(2);
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
			if(ac == CallableAction.EXCHANGE || ac == CallableAction.BLOCKSTEAL)
				assert(rules.get(ac));
			else
				assertFalse(rules.get(ac));
		}
	}
	
	@Test
	public void LoseBothLivesNormCharTest() {
		Player p = new Player(new Assassin(), new Ambassador());
		p.removeLife(2);
		p.removeLife(1);
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
				assertFalse(rules.get(ac));
		}
	}
	
	@Test
	public void LoseBothLivesDualCharTest() {
		Player p = new Player(new Ambassador(), new Ambassador());
		p.removeLife(2);
		p.removeLife(1);
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
				assertFalse(rules.get(ac));
		}
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void LoseLifeTwice() {
		Player p = new Player(new Ambassador(), new Assassin());
		p.removeLife(1);
		p.removeLife(1);
	}
}
