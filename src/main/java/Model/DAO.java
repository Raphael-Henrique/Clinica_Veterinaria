package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/agendamento_Vet?useTimeZone=true&serverTimeZone=UTC";
	private String user = "root";
	private String password = "Raphael#24";

	private Connection conectarBD() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirAgendamento(JavaBeans agendamento) {
		String create = "INSERT INTO Consulta(nome_cliente, nome_pet, id_anim, id_vet, data_consulta) VALUES (?, ?, ?, ?, ?)";
		try {
			Connection con = conectarBD();

			PreparedStatement pst = con.prepareStatement(create);
			
			pst.setString(1, agendamento.getNome_cliente());
			pst.setString(2, agendamento.getNome_pet());
			pst.setString(3, agendamento.getId_anim());
			pst.setString(4, agendamento.getId_vet());
			pst.setString(5, agendamento.getData_consulta());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* Método READ/CRUD */

	public ArrayList<JavaBeans> listarConsultas() {
		ArrayList<JavaBeans> consultas = new ArrayList<>();
		String read = "SELECT * FROM Consulta";

		try {
			Connection con = conectarBD();

			PreparedStatement pst = con.prepareStatement(read);

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				String id_consulta = rs.getString(1);
				String nome_cliente = rs.getString(2);
				String nome_pet = rs.getString(3);
				String id_anim = rs.getString(4);
				String id_vet = rs.getString(5);
				String data_consulta = rs.getString(6);

				consultas.add(new JavaBeans(id_consulta, nome_cliente, nome_pet, id_anim, id_vet, data_consulta));
			}

			con.close();
			return consultas;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/* Método UPDATE/CRUD */

	public void selecionarConsulta(JavaBeans agendamento) {
		String read2 = "SELECT * FROM Consulta WHERE id_consulta = ?";

		try {
			Connection con = conectarBD();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, agendamento.getId_consulta());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				agendamento.setId_consulta(rs.getString(1));
				agendamento.setNome_cliente(rs.getString(2));
				agendamento.setNome_pet(rs.getString(3));
				agendamento.setId_anim(rs.getString(4));
				agendamento.setId_vet(rs.getString(5));
				agendamento.setData_consulta(rs.getString(6));
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public void alterarConsulta(JavaBeans agendamento) {
		String create = "UPDATE Consulta SET nome_cliente=?, nome_pet=?, id_anim=?, id_vet=?, data_consulta=? WHERE id_consulta=?";
		try {
			Connection con = conectarBD();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, agendamento.getNome_cliente());
			pst.setString(2, agendamento.getNome_pet());
			pst.setString(3, agendamento.getId_anim());
			pst.setString(4, agendamento.getId_vet());
			pst.setString(5, agendamento.getData_consulta());
			pst.setString(6, agendamento.getId_consulta());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* Método DELETE/CRUD */

	public void deletarConsulta(JavaBeans agendamento) {
		String delete = "DELETE FROM Consulta WHERE id_consulta = ?";
		try {
			Connection con = conectarBD();
			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, agendamento.getId_consulta());
			pst.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}