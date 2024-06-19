package com.patrones;

import com.patrones.factory.Factory;
import com.patrones.factory.FactoryImpl;
import com.patrones.servicios.ServiciosLibros;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import db.Libro;

public class PrincipalCrud {

	public static void main(String[] args) throws Exception {

		Factory fact = new FactoryImpl();
		fact.init("com.patrones");
		DbConfig dbConfig = fact.create("dbConfig");
		ServiciosLibros servicio = fact.create("ServiciosLibros");

		servicio.setDbConfig(dbConfig);

		Libro libro = new Libro();
		// BUSCAR
//		 var libro1 = servicio.buscarPorId(2);
//		 System.out.println(libro1.getTitulo());

		// LISTAR
		 var libros = servicio.listarTodos();
		 System.out.println(libros.toString());

		// AGREGAR CON ID AUTOINCREMENTABLE
//		 libro.setTitulo("libro 03");
//		 libro.setIsbn("333-33");
//		 System.out.println(libro.toString());;
//		 servicio.crear(libro);

		// AGREGAR CON ID MEDIANTE OBJETO
//		libro.setId(4);
//		libro.setTitulo("libro 04");
//		libro.setIsbn("4444-44");
//		System.out.println(libro.toString());
//		servicio.crear(libro);

		// ELIMINAR
//		servicio.eliminarPorId(3);

		// ACTUALIZAR
//		libro.setId(2);
//		libro.setTitulo("libro 03");
//		libro.setIsbn("333-33");
//		servicio.actualizar(libro);
	}

}
