package es.upm.dit.isst.LabElec.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.LabElec.dao.model.Asignacion;
import es.upm.dit.isst.LabElec.dao.model.Circunscripcion;

public class AsignacionDAOImplementationTest {
	private Asignacion a;
	private Circunscripcion c;
	@Before
	public void setUp() throws Exception {
		c = new Circunscripcion();
		c.setNombre("Pa");
		a = new Asignacion();
		a.setId(1);
		a.setAnno(1000);
		a.setEscannos(2);
		a.setCircunscripcion(c);
		CircunscripcionDAOImplementation.getInstance().createCircunscripcion(c);
		AsignacionDAOImplementation.getInstance().createAsignacion(a);
		
	}

	@After
	public void tearDown() throws Exception {
		AsignacionDAOImplementation.getInstance().deleteAsignacion(a);
		CircunscripcionDAOImplementation.getInstance().deleteCircunscripcion(c);
		a = null;
		c = null;
	}


	@Test
	public final void testCreateAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		Asignacion asig = new Asignacion();
		asig.setId(0);
		asig.setAnno(1500);
		asig.setEscannos(30);
		asig.setCircunscripcion(c);
		dao.createAsignacion(asig);
		
		int esc = dao.readAsignacion(1500, c);
		assertEquals(esc, asig.getEscannos());
		
	}

	@Test
	public final void testReadAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		int esc = dao.readAsignacion(a.getAnno(), c);
		assertEquals(esc,a.getEscannos());
		
		
	}

	@Test
	public final void testUpdateAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		a.setEscannos(4);
		dao.updateAsignacion(a);
		int esc =dao.readAsignacion(a.getAnno(),c);
		assertEquals(a.getEscannos(),esc);
	}

	@Test
	public final void testDeleteAsignacion() {
		AsignacionDAO dao = AsignacionDAOImplementation.getInstance();
		dao.deleteAsignacion(a);
		assertEquals(0,dao.readAsignacion(a.getAnno(), c));
	}

}