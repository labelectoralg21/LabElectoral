package es.upm.dit.isst.LabElec.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.LabElec.dao.model.Circunscripcion;

public class CircunscripcionDAOImplementationTest {

	private Circunscripcion c;
	
	@Before
	public void setUp() throws Exception {
		c = new Circunscripcion();
		c.setNombre("Prueba1");
		c.setCCAA("PruebaCCAA");
		c.setPoblacion(2000);
		c.setPoblacionVotante(1324);
		CircunscripcionDAOImplementation.getInstance().createCircunscripcion(c);
		
	}

	@After
	public void tearDown() throws Exception {
		CircunscripcionDAOImplementation.getInstance().deleteCircunscripcion(c);
		c = null;
	}

	@Test
	public final void testCreateCircunscripcion() {
		CircunscripcionDAO dao = CircunscripcionDAOImplementation.getInstance();
		Circunscripcion circ = new Circunscripcion();
		circ.setCCAA("PruebaCCAA");
		circ.setNombre("Prueba1");
		circ.setPoblacion(2000);
		circ.setPoblacionVotante(1324);
		dao.createCircunscripcion(circ);
		
		Circunscripcion circ2 = dao.readCircunscripcion("Prueba1");
		assertEquals(circ.getNombre(), circ2.getNombre());
		assertEquals(circ.getCCAA(), circ2.getCCAA());
		assertEquals(circ.getPoblacion(), circ2.getPoblacion());
		assertEquals(circ.getPoblacionVotante(), circ2.getPoblacionVotante());
	}

	@Test
	public final void testReadCircunscripcion() {
		CircunscripcionDAO dao = CircunscripcionDAOImplementation.getInstance();
		Circunscripcion circ3 = dao.readCircunscripcion("Prueba1");
		assertEquals(c.getCCAA(),circ3.getCCAA());
		assertEquals(c.getNombre(),circ3.getNombre());
		assertEquals(c.getPoblacion(),circ3.getPoblacion());
		assertEquals(c.getPoblacionVotante(),circ3.getPoblacionVotante());
	}

	@Test
	public final void testUpdateCircunscripcion() {
		c.setNombre("NameTest");
		CircunscripcionDAO dao = CircunscripcionDAOImplementation.getInstance();
		dao.updateCircunscripcion(c);
		
		Circunscripcion circUpdate = dao.readCircunscripcion("NameTest");
		assertEquals(c.getCCAA(),circUpdate.getCCAA());
		assertEquals(c.getNombre(),circUpdate.getNombre());
		assertEquals(c.getPoblacion(),circUpdate.getPoblacion());
		assertEquals(c.getPoblacionVotante(),circUpdate.getPoblacionVotante());
		
	}

	@Test
	public final void testDeleteCircunscripcion() {
		CircunscripcionDAO dao = CircunscripcionDAOImplementation.getInstance();
		
		dao.deleteCircunscripcion(c);
		
		assertEquals(dao.readCircunscripcion(c.getNombre()),null);
		
	}


}
