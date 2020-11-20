package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Clasificacion;
import co.ufps.avengerJPA.util.Conexion;

public class ClasificacionDao extends Conexion<Clasificacion> implements GenericDao<Clasificacion> {

	public ClasificacionDao() {
		super(Clasificacion.class);
	}

}