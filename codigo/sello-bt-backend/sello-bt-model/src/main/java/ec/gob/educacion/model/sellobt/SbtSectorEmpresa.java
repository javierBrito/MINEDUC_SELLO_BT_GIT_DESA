package ec.gob.educacion.model.sellobt;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the GIEE_SBT_SECTOR_EMPRESA database table.
 * 
 */
@Entity
@Table(name="GIEE_SBT_SECTOR_EMPRESA", schema="GIEE")
@NamedQuery(name="SbtSectorEmpresa.findAll", query="SELECT t FROM SbtSectorEmpresa t")
public class SbtSectorEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SEM_CODIGO")
	private long semCodigo;

	@Column(name="SEM_NOMBRE")
	private String semNombre;

	public SbtSectorEmpresa() {
	}

	public long getSemCodigo() {
		return semCodigo;
	}

	public void setSemCodigo(long semCodigo) {
		this.semCodigo = semCodigo;
	}

	public String getSemNombre() {
		return semNombre;
	}

	public void setSemNombre(String semNombre) {
		this.semNombre = semNombre;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}