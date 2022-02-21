package MengdeUTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import no.hvl.dat102.mengde.adt.MengdeADT;
import no.hvl.dat102.mengde.kjedet.KjedetMengde;
import no.hvl.dat102.mengde.tabell.TabellMengde;

public abstract class MengdeADTTest {
	
	//test data
	private Integer e1 = 1;
	private Integer e2 = 2;
	private Integer e3 = 3;
	private Integer e4 = 4;
	private Integer e5 = 5;
	private Integer e6 = 6;
	
	
	private MengdeADT<Integer> mengde1;
	private MengdeADT<Integer> mengde2;
	private MengdeADT<Integer> mengde3;
	
	protected abstract MengdeADT<Integer> reset();
	
	@BeforeEach
	public final void setup() {
		mengde1 = reset();
		mengde2 = reset();
	}

	@Test
	public final void union() {
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);
		mengde1.leggTil(e3);
		
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);
		mengde2.leggTil(e6);
		
		mengde3.leggTil(e1);
		mengde3.leggTil(e2);
		mengde3.leggTil(e3);
		mengde3.leggTil(e4);
		mengde3.leggTil(e5);
		mengde3.leggTil(e6);
		
		assertEquals(mengde3, mengde1.union(mengde2));
	}
	
	@Test
	public final void snitt() {
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);
		mengde1.leggTil(e3);
		
		mengde2.leggTil(e3);
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);
		mengde2.leggTil(e6);
		
		mengde3.leggTil(e3);
		
		assertEquals(mengde3, mengde1.snitt(mengde2));
	}
	
	@Test
	public final void differens() {
		mengde1.leggTil(e1);
		mengde1.leggTil(e2);
		mengde1.leggTil(e3);
		mengde1.leggTil(e4);
		
		mengde2.leggTil(e4);
		mengde2.leggTil(e5);
		mengde2.leggTil(e6);
		
		mengde3.leggTil(e1);
		mengde3.leggTil(e2);
		mengde3.leggTil(e3);
		
		assertEquals(mengde3, mengde1.differens(mengde2));
	}
}
