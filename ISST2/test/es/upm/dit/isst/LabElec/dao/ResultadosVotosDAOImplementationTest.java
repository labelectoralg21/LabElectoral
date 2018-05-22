package es.upm.dit.isst.LabElec.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.LabElec.dao.model.Circunscripcion;
import es.upm.dit.isst.LabElec.dao.model.ResultadosVotos;

public class ResultadosVotosDAOImplementationTest {
	private ResultadosVotos r;
	private Circunscripcion c;
	@Before
	public void setUp() throws Exception {
		r = new ResultadosVotos();
		c =new Circunscripcion();
		c.setNombre("Pa");
		r.setId("1");
		r.setAnno(1000);
		r.setPartido("PP1");
		r.setVotosObtenidos(2509);
		r.setCircunscripcion(c);
		CircunscripcionDAOImplementation.getInstance().createCircunscripcion(c);
		ResultadosVotosDAOImplementation.getInstance().createResultado(r);
		
	}

	@After
	public void tearDown() throws Exception {
		CircunscripcionDAOImplementation.getInstance().deleteCircunscripcion(c);
		ResultadosVotosDAOImplementation.getInstance().deleteResultado(r);
		r = null;
		c= null;
	}

	@Test
	public final void testCreateResultado() {
		ResultadosVotosDAO dao = ResultadosVotosDAOImplementation.getInstance();
		ResultadosVotos r1 = new ResultadosVotos();
		r1.setId("10");
		r1.setAnno(1369);
		r1.setPartido("PP2");
		r1.setVotosObtenidos(2509);
		r1.setCircunscripcion(c);
		dao.createResultado(r1);
		
		List<ResultadosVotos> r2 = dao.readResultado(r1.getAnno(),c);
		assertEquals(r1.getAnno(),r2.get(0).getAnno());
		assertEquals(r1.getPartido(),r2.get(0).getPartido());
		assertEquals(r1.getVotosObtenidos(),r2.get(0).getVotosObtenidos());
		
		
	}

	@Test
	public final void testReadResultado() {
		ResultadosVotosDAO dao = ResultadosVotosDAOImplementation.getInstance();
		List<ResultadosVotos> r2 = dao.readResultado(r.getAnno(),c);
		assertEquals(r.getAnno(),r2.get(0).getAnno());
		assertEquals(r.getPartido(),r2.get(0).getPartido());
		assertEquals(r.getVotosObtenidos(),r2.get(0).getVotosObtenidos());
		
	}
	@Test
	public final void testUpdateResultado() {
		r.setAnno(1496);
		ResultadosVotosDAO dao = ResultadosVotosDAOImplementation.getInstance();
		dao.updateResultado(r);
		List<ResultadosVotos> r2 = dao.readResultado(r.getAnno(),c);
		assertEquals(r.getAnno(),r2.get(0).getAnno());
		assertEquals(r.getPartido(),r2.get(0).getPartido());
		assertEquals(r.getVotosObtenidos(),r2.get(0).getVotosObtenidos());
	}

	@Test
	public final void testDeleteResultado() {
		ResultadosVotosDAO dao = ResultadosVotosDAOImplementation.getInstance();
		dao.deleteResultado(r);
		List<ResultadosVotos> r2 = dao.readResultado(r.getAnno(),c);
		assertEquals(0, r2.size());
	}


}