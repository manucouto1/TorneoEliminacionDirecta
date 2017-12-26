package dominio.entidades;

public class Jugador {
	
	private int id;
	private String nombre;
	private int edad;
	private int tipo;
	
	public Jugador(){}

	public Jugador(int id, String nombre, int edad, int tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
		this.tipo = tipo;
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

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", edad=" + edad + ", tipo=" + tipo + "]";
	}
	
	
}
