package logic;

import java.util.List;

import data.RolRepository;
import entities.Rol;

public class RolController {

	private RolRepository rolRepository = new RolRepository();
	
	/**
	 * Metodo que retorna todos los roles existentes
	 * @return
	 */
	public List<Rol> getAll() {
		return rolRepository.findAll();
	}
	
	/**
	 * Metodo que retorna un rol segun su id
	 * @param id
	 * @return
	 */
	public Rol getById(Long id) {
		return rolRepository.findById(id);
	}
	
	/**
	 * Metodo que retorna los roles de una persona
	 * @param idPersona
	 * @return
	 */
	public List<Rol> getRolByPersona(Long idPersona) {
		return rolRepository.findRolesByIdPersona(idPersona);
	}
}
