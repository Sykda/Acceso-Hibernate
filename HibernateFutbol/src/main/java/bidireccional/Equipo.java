package bidireccional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Equipo {

	private long id;
	private Date fecha, fundacion;
	private String nombre, ciudad;
	private Entrenador entrenador;
	private Set<Jugador> jugadores = new HashSet<Jugador>();
	private Set<Competicion> competiciones =  new HashSet<Competicion>();

	public Equipo() {
	}

	public Equipo(Date fecha, Date fundacion, String nombre, String ciudad) {
		this.fecha = fecha;
		this.fundacion = fundacion;
		this.nombre = nombre;
		this.ciudad = ciudad;
	}

	@Id
	@Column
	@GeneratedValue
	public long getId() {
		return id;
	}

	@OneToMany(mappedBy = "equipo", cascade = CascadeType.ALL)
	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	@OneToOne(cascade = CascadeType.ALL)
	public Entrenador getEntrenador() {
		return entrenador;
	}

	@ManyToMany(mappedBy = "equipos")
	public Set<Competicion> getCompeticiones() {
		return competiciones;
	}
	
	public void addJugador(Jugador j) {
		jugadores.add(j);
	}
	
	public void addCompeticion(Competicion c) {
		competiciones.add(c);
	}

	public void setCompeticiones(Set<Competicion> competiciones) {
		this.competiciones = competiciones;
	}

	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFundacion() {
		return fundacion;
	}

	public void setFundacion(Date fundacion) {
		this.fundacion = fundacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

}
