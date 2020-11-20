package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Pelicula;
import co.ufps.avengerJPA.util.Conexion;

public class PeliculaDao extends Conexion<Pelicula> implements GenericDao<Pelicula> {

	public PeliculaDao() {
		super(Pelicula.class);
	}

}
