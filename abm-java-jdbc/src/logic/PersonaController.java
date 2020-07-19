package logic;

import java.util.List;

import data.PersonaRepository;
import entities.Documento;
import entities.Persona;

public class PersonaController {

	private PersonaRepository personaRepository = new PersonaRepository();
	
	/**
	 * Metodo que retorna todas las personas de la base de datos
	 * @return
	 */
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}
	
	/**
	 * Metodo que retorna una persona segun su documento
	 * @param persona
	 * @return
	 */
	public Persona getByDocumento(Persona persona) {
		return personaRepository.findByTipoDocumentoAndByNroDocumento(persona.getDocumento().getTipoDocumento(), 
				persona.getDocumento().getNumeroDocumento());
	}
	
	/**
	 * Metodo para persistir un objeto de tipo persona
	 * @param persona
	 * @return
	 */
	public Persona add(Persona persona) {
		return personaRepository.save(persona);
	}
	
	/**
	 * Metodo para eliminar una persona de la base segun su id
	 * @param id
	 */
	public void deleteById(Long id) {
		personaRepository.delete(id);
	}
	
	/**
	 * Metodo para eliminar una persona de la base segun su documento
	 * @param documento
	 */
	public void deleteByDocumento(Documento documento) {
		personaRepository.deleteByTipoDocumentoAndByNroDocumento(documento.getTipoDocumento(), documento.getNumeroDocumento());
	}
	
	/**
	 * Metodo que retorna una coleccion de objetos de tipo persona segun el apellido
	 * @param apellido
	 * @return
	 */
	public List<Persona> getByApellido(String apellido) {
		return personaRepository.findByApellido(apellido);
	}
	
	/**
	 * Metodo que retorna una persona segun su id
	 * @param id
	 * @return
	 */
	public Persona getById(Long id) {
		return personaRepository.findById(id);
	}
}
