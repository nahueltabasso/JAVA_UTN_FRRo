package ui;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Documento;
import entities.Persona;
import entities.Rol;
import logic.LoginController;
import logic.PersonaController;
import logic.RolController;

public class Menu {
	Scanner s=null;
	LoginController loginCtrl = new LoginController();
	PersonaController personaCtrl = new PersonaController();
	RolController rolCtrl = new RolController();

	public void start() {
		s = new Scanner(System.in);
		Persona persona = login();
		System.out.println("Bienvenido " + persona.getNombre() + " " + persona.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}

	private void executeCommand(String command) {
		switch (command) {
		case "list":
			System.out.println(personaCtrl.getAll());
			break;
		case "find":
			System.out.println(find());
			break;
		case "find id":
			System.out.println(findById());
		case "search":
			System.out.println(findByApellido());
			break;
		case "new":
			System.out.println(addPersona());
			break;
		case "edit":
			
			break;
		case "delete":
			deleteByDocumento();
			System.out.println("Eliminado con exito!");
			break;
		case "delete id": 
			deleteById();
			System.out.println("Eliminado con exito!");
			break;
		default:
			break;
		}
	}

	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("List\t\t - Listar todos");
		System.out.println("Find\t\t - Buscar por tipo y nro de documento"); 
		System.out.println("Find ID\t\t - Buscar por el id de la persona");
		System.out.println("Search\t\t - Listar por apellido"); 
		System.out.println("New\t\t - Crea una nueva persona y asigna un rol existente");
		System.out.println("Edit\t\t - Busca por tipo y nro de documento y actualiza todos los datos");
		System.out.println("Delete\t\t - Borra por tipo y nro de documento");
		System.out.println("Delete ID\t\t - Borra por el id de la persona");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	public Persona login() {
		Persona persona = new Persona();
		System.out.print("Email: ");
		persona.setEmail(s.nextLine());
		System.out.print("password: ");
		persona.setPassword(s.nextLine());
		persona = loginCtrl.validate(persona);
		return persona;
		
	}
	
	private Persona find() {
		System.out.println();
		Persona persona = new Persona();
		Documento d = new Documento();
		persona.setDocumento(d);
		System.out.print("Tipo doc: ");
		d.setTipoDocumento(s.nextLine());
		System.out.print("Nro doc: ");
		d.setNumeroDocumento(s.nextLine());
		return personaCtrl.getByDocumento(persona);
	}
	
	private Persona findById() {
		String id = null;
		System.out.print("ID Persona: ");
		id = s.nextLine();
		return personaCtrl.getById(Long.parseLong(id));
	}
	
	private Persona addPersona() {
		Persona persona = new Persona();
		Documento doc = new Documento();
		System.out.println("Nombre: ");
		persona.setNombre(s.nextLine());
		System.out.println("Apellido: ");
		persona.setApellido(s.nextLine());
		System.out.println("Tipo Doc: ");
		doc.setTipoDocumento(s.nextLine());
		System.out.println("Nro Doc: ");
		doc.setNumeroDocumento(s.nextLine());
		persona.setDocumento(doc);
		System.out.println("Email: ");
		persona.setEmail(s.nextLine());
		System.out.println("Password: ");
		persona.setPassword(s.nextLine());
		System.out.println("Telefono: ");
		persona.setTelefono(s.nextLine());
		persona.setHabilitado(true);
		// Parte para agregar los roles de la persona
		List<Rol> rolesPersona = new ArrayList<Rol>();
		System.out.println("Desea agregar roles a la persona?\n1.SI\n2.NO");
		String rta = s.nextLine();
		if (rta.equalsIgnoreCase("1")) {
			boolean flag = true;
			while (flag) {
				System.out.println(rolCtrl.getAll());
				System.out.println("\n");
				System.out.println("Elija un rol");
				String rolStr = null;
				do {
					rolStr = s.nextLine();
				} while ((!rolStr.equalsIgnoreCase("1")) && (!rolStr.equalsIgnoreCase("2")));
				Rol rol = rolCtrl.getById(Long.parseLong(rolStr));
				rolesPersona.add(rol);
				System.out.println("\n");
				System.out.println("Desea asignar otro rol a la persona? (Si/No)");
				rta = s.nextLine();
				if (rta.equalsIgnoreCase("No")) {
					flag = false;
				}
			}
		}
		persona.setRoles(rolesPersona);
		return personaCtrl.add(persona);
	}
	
	private List<Persona> findByApellido() {
		String apellido = null;
		System.out.println("Apellido: ");
		apellido = s.nextLine();
		return personaCtrl.getByApellido(apellido);
	}

	private void deleteById() {
		String id = null;
		System.out.println("ID Persona: ");
		id = s.nextLine();
		personaCtrl.deleteById(Long.parseLong(id));
	}
	
	private void deleteByDocumento() {
		Documento doc = new Documento();
		System.out.println("Tipo Doc: ");
		doc.setTipoDocumento(s.nextLine());
		System.out.println("Nro Doc: ");
		doc.setNumeroDocumento(s.nextLine());
		personaCtrl.deleteByDocumento(doc);
	}
}
