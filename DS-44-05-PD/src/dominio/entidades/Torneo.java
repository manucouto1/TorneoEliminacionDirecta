package dominio.entidades;

public class Torneo {
	
	private int id;
	private String nombre;
	private int edad;
	private int estado;
	
	public Torneo(){
		
	}
	
	public Torneo(int id, String nombre, int edad, int estado) {
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.estado = estado;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Torneo [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", estado=" + estado + "]";
	}
	
	
	
}
