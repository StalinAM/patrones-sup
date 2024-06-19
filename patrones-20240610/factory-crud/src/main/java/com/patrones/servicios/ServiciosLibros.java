package com.patrones.servicios;

import java.util.List;

import com.patrones.DbConfig;

import db.Libros;

public interface ServiciosLibros {
	public void setDbConfig(DbConfig dbConfig);
	
	//CRUD
	public Libros buscarPorId(Integer id);//C
	public List<Libros> listarTodos();//R
	public void crear (Libros obj);//R
	public void actualizar (Libros obj);//U
	public void eliminarPorId(Integer id);//D
}
