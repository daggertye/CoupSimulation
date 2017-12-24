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
	public void DeleteRuleTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		p.removeLife(new Ambassador());
		HashMap<CallableAction, Boolean> rules = p.getRules();
		CallableAction[] actions = CallableAction.getCallableActions();
		for(CallableAction ac: actions) {
			if(ac == CallableAction.ASSASSINATE)
				assert(rules.get(ac));
			else
				assertFalse(rules.get(ac));
		}
	}
	
	@Test
	public void DeleteCharacterTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		p.removeLife(new Ambassador());
		Character c1 = p.getFirstCharacter();
		Character c2 = p.getSecondCharacter();
		assert(c1.getType().equals("Ambassador") && c2.getType().equals("Assassin"));
		assert(c1.isDead());
		assertFalse(c2.isDead());
	}
	
	@Test
	public void DualDeleteRuleTest() {
		Player p = new Player(new Ambassador(), new Ambassador());
		p.removeLife(new Ambassador());
		Character c1 = p.getFirstCharacter();
		Character c2 = p.getSecondCharacter();
		assert(c1.getType().equals("Ambassador") && c2.getType().equals("Ambassador"));
		assert(c1.isDead());
		assertFalse(c2.isDead());
	}
}
