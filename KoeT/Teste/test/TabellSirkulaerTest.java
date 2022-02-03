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
import no.hvl.dat102.kjedet.KjedetKoe;
import no.hvl.dat102.klienter.Kunde;
import no.hvl.dat102.tabell.*;

public class TabellSirkulaerTest extends KoeADTTest {

	@Override
	protected KoeADT<Kunde> reset() {
		return new TabellSirkulaerKoe<Kunde>();
	}

	@Test
	public void utviderSeg() {
		Kunde k6 = new Kunde(20);
		int size = 4;
		TabellSirkulaerKoe<Kunde> utvidet = new TabellSirkulaerKoe<Kunde>(size);
		for (int i = 0; i < size + 2; i++) {
			utvidet.innKoe(k6);
		}
		try {
			for (int j = 0; j < size + 2; j++) {
				utvidet.utKoe();
			}
		} catch (EmptyCollectionException e) {
			fail("Uventet feil " + e.getMessage());
		}
		assertTrue(utvidet.erTom());
	}
}
