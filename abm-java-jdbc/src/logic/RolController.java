package logic;

import java.util.List;

import data.RolRepository;
import entities.Rol;

public class RolController {

	private RolRepository rolRepository = new RolRepository();
	
	public List<Rol> getAll() {
		return rolRepository.findAll();
	}
	
	public Rol getById(Long id) {
		return rolRepository.findById(id);
	}
	
	public List<Rol> getRolByPersona(Long idPersona) {
		return rolRepository.findRolesByIdPersona(idPersona);
	}
}
