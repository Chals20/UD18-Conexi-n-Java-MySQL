package ud18;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class Queries {

	private Connection conexion = null;

	// M�todo para establecer conexi�n
	public void establecerConexion() {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");	
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC",
					"carlos", "-sVll6isMpy#");		//String de conexion a la db
			System.out.println(" Server connected ");

		} catch (SQLException | ClassNotFoundException ex) {

			System.out.println("No se ha podido conectar con mi base de datos");
			System.out.println(ex);

		}
	}

	// M�todo para cerrar la conexi�n
	public void cerrarConexion() {
		try {

			conexion.close();
			JOptionPane.showMessageDialog(null, "Se ha finalizado la conexi�n con el server");

		} catch (SQLException ex) {

			Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);

		}
	}

	// M�todo que elimina la bd (si existe) y crea una nueva
	public void crearDB(String name) {

		try {

			String Query = "CREATE DATABASE " + name + ";";
			String Query2 = "DROP DATABASE IF EXISTS " + name + ";";	//borramos db si existe

			Statement st = conexion.createStatement();
			st.executeUpdate(Query2);
			st.executeUpdate(Query);
			System.out.println(" Server connected ");

		} catch (SQLException ex) {

			System.out.println("No se ha podido conectar con la base de datos o ya existe");

		}

	}

	// M�todo para crear las tablas
	public void crearTabla(String db, String name, String valores) {

		try {

			String Querydb = "USE " + db + ";";				//metodo use para poder modificar la bd en la que trabajamos
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = "CREATE TABLE " + name + "" + valores + ";";		//crear tabla
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Tabla " + name + " creada correctamente");

		} catch (Exception ex) {

			System.out.println(ex);

		}

	}

	// M�todo para insertar datos en las tablas
	public void insertarDatos(String db, String valores) {
		try {

			String Querydb = "USE " + db + ";";				//metodo use para poder modificar la bd en la que trabajamos
			Statement stdb = conexion.createStatement();
			stdb.executeUpdate(Querydb);

			String Query = valores;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);

			System.out.println("Datos insertados correctamente");

		} catch (SQLException ex) {

			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");

		}
	}

}
