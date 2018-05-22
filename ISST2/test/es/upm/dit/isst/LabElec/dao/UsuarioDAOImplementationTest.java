package es.upm.dit.isst.LabElec.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.upm.dit.isst.LabElec.dao.model.Usuario;

public class UsuarioDAOImplementationTest {

	private Usuario u;
	
	@Before
	public void setUp() throws Exception {
		u = new Usuario();
		u.setEmail("a@a");
		u.setPassword("aaa");
		UsuarioDAOImplementation.getInstance().createUser(u);
	}

	@After
	public void tearDown() throws Exception {
		u = null;
	}

	@Test
	public final void testCreateUser() {
		Usuario u1 = new Usuario();
		u1.setEmail("bbb");
		u1.setPassword("bbb");
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		dao.createUser(u1);
		Usuario u2 = dao.readUser(u1.getEmail());
		assertEquals(u1.getEmail(), u2.getEmail());
		assertEquals(u1.getPassword(), u2.getPassword());
	}

	@Test
	public final void testReadUser() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario u2 = dao.readUser(u.getEmail());
		assertEquals(u.getEmail(), u2.getEmail());
		assertEquals(u.getPassword(), u2.getPassword());
	}

	@Test
	public final void testLoginUser() {
		UsuarioDAO dao = UsuarioDAOImplementation.getInstance();
		Usuario u2 = dao.loginUser(u.getEmail(), u.getPassword());
		assertEquals(u.getEmail(), u2.getEmail());
		assertEquals(u.getPassword(), u2.getPassword());
	}

}
