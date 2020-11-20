package co.ufps.avengerJPA.dao;

import co.ufps.avengerJPA.model.Heroe;
import co.ufps.avengerJPA.util.Conexion;

public class HeroeDao extends Conexion<Heroe> implements GenericDao<Heroe> {

	public HeroeDao() {
		super(Heroe.class);
	}

}
