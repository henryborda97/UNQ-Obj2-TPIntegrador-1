package testMoovies;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import moovies.Usuario;
import mooviesClassForTest.GeneroDeCineGeneral;
import mooviesClassForTest.Pelicula;

public class UsuarioTestCase
{

	@Test
	public void testDadoUnUsuarioLlamadoMartinGonzalezConVeintidosAñosTrabajaComoTecnicoEnAutomatizacionYSuCodigoPostalEsCMilDoscientosOchoSeVerificaQueSepaSuInformacion()
	{
		
		Usuario unUsuario = new Usuario("Martin Gonzalez", 22, "Tecnico en Automatizacion", 1208);
		
		assertEquals(unUsuario.getNyap(), "Martin Gonzalez");
		assertEquals(unUsuario.getEdad(), 22);
		assertEquals(unUsuario.getOcupacion(), "Tecnico en Automatizacion");
		assertEquals(unUsuario.getCodigoPostal(), 1208);
		
	}
	
	@Test
	public void testDadoUnUsuarioQueVeUnaPeliculaSeVerificaQueLaHayaVisto()
	{
		
		Usuario unUsuario = new Usuario("Martin Gonzalez", 22, "Tecnico en Automatizacion", 1208);
		Pelicula unaPelicula = mock(Pelicula.class);
		
		unUsuario.verPelicula(unaPelicula);
		
		assertTrue(unUsuario.getPeliculasVistas().contains(unaPelicula));
		
	}
	
	@Test
	public void testDadoUnUsuarioQueCalificaUnaPeliculaSeVerificaQueSepaQueCalificacionLeDio()
	{
		
		Usuario unUsuario = new Usuario("Martin Gonzalez", 22, "Tecnico en Automatizacion", 1208);
		Pelicula unaPelicula = mock(Pelicula.class);
		
		unUsuario.calificarConValor(unaPelicula, 3);
		
		int calificacionDePeliculaVista;
		
		calificacionDePeliculaVista = unUsuario.getCalificaciones().get(unaPelicula);
		
		assertTrue(unUsuario.getCalificaciones().containsKey(unaPelicula));
		assertEquals(calificacionDePeliculaVista, 3);
		
	}
	
	@Test
	public void testDadoUnUsuarioQueVioDosPeliculasDeTerrorYUnaDeAccionSeVerificaQueSuGeneroFavoritoSeaElTerror()
	{
		
		Usuario unUsuario = new Usuario("Martin Gonzalez", 22, "Tecnico en Automatizacion", 1208);
		GeneroDeCineGeneral generoDeTerror = mock(GeneroDeCineGeneral.class);
		GeneroDeCineGeneral generoDeAccion = mock(GeneroDeCineGeneral.class);
		
		Pelicula unaPeliculaDeTerror = mock(Pelicula.class);
		when(unaPeliculaDeTerror.getGenero()).thenReturn(generoDeTerror);
		
		Pelicula unaPeliculaDeAccion = mock(Pelicula.class);
		when(unaPeliculaDeAccion.getGenero()).thenReturn(generoDeAccion);
		
		unUsuario.verPelicula(unaPeliculaDeTerror);
		unUsuario.verPelicula(unaPeliculaDeTerror);
		unUsuario.verPelicula(unaPeliculaDeAccion);

		assertEquals(unUsuario.generoFavorito(), generoDeTerror);
		
	}

}
