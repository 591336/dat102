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
}
