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
import no.hvl.dat102.kjedet.*;
import no.hvl.dat102.klienter.Kunde;

public class KjedetKoeTest extends KoeADTTest {
	
	@Override
	protected KoeADT<Kunde> reset() {
		return new KjedetKoe<Kunde>();
	}
}
