package moovies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import mooviesClassForTest.GeneroDeCine;
import mooviesClassForTest.Pelicula;

public class Usuario
{

	private String nyap;
	private int edad;
	private String ocupacion;
	private int codigoPostal;
	private ArrayList<Usuario> amigos = new ArrayList<Usuario>();
	private ArrayList<Pelicula> peliculasVistas = new ArrayList<Pelicula>();
	private Map<Pelicula, Integer> calificaciones = new HashMap<Pelicula, Integer>();
	private ArrayList<Pelicula> lanzamientos = new ArrayList<Pelicula>();
	
	public Usuario(String unNyAp, int unaEdad, String unaOcupacion, int unCodigoPostal)
	{
		
		nyap = unNyAp;
		
		edad = unaEdad;
		
		ocupacion = unaOcupacion;
		
		codigoPostal = unCodigoPostal;
		
	}

	public ArrayList<Pelicula> getPeliculasVistas()
	{
		return peliculasVistas;
	}

	public void verPelicula(Pelicula unaPelicula)
	{
		
		peliculasVistas.add(unaPelicula);
		
	}

	public Map<Pelicula, Integer> getCalificaciones()
	{
		return calificaciones;
	}

	public void calificarConValor(Pelicula unaPelicula, int unValor)
	{
	
		calificaciones.put(unaPelicula, unValor);
		
		unaPelicula.registrarCalificacion(unValor);
	
	}

	public GeneroDeCine generoFavorito()
	{
		
		GeneroDeCine elGeneroFavorito = null;
		int cantidadDePeliculasVistasDelGeneroFavorito = 0;
		Set<GeneroDeCine> generosDePeliculasVistas = new HashSet<GeneroDeCine>();
		
		for(Pelicula unaPelicula: peliculasVistas)
		{
			
			generosDePeliculasVistas.add(unaPelicula.getGenero());
			
		}
		
		for(GeneroDeCine unGeneroDeCine: generosDePeliculasVistas)
		{

			int cantidadDePeliculasDeUnGenero = cantidadDePeliculasDeUnGenero(unGeneroDeCine);
			
			if(cantidadDePeliculasDeUnGenero >  cantidadDePeliculasVistasDelGeneroFavorito)
			{
				
				cantidadDePeliculasVistasDelGeneroFavorito = cantidadDePeliculasDeUnGenero;
				elGeneroFavorito = unGeneroDeCine;
				
			}
			
		}
		
		return elGeneroFavorito;
		
	}

	private int cantidadDePeliculasDeUnGenero(GeneroDeCine unGeneroDeCine)
	{
		
		int cantidadDePeliculasDeUnGenero = 0;
		
		for(Pelicula unaPelicula: peliculasVistas)
		{
			
			if(unaPelicula.getGenero() == unGeneroDeCine)
			{
				
				cantidadDePeliculasDeUnGenero = cantidadDePeliculasDeUnGenero + 1;
				
			}
			
		}
		
		return cantidadDePeliculasDeUnGenero;
	}

	public String getNyap()
	{
		return nyap;
	}

	public int getEdad()
	{
		return edad;
	}

	public String getOcupacion()
	{
		return ocupacion;
	}
	
	public int getCodigoPostal()
	{
		return codigoPostal;
	}



}
