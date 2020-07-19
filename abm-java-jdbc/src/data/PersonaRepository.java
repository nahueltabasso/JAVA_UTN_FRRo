package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Documento;
import entities.Persona;
import entities.Rol;

public class PersonaRepository {

	private RolRepository rolRepository = new RolRepository();
	
	/**
	 * Metodo que construye el objeto Persona
	 * @param resultSet
	 * @return
	 */
	private Persona buildPersona(ResultSet resultSet) {
		Persona persona = new Persona();
		try {
			persona.setId(resultSet.getLong(1));
			persona.setNombre(resultSet.getString(2));
			persona.setApellido(resultSet.getString(3));
			Documento documento = new Documento();
			documento.setTipoDocumento(resultSet.getString(4));
			documento.setNumeroDocumento(resultSet.getString(5));
			persona.setDocumento(documento);
			persona.setEmail(resultSet.getString(6));
			persona.setPassword(resultSet.getString(7));
			persona.setTelefono(resultSet.getString(8));
			persona.setHabilitado(resultSet.getBoolean(9));
			List<Rol> roles = rolRepository.findRolesByIdPersona(persona.getId());
			persona.setRoles(roles);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return persona;
	}
	
	/**
	 * Metodo que returna todas las personas
	 * @return
	 */
	public List<Persona> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Persona> personaList = new ArrayList<Persona>();
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado "
												  + "from persona");
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Persona persona = buildPersona(resultSet);
				personaList.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return personaList;
	}
	
	/**
	 * Metodo que retorna una persona segun el id 
	 * @param id
	 * @return
	 */
	public Persona findById(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado "
												  + "from persona where id = ?");
			// Pasamos los parametros para la query nativa
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				persona = new Persona();
				persona = buildPersona(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return persona;
	}
	
	/**
	 * Metodo para persistir un nuevo objeto de tipo persona en la base de datos
	 * @param persona
	 */
	public Persona save(Persona persona) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("insert into persona(nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado) "
												  + "values (?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			// Pasamos los parametros para la query nativa
			statement.setString(1, persona.getNombre());
			statement.setString(2, persona.getApellido());
			statement.setString(3, persona.getDocumento().getTipoDocumento());
			statement.setString(4, persona.getDocumento().getNumeroDocumento());
			statement.setString(5, persona.getEmail());
			statement.setString(6, persona.getPassword());
			statement.setString(7, persona.getTelefono());
			statement.setBoolean(8, persona.isHabilitado());
			statement.executeUpdate();
			resultSet = statement.getGeneratedKeys();
			
			// Validamos que nos devuelva el id para retornar la persona
			if (resultSet != null && resultSet.next()) {
				persona.setId(resultSet.getLong(1));
				List<Rol> roles = rolRepository.addRolPersona(persona);
				persona.setRoles(roles);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return persona;
	}
	
	/**
	 * Metodo para eliminar un registro de la tabla persona
	 * @param id
	 */
	public void delete(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("delete from persona where id = ?");
			statement.setLong(1, id);
			int row = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
		}
	}
	
	/**
	 * Metodo para eliminar un registro de la tabla persona por su tipo y numero de documento
	 * @param tipoDocumento
	 * @param numeroDocumento
	 */
	public void deleteByTipoDocumentoAndByNroDocumento(String tipoDocumento, String numeroDocumento) {
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("delete from persona where tipo_doc = ? and nro_doc = ?");
			statement.setString(1, tipoDocumento);
			statement.setString(2, numeroDocumento);
			int row = statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
		}
	}
	
	/**
	 * Metodo para retornar una persona segun su email y su password
	 * @param email
	 * @param password
	 * @return
	 */
	public Persona findByEmailAndByPassword(String email, String password) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado "
												  + "from persona where email = ? and password = ?");
			// Pasamos los parametros para la query nativa
			statement.setString(1, email);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				persona = new Persona();
				persona = buildPersona(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return persona;
	}
	
	/**
	 * Metodo que retorna un objeto Persona segun su documento
	 * @param tipoDocumento
	 * @param numeroDocumento
	 * @return
	 */
	public Persona findByTipoDocumentoAndByNroDocumento(String tipoDocumento, String numeroDocumento) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Persona persona = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado "
												  + "from persona where tipo_doc = ? and nro_doc = ?");
			// Pasamos los parametros para la query nativa
			statement.setString(1, tipoDocumento);
			statement.setString(2, numeroDocumento);
			resultSet = statement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				persona = new Persona();
				persona = buildPersona(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return persona;
	}
	
	/**
	 * Metodo que retorna una lista de personas segun su apellido
	 * @param apellido
	 * @return
	 */
	public List<Persona> findByApellido(String apellido) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Persona> personaList = new ArrayList<Persona>();
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, nombre, apellido, tipo_doc, nro_doc, email, password, tel, habilitado "
												  + "from persona where apellido like ?");
			statement.setString(1, apellido);
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				Persona persona = new Persona();
				persona = buildPersona(resultSet);
				personaList.add(persona);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return personaList;
	}
}
