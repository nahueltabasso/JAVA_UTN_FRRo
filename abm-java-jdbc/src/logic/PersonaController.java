package logic;

import java.util.List;

import data.PersonaRepository;
import entities.Documento;
import entities.Persona;

public class PersonaController {

	private PersonaRepository personaRepository = new PersonaRepository();
	
	public List<Persona> getAll() {
		return personaRepository.findAll();
	}
	
	public Persona getByDocumento(Persona persona) {
		return personaRepository.findByTipoDocumentoAndByNroDocumento(persona.getDocumento().getTipoDocumento(), 
				persona.getDocumento().getNumeroDocumento());
	}
	
	public Persona add(Persona persona) {
		return personaRepository.save(persona);
	}
	
	public void deleteById(Long id) {
		personaRepository.delete(id);
	}
	
	public void deleteByDocumento(Documento documento) {
		personaRepository.deleteByTipoDocumentoAndByNroDocumento(documento.getTipoDocumento(), documento.getNumeroDocumento());
	}
	
	public List<Persona> getByApellido(String apellido) {
		return personaRepository.findByApellido(apellido);
	}
	
	public Persona getById(Long id) {
		return personaRepository.findById(id);
	}
}
