package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.exceptions.EmptyCollectionException;
import no.hvl.dat102.klienter.Kunde;

public abstract class KoeADTTest {

	// referanse for kø
	private KoeADT<Kunde> koe;

	// testdata
	private Kunde k0 = new Kunde(20);
	private Kunde k1 = new Kunde(100);
	private Kunde k2 = new Kunde(60);
	private Kunde k3 = new Kunde(80);
	private Kunde k4 = new Kunde(120);

	protected abstract KoeADT<Kunde> reset();

	/**
	 * Hent en ny kø for hver test
	 * 
	 * @return koe
	 */

	@BeforeEach
	public void setup() {
		koe = reset();
	}

	/**
	 * test på en ny koe er tom
	 */

	@Test
	public void pushOgPop() {
		koe.innKoe(k0);
		koe.innKoe(k1);
		koe.innKoe(k1);
		koe.innKoe(k2);

		try {
			assertEquals(k2, koe.utKoe());
			assertEquals(k1, koe.utKoe());
			assertEquals(k1, koe.utKoe());
			assertEquals(k0, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("pop feilet uventet" + e.getMessage());
		}
	}

	/**
	 * Testing på peek
	 */

	@Test
	public void pushPopPushPopPeek() {
		try {
			koe.innKoe(k2);
			koe.utKoe();
			koe.innKoe(k3);
			koe.innKoe(k4);
			koe.utKoe();
			assertEquals(k3, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("pop eller peek feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på koe med elementer ikke er tom
	 */

	@Test
	public final void erIkkeTom() {
		koe.innKoe(k0);
		koe.innKoe(k1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på kø med null elementer er tom
	 */

	@Test
	public void pushPopErTom() {
		try {
			koe.innKoe(k0);
			koe.utKoe();
			assertTrue(koe.erTom());
		} catch (EmptyCollectionException e) {
			fail("push eller pop feilet uventet " + e.getMessage());
		}
	}

	/**
	 * forsøk på pop av en tom kø skal gi "underflow exception"
	 * 
	 * @throws EmptyColletctionEception expected exception
	 */

	@Test
	public void popFromEmptyIsUnderflowed() {
		/*
		 * Assertions.assertThrows(EmptyCollectionException.class, new Executable() {
		 * 
		 * @Override public void execute() throws Throwable { stabel.pop(); } });
		 */

		Assertions.assertThrows(EmptyCollectionException.class, () -> {
			koe.utKoe();
		});
	}
}
