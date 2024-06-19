package com.patrones.servicios;

import java.util.List;

import com.patrones.DbConfig;

import db.Libro;

public interface ServiciosLibros {
	public void setDbConfig(DbConfig dbConfig);
	
	//CRUD
	public Libro buscarPorId(Integer id);//C
	public List<Libro> listarTodos();//R
	public void crear (Libro obj);//R
	public void actualizar (Libro obj);//U
	public void eliminarPorId(Integer id);//D
}
