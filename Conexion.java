package fes.aragon.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fes.aragon.modelos.Barcos;
import fes.aragon.modelos.BarcosSQL;
import fes.aragon.modelos.DestinoEleccion;
import fes.aragon.modelos.Membresias;
import fes.aragon.modelos.Patrones;
import fes.aragon.modelos.PatronesEleccion;
import fes.aragon.modelos.Salidas;
import fes.aragon.modelos.Socios;
import fes.aragon.modelos.SociosEleccion;
import fes.aragon.modelos.SociosSQL;
import fes.aragon.modelos.TiposBarcos;

public class Conexion {

	private String url = "jdbc:mariadb://127.0.0.1:3306/clubnauticados?serverTimezone=UTC";
	private String usuario = "root";
	private String password = "Titanfall2023";
	private Connection conexion;

	public Conexion() throws ClassNotFoundException, SQLException {
		Class.forName("org.mariadb.jdbc.Driver");
		conexion = DriverManager.getConnection(url, usuario, password);
	}

	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public ArrayList<Socios> buscarSocio(String socio) throws SQLException {
		String query = "SELECT a.id_scs, b.nombre_mbs, a.nombre_scs, a.apellido_pat_scs, a.apellido_mat_scs, a.telefono_scs, a.correo_scs "
				+ "FROM socios a, membresias b " + "WHERE a.id_mbs = b.id_mbs and nombre_scs like '%" + socio + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Socios> datos = new ArrayList<>();
		while (rs.next()) {
			Socios socios = new Socios();
			socios.setIdSocios(rs.getInt(1));
			socios.setMembresias(rs.getString(2));
			socios.setNombre(rs.getString(3));
			socios.setApPaterno(rs.getString(4));
			socios.setApMaterno(rs.getString(5));
			socios.setTelefeno(rs.getString(6));
			socios.setCorreo(rs.getString(7));
			datos.add(socios);
		}
		rs.close();
		st.close();
		return datos;
	}

	public ArrayList<Patrones> buscarPatron(String patron) throws SQLException {
		String query = "SELECT * FROM patrones " + "WHERE nombre_pts like '%" + patron + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Patrones> datos = new ArrayList<>();
		while (rs.next()) {
			Patrones patrones = new Patrones();
			patrones.setIdPatrones(rs.getInt(1));
			patrones.setNombre(rs.getString(2));
			patrones.setApPaterno(rs.getString(3));
			patrones.setApMaterno(rs.getString(4));
			patrones.setTelefeno(rs.getString(5));
			patrones.setCorreo(rs.getString(6));
			datos.add(patrones);
		}
		rs.close();
		st.close();
		return datos;
	}

	public ArrayList<Barcos> buscarBarco(String barco) throws SQLException {
		String query = "SELECT * FROM (SELECT a.id_bcs, b.nombre_scs, c.nombre_pts, d.nombre_tps, \r\n"
				+ "a.codigo_amarre, a.nombre_bcs, f.destino FROM barcos a\r\n"
				+ "LEFT JOIN socios b ON a.id_scs = b.id_scs\r\n"
				+ "LEFT JOIN patrones c ON a.id_pts = c.id_pts\r\n"
				+ "LEFT JOIN tipos_barcos d ON a.id_tps = d.id_tps\r\n"
				+ "LEFT JOIN barcos_salidas e ON e.id_bcs = a.id_bcs\r\n"
				+ "LEFT JOIN salidas f ON e.id_sls = f.id_sls) a WHERE a.nombre_bcs like '%" + barco + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Barcos> datos = new ArrayList<>();
		while (rs.next()) {
			Barcos barcos = new Barcos();
			barcos.setIdBarco(rs.getInt(1));
			barcos.setSocio(rs.getString(2));
			barcos.setPatron(rs.getString(3));
			barcos.setTipoBarco(rs.getString(4));
			barcos.setNumAmarre(rs.getString(5));
			barcos.setNombreBarco(rs.getString(6));
			barcos.setDestinos(rs.getString(7));
			datos.add(barcos);
		}
		rs.close();
		st.close();
		return datos;
	}

	public ArrayList<Salidas> buscarSalida(String salida) throws SQLException {
		String query = "SELECT * FROM salidas WHERE destino like '%" + salida + "%'";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Salidas> datos = new ArrayList<>();
		while (rs.next()) {
			Salidas salidas = new Salidas();
			salidas.setIdSalidas(rs.getInt(1));
			salidas.setDestino(rs.getString(2));
			salidas.setFecha(rs.getString(3));
			salidas.setHora(rs.getString(4));
			datos.add(salidas);
		}
		rs.close();
		st.close();
		return datos;
	}

	public ArrayList<Membresias> eleccionMembresias() throws SQLException {
		String query = "SELECT * FROM membresias";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<Membresias> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new Membresias(rs.getInt(1), rs.getString(2)));
		}
		rs.close();
		st.close();
		return datos;
	}
	
	public ArrayList<TiposBarcos> eleccionTiposBarcos() throws SQLException {
		String query = "SELECT * FROM tipos_barcos";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<TiposBarcos> datos = new ArrayList<>();
		while (rs.next()) {
			datos.add(new TiposBarcos(rs.getInt(1), rs.getString(2)));
		}
		rs.close();
		st.close();
		return datos;
	}
	
	public ArrayList<SociosEleccion> eleccionSocios() throws SQLException {
		String query = "SELECT id_scs, nombre_scs, apellido_pat_scs FROM socios";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<SociosEleccion> datos = new ArrayList<>();
		while (rs.next()) {
			SociosEleccion socio = new SociosEleccion();
			socio.setIdSocios(rs.getInt(1));
			socio.setNombre(rs.getString(2));
			socio.setApPaterno(rs.getString(3));
			datos.add(socio);
		}
		rs.close();
		st.close();
		return datos;
	}
	
	public ArrayList<PatronesEleccion> eleccionPatrones() throws SQLException {
		String query = "SELECT id_pts, nombre_pts, apellido_pat_pts FROM patrones";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<PatronesEleccion> datos = new ArrayList<>();
		while (rs.next()) {
			PatronesEleccion patron = new PatronesEleccion();
			patron.setIdPatron(rs.getInt(1));
			patron.setNombre(rs.getString(2));
			patron.setApPaterno(rs.getString(3));
			datos.add(patron);
		}
		rs.close();
		st.close();
		return datos;
	}
	
	public ArrayList<DestinoEleccion> eleccionDestinos() throws SQLException {
		String query = "SELECT id_sls, destino from salidas";
		Statement st = conexion.createStatement();
		ResultSet rs = st.executeQuery(query);
		ArrayList<DestinoEleccion> datos = new ArrayList<>();
		while (rs.next()) {
			DestinoEleccion destino = new DestinoEleccion();
			destino.setIdDestino(rs.getInt(1));
			destino.setDestino(rs.getString(2));
			datos.add(destino);
		}
		rs.close();
		st.close();
		return datos;
	}
	
	public int insertarBarco(BarcosSQL barco) throws SQLException {
		String query = "INSERT INTO barcos VALUES (null, ?, ?, ?, ?, ?)";
		PreparedStatement pr = conexion.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS );
		pr.setInt(1, barco.getSocio().getIdSocios());
		pr.setInt(2, barco.getPatron().getIdPatron());
		pr.setInt(3, barco.getTipoBarco().getIdTipoBarco());
		pr.setString(4, barco.getNumeroAmarre());
		pr.setString(5, barco.getNombre());
		pr.execute();
		ResultSet rs = pr.getGeneratedKeys();
		int id = -1;
		if (rs.next()) {
			id = rs.getInt(1);
		}
		rs.close();
		pr.close();
		return id;
	}

	public int insertarSocio(SociosSQL socio) throws SQLException {
		String query = "INSERT INTO socios VALUES(null, ?, ?, ?, ?, ?, ?)";
		PreparedStatement pr = conexion.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS );
		pr.setInt(1, socio.getMembresia().getIdMembresia());
		pr.setString(2, socio.getNombre());
		pr.setString(3, socio.getPaterno());
		pr.setString(4, socio.getMaterno());
		pr.setString(5, socio.getTelefono());
		pr.setString(6, socio.getCorreo());
		pr.execute();
		ResultSet rs = pr.getGeneratedKeys();
		int id = -1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		rs.close();
		pr.close();
		return id;
	}
	
	public int insertarPatron(Patrones patron) throws SQLException {
		String query = "INSERT INTO patrones VALUES(null, ?, ?, ?, ?, ?)";
		PreparedStatement pr = conexion.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS );
		pr.setString(1, patron.getNombre());
		pr.setString(2, patron.getApPaterno());
		pr.setString(3, patron.getApMaterno());
		pr.setString(4, patron.getTelefeno());
		pr.setString(5, patron.getCorreo());
		pr.execute();
		ResultSet rs = pr.getGeneratedKeys();
		int id = -1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		rs.close();
		pr.close();
		return id;
	}
	
	public int insertarSalidas (Salidas salida) throws SQLException {
		String query = "INSERT INTO salidas VALUES (null, ?, ?, ?)";
		PreparedStatement pr = conexion.prepareStatement(query,
				Statement.RETURN_GENERATED_KEYS );
		pr.setString(1, salida.getDestino());
		pr.setString(2, salida.getFecha());
		pr.setString(3, salida.getHora());
		pr.execute();
		ResultSet rs = pr.getGeneratedKeys();
		int id = -1;
		if(rs.next()) {
			id=rs.getInt(1);
		}
		rs.close();
		pr.close();
		return id;
	}
	
	public void insertarBarscosSalidas(BarcosSQL barco, DestinoEleccion destino) throws SQLException {
		String query = "INSERT INTO barcos_salidas VALUES (?, ?)";
		PreparedStatement pr = conexion.prepareStatement(query);
		pr.setInt(1, barco.getIdBarco());
		pr.setInt(2, destino.getIdDestino());
		pr.execute();
		pr.close();
	}
}
