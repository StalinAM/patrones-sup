package db;

public class Libros {

	private int id;
	private String titulo;
	private String isbn;

	public Libros() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "id=" + id + ", titulo=" + titulo + ", isbn=" + isbn + "\n";
	}

}
