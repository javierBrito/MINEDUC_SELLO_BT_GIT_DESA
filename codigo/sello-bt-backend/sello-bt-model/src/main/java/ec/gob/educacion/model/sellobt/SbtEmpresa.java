package ec.gob.educacion.model.sellobt;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the SBT_EMPRESA database table.
 * 
 */
@Entity
@Table(name="GIEE_SBT_EMPRESA", schema="GIEE")
@NamedQuery(name="SbtEmpresa.findAll", query="SELECT t FROM SbtEmpresa t")
public class SbtEmpresa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SBT_EMPRESA_EMPCODIGO_GENERATOR", sequenceName="GIEE.SEQ_SBT_EMPRESA", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SBT_EMPRESA_EMPCODIGO_GENERATOR")
	@Column(name="EMP_CODIGO")
	private long empCodigo;

	@Column(name="EMP_CEDULAREP")
	private String empCedulaRep;
	@Column(name="EMP_NOMBREREP")
	private String empNombreRep;
	@Column(name="EMP_NOMBREEMP")
	private String empNombreEmp;
	@Column(name="EMP_CARGOREP")
	private String empCargoRep;
	@Column(name="EMP_CORREOREP")
	private String empCorreoRep;
	@Column(name="EMP_DIRECCIONREP")
	private String empDireccionRep;
	@Column(name="EMP_RUC")
	private String empRuc;
	@Column(name="EMP_TELEFONOREP")
	private String empTelefonoRep;

	
	@ManyToOne
	@JoinColumn (name="SEM_CODIGO")	
	private SbtSectorEmpresa sbtSectorEmpresa;
	
	@Column(name="EMP_CEDULACON")
	private String empCedulaCon;
	@Column(name="EMP_NOMBRECON")
	private String empNombreCon;
	@Column(name="EMP_CARGOCON")
	private String empCargoCon;
	@Column(name="EMP_CORREOCON")
	private String empCorreoCon;
	@Column(name="EMP_DIRECCIONCON")
	private String empDireccionCon;
	@Column(name="EMP_CELULARCON")
	private String empCelularCon;

	public long getEmpCodigo() {
		return empCodigo;
	}

	public void setEmpCodigo(long empCodigo) {
		this.empCodigo = empCodigo;
	}

	public String getEmpCedulaRep() {
		return empCedulaRep;
	}

	public void setEmpCedulaRep(String empCedulaRep) {
		this.empCedulaRep = empCedulaRep;
	}

	public String getEmpNombreRep() {
		return empNombreRep;
	}

	public void setEmpNombreRep(String empNombreRep) {
		this.empNombreRep = empNombreRep;
	}

	public String getEmpNombreEmp() {
		return empNombreEmp;
	}

	public void setEmpNombreEmp(String empNombreEmp) {
		this.empNombreEmp = empNombreEmp;
	}

	public String getEmpCargoRep() {
		return empCargoRep;
	}

	public void setEmpCargoRep(String empCargoRep) {
		this.empCargoRep = empCargoRep;
	}

	public String getEmpCorreoRep() {
		return empCorreoRep;
	}

	public void setEmpCorreoRep(String empCorreoRep) {
		this.empCorreoRep = empCorreoRep;
	}

	public String getEmpDireccionRep() {
		return empDireccionRep;
	}

	public void setEmpDireccionRep(String empDireccionRep) {
		this.empDireccionRep = empDireccionRep;
	}

	public String getEmpRuc() {
		return empRuc;
	}

	public void setEmpRuc(String empRuc) {
		this.empRuc = empRuc;
	}

	public String getEmpTelefonoRep() {
		return empTelefonoRep;
	}

	public void setEmpTelefonoRep(String empTelefonoRep) {
		this.empTelefonoRep = empTelefonoRep;
	}

	public String getEmpCedulaCon() {
		return empCedulaCon;
	}

	public void setEmpCedulaCon(String empCedulaCon) {
		this.empCedulaCon = empCedulaCon;
	}

	public String getEmpNombreCon() {
		return empNombreCon;
	}

	public void setEmpNombreCon(String empNombreCon) {
		this.empNombreCon = empNombreCon;
	}

	public String getEmpCargoCon() {
		return empCargoCon;
	}

	public void setEmpCargoCon(String empCargoCon) {
		this.empCargoCon = empCargoCon;
	}

	public String getEmpCorreoCon() {
		return empCorreoCon;
	}

	public void setEmpCorreoCon(String empCorreoCon) {
		this.empCorreoCon = empCorreoCon;
	}

	public String getEmpDireccionCon() {
		return empDireccionCon;
	}

	public void setEmpDireccionCon(String empDireccionCon) {
		this.empDireccionCon = empDireccionCon;
	}

	public String getEmpCelularCon() {
		return empCelularCon;
	}

	public void setEmpCelularCon(String empCelularCon) {
		this.empCelularCon = empCelularCon;
	}

	public SbtSectorEmpresa getSbtSectorEmpresa() {
		return sbtSectorEmpresa;
	}

	public void setSbtSectorEmpresa(SbtSectorEmpresa sbtSectorEmpresa) {
		this.sbtSectorEmpresa = sbtSectorEmpresa;
	}
}