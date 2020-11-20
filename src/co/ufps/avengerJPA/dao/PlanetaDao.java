package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Planeta;
import co.ufps.avengerJPA.util.Conexion;

public class PlanetaDao extends Conexion<Planeta> implements GenericDao<Planeta> {

	public PlanetaDao() {
		super(Planeta.class);
	}

}