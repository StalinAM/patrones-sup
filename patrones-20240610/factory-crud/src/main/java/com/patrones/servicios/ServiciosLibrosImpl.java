package com.patrones.servicios;

import java.util.ArrayList;
import java.util.List;

import com.patrones.DbConfig;
import com.patrones.factory.anotaciones.MiComponente;

import db.Libros;

@MiComponente(name = "ServiciosLibros", singleton = true)
public class ServiciosLibrosImpl implements ServiciosLibros {

	private DbConfig dbConfig;

	public void setDbConfig(DbConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	@Override
	public Libros buscarPorId(Integer id) {
		try {
			var con = dbConfig.getConnection();
			var pstmt = con.prepareStatement("SELECT * FROM libros WHERE id=?");
			pstmt.setInt(1, id);
			var rs = pstmt.executeQuery();

			if (rs.next()) {
				Libros ret = new Libros();

				ret.setTitulo(rs.getString("titulo"));
				ret.setIsbn(rs.getString("isbn"));

				return ret;

			}
			return null;
		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

	@Override
	public List<Libros> listarTodos() {
		// TODO Auto-generated method stub
		List<Libros> librosList = new ArrayList<>();
		try {
			var con = dbConfig.getConnection();
			var pstmt = con.prepareStatement("SELECT * FROM libros");
			var rs = pstmt.executeQuery();

			while (rs.next()) {
				Libros libro = new Libros();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setIsbn(rs.getString("isbn"));
				librosList.add(libro);
			}
		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
		return librosList;
	}

	@Override
	public void crear(Libros obj) {
		// TODO Auto-generated method stub
		try {
			var con = dbConfig.getConnection();

			// SI EL VALOR DE LA ID ES AUTOINCREMENTABLE EN LA BASE DE DATOS

//			var pstmt = con.prepareStatement("INSERT INTO libros (titulo, isbn) VALUES (?, ?)");
//			pstmt.setString(1, obj.getTitulo());
//			pstmt.setString(2, obj.getIsbn());

			// SI SE INGRESA EL VALOR DEL ID MEDIANTE EL OBJETO
			
			var pstmt = con.prepareStatement("INSERT INTO libros (id, titulo, isbn) VALUES (?, ?, ?)");
			pstmt.setInt(1, obj.getId());
			pstmt.setString(2, obj.getTitulo());
			pstmt.setString(3, obj.getIsbn());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void actualizar(Libros obj) {
		// TODO Auto-generated method stub
		try {
			var con = dbConfig.getConnection();

			var pstmt = con.prepareStatement("UPDATE libros SET titulo=?, isbn=? WHERE id=?");

			pstmt.setString(1, obj.getTitulo());
			pstmt.setString(2, obj.getIsbn());
			pstmt.setInt(3, obj.getId());
			pstmt.executeUpdate();

		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

	@Override
	public void eliminarPorId(Integer id) {
		// TODO Auto-generated method stub
		try {
			var con = dbConfig.getConnection();

			var pstmt = con.prepareStatement("DELETE FROM libros WHERE id=?");

			pstmt.setInt(1, id);
			pstmt.executeUpdate();

		} catch (Exception ex) {
			// TODO: handle exception
			throw new RuntimeException(ex);
		}
	}

}
