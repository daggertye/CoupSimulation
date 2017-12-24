package tests;

import static org.junit.Assert.*;
import org.junit.*;

import java.util.*;
import player.Player;
import effects.Action;
import roles.*;
import roles.Character;

public class RoleTest {
	
	@Test
	public void RuleTest() {
		Player p = new Player(new Ambassador(), new Assassin());
		HashMap<Action, Boolean> rules = p.getRules();
		Action[] actions = Action.getActions();
		for(Action ac: actions) {
			if(ac == Action.ASSASSINATE || ac == Action.EXCHANGE || ac == Action.BLOCKSTEAL)
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
		HashMap<Action, Boolean> rules = p.getRules();
		Action[] actions = Action.getActions();
		for(Action ac: actions) {
			if(ac == Action.EXCHANGE || ac == Action.BLOCKSTEAL)
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
		HashMap<Action, Boolean> rules = p.getRules();
		Action[] actions = Action.getActions();
		for(Action ac: actions) {
			if(ac == Action.ASSASSINATE)
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
