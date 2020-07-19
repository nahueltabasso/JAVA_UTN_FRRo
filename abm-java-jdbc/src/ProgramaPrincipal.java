
import ui.Menu;

public class ProgramaPrincipal {
	
	public static void main(String[] args) {
		Menu m = new Menu();
		m.start();
		/**
		PersonaRepository personaRepository = new PersonaRepository();
		RolRepository rolRepository = new RolRepository();
		
		// PRUEBA LISTAR TODAS LAS PERSONAS ---> OK
		List<Persona> personas = personaRepository.findAll();
		for (Persona p : personas) {
			System.out.println(p.toString());
		}
		
//		// PRUEBA LISTAR PERSONA POR SU ID ----> OK
		Persona persona = personaRepository.findById(1L);
		System.out.println(persona.toString());
		
		// PRUEBA BUSCAR PERSONA POR EMAIL Y PASSWORD ----> OK
		Persona p = personaRepository.findByEmailAndByPassword("jp@gmail.com", "jperez");
		System.out.println(p.toString());
		
		// PRUEBA BUSCAR PERSONA POR TIPO Y NUMERO DNI ----> OK
		Persona p1 = personaRepository.findByTipoDocumentoAndByNroDocumento("dni", "12121212");
		System.out.println(p1.toString());
		
		// PRUEBA INSERT PERSONA ----> OK
		Persona personaInsert = new Persona();
		personaInsert.setNombre("Ariel");
		personaInsert.setApellido("Lopez");
		Documento doc = new Documento();
		doc.setTipoDocumento("dni");
		doc.setNumeroDocumento("12412535");
		personaInsert.setDocumento(doc);
		personaInsert.setEmail("ariellopez@gmail.com");
		personaInsert.setPassword("12454");
		personaInsert.setTelefono("3535345");
		personaInsert.setHabilitado(true);
		Persona personaDb = personaRepository.save(personaInsert);
		System.out.println(personaDb.toString());
		
		// PRUEBA DELETE POR SU ID ----> OK
		personaRepository.delete(8L);
		
		// PRUEBA DELETE POR SU TIPO Y NUMERO DE DOCUMENTO ----> OK
		personaRepository.deleteByTipoDocumentoAndByNroDocumento("dni", "12121212");
		
		// LISTAR ROLES ----> OK
		List<Rol> rolesList = rolRepository.findAll();
		for (Rol r : rolesList) {
			System.out.println(r.toString());
		}
		
		// LISTAR ROLES POR PERSONA ---> OK
		List<Rol> roles = rolRepository.findRolesByIdPersona(1L);
		for (Rol r : roles) {
			System.out.println(r.toString());
		}
		*/
	}

}
