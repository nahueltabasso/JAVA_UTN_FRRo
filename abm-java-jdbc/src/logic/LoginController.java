package logic;

import data.PersonaRepository;
import entities.Persona;

public class LoginController {

	private PersonaRepository personaRepository = new PersonaRepository();
	
	public Persona validate(Persona persona) {
		/**
		 * Incluir cifrado de password
		 */
		return personaRepository.findByEmailAndByPassword(persona.getEmail(), persona.getPassword());
	}
	
}
