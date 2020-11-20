package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Genero;
import co.ufps.avengerJPA.util.Conexion;

public class GeneroDao extends Conexion<Genero> implements GenericDao<Genero> {

	public GeneroDao() {
		super(Genero.class);
	}

}