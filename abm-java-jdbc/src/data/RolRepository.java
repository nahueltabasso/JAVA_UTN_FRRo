package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entities.Persona;
import entities.Rol;

public class RolRepository {

	/**
	 * Metodo que retorna todos los roles de la base de datos
	 * @return
	 */
	public List<Rol> findAll() {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Rol> rolList = new ArrayList<Rol>();
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, descripcion from rol");
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Rol rol = new Rol();
					rol.setId(resultSet.getLong(1));
					rol.setDescripcion(resultSet.getString(2));
					rolList.add(rol);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return rolList;	
	}

	/**
	 * Metodo que retorna un rol segun su id
	 * @param id
	 * @return
	 */
	public Rol findById(Long id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Rol rol = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select id, descripcion from rol where id = ?");
			// Pasamos los parametros para la query nativa
			statement.setLong(1, id);
			resultSet = statement.executeQuery();
			if (resultSet != null && resultSet.next()) {
				rol = new Rol();
				rol.setId(resultSet.getLong(1));
				rol.setDescripcion(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return rol;
	}
	
	/**
	 * Metodo que retorna los roles de una persona determinada
	 * @param idPersona
	 * @return
	 */
	public List<Rol> findRolesByIdPersona(Long idPersona) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Rol> rolesPersona = new ArrayList<Rol>();
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("select r.id, r.descripcion " + 
													"from rol r " + 
													"inner join rol_persona rp on rp.id_rol = r.id " + 
													"where rp.id_persona = ?");
			statement.setLong(1, idPersona);
			resultSet = statement.executeQuery();
			if (resultSet != null) {
				while (resultSet.next()) {
					Rol rol = new Rol();
					rol.setId(resultSet.getLong(1));
					rol.setDescripcion(resultSet.getString(2));
					rolesPersona.add(rol);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return rolesPersona;
	}
	
	/**
	 * Metodo que inserta en la tabla rol_persona los roles asignados a la persona
	 * @param persona
	 * @return
	 */
	public List<Rol> addRolPersona(Persona persona) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DataBaseConnection.getConnection();
			statement = connection.prepareStatement("insert into rol_persona(id_rol, id_persona) values (?, ?)");
			// Pasamos los parametros para la query nativa
			for (Rol r : persona.getRoles()) {
				statement.setLong(1, r.getId());
				statement.setLong(2, persona.getId());
				statement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DataBaseConnection.closeConnection(connection);
			DataBaseConnection.closePreparedStatement(statement);
			DataBaseConnection.closeResultSet(resultSet);
		}
		return persona.getRoles();
	}
}
