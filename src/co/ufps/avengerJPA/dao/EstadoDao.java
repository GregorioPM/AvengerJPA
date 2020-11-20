package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Estado;
import co.ufps.avengerJPA.util.Conexion;

public class EstadoDao extends Conexion<Estado> implements GenericDao<Estado> {

	public EstadoDao() {
		super(Estado.class);
	}

}
