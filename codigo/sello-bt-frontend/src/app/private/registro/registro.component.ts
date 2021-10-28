import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Sector } from '../../core/models/interfaces/sector.model';
import { RegistroDataService } from '../../core/services/registro-data.service';
import Swal from 'sweetalert2';
import { AuthService } from 'src/app/core/services/authService';
import { Observable } from 'rxjs';
import { map, startWith } from 'rxjs/operators';
import { NgxSpinnerService } from 'ngx-spinner';
import { Empresa } from '../../core/models/interfaces/empresa.model';

@Component({
  selector: 'app-registro',
  templateUrl: './registro.component.html',
  styleUrls: ['./registro.component.scss']
})
export class RegistroComponent implements OnInit {

  public frmRegistroEmpresa: FormGroup;
  listaSectores: Sector[] = [];
  filteredOptionSectores: Observable<Sector[]>;
  public empCodigo: number;
  public empNombreEmp: string;

  constructor(
    private readonly fb: FormBuilder,
    private _registroService: RegistroDataService,
    public authService: AuthService,
    public spinner: NgxSpinnerService,
  ) { }

  ngOnInit(): void {
    this.authService.validateLogin('private/registro');
    this.frmRegistroEmpresa = this.fb.group({
      cedulaRep: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      cedulaCon: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      nombreRep: [null, [Validators.required]],
      nombreEmp: [null, [Validators.required, Validators.minLength(5)]],
      nombreCon: [null, [Validators.required]],
      celularCon: ['', [Validators.required, Validators.minLength(10), Validators.maxLength(10)]],
      telefonoRep: ['', [Validators.required, Validators.minLength(9), Validators.maxLength(9)]],
      direccionRep: [null, [Validators.required]],
      direccionCon: [null, [Validators.required]],
      sector: [null, [Validators.required]],
      correoRep: [null, [Validators.required, Validators.email]],
      correoCon: [null, [Validators.required, Validators.email]],
      cargoRep: ['', [Validators.required, Validators.minLength(5)]],
      cargoCon: ['', [Validators.required, Validators.minLength(5)]],
      ruc: ['', [Validators.required, Validators.minLength(13), Validators.maxLength(13)]]
    });

    this.cargarSectores();
    this.empCodigo = null;

  }

  buscarCedulaRep() {
    let documento = this.frmRegistroEmpresa.get('cedulaRep').value;
    if (documento != null && documento != "") {
      this.spinner.show();
      this._registroService.consultarEmpresaPorCedulaRep(this.frmRegistroEmpresa.get('cedulaRep').value).subscribe(
        (empresa: any) => {
          if (empresa != null) {
            this.spinner.hide();
            // Mover datos recuperados de la empresa al formulario
            this.cargarSectores();
            this.moverDatosEmpresa(empresa);
            Swal.fire('La empresa ' + this.empNombreEmp + ' ya se encuentra registrada', '', 'info');
          } else {
            this._registroService.consultarCedula(this.frmRegistroEmpresa.get('cedulaRep').value).subscribe(cedulado => {
              if (cedulado[0] == null) {
                Swal.fire('No se encuentra la identificación ingresada', '', 'warning');
                this.spinner.hide();
              } else {
                this.empCodigo = null;
                this.empNombreEmp = null;
                let nombres: string = <string>cedulado[0].nombres;
                let direccion: string = <string>cedulado[0].nombreCalle;
                this.frmRegistroEmpresa.patchValue({
                  direccionRep: direccion,
                  nombreRep: nombres,
                });
              }
            });
            this.spinner.hide();
          }
        }
      );
    }
  }

  buscarCedulaCon() {
    let documento = this.frmRegistroEmpresa.get('cedulaCon').value;
    if (documento != null && documento != "") {
      this.spinner.show();
      this._registroService.consultarEmpresaPorCedulaCon(this.frmRegistroEmpresa.get('cedulaCon').value).subscribe(
        (empresa: any) => {
          if (empresa != null) {
            this.spinner.hide();
            Swal.fire('La identificación ya se encuentra registrada', '', 'info');

          } else {
            this._registroService.consultarCedula(this.frmRegistroEmpresa.get('cedulaCon').value).subscribe(cedulado => {
              if (cedulado[0] == null) {
                Swal.fire('No se encuentra la identificación ingresada', '', 'warning');
                this.spinner.hide();
              } else {
                let nombres: string = <string>cedulado[0].nombres;
                let direccion: string = <string>cedulado[0].nombreCalle;
                this.frmRegistroEmpresa.patchValue({
                  direccionCon: direccion,
                  nombreCon: nombres,
                });
              }
            });
            this.spinner.hide();
          }
        }
      );
    }
  }

  cargarSectores() {
    this._registroService.consultarSectores().subscribe(sectores => {
      this.listaSectores = sectores;
      this.filteredOptionSectores = this.frmRegistroEmpresa.get("sector").valueChanges
        .pipe(
          startWith(''),
          map(value => typeof value == 'string' ? value : value.semNombre),
          map(name => name ? this._filterSector(name) : this.listaSectores.slice())
        );
    });
  }
  displayFnSector(sector: Sector): string {
    return sector && sector.semNombre ? sector.semNombre : '';
  }
  private _filterSector(name: string): Sector[] {
    const filterValue = name.toLowerCase();
    return this.listaSectores.filter(option => option.semNombre.toLowerCase().indexOf(filterValue) === 0);
  }

  guardarRegistro() {
    let cedula = this.frmRegistroEmpresa.get("cedulaRep").value;

    let sector: string = this.frmRegistroEmpresa.get("sector").value;
    let sectorSeleccionado = this.listaSectores.find(sectorBuscar => sectorBuscar.semNombre === sector.toUpperCase());
    if (sectorSeleccionado != null) {
      if (cedula != null && cedula != "") {
        this.spinner.show();
        let registro = {
          codigo: this.empCodigo,
          cedulaRep: this.frmRegistroEmpresa.get("cedulaRep").value,
          cedulaCon: this.frmRegistroEmpresa.get("cedulaCon").value,
          nombreRep: this.frmRegistroEmpresa.get("nombreRep").value,
          nombreCon: this.frmRegistroEmpresa.get("nombreCon").value,
          nombreEmp: this.frmRegistroEmpresa.get("nombreEmp").value,
          celularCon: this.frmRegistroEmpresa.get("celularCon").value,
          telefonoRep: this.frmRegistroEmpresa.get("telefonoRep").value,
          direccionRep: this.frmRegistroEmpresa.get("direccionRep").value,
          direccionCon: this.frmRegistroEmpresa.get("direccionCon").value,
          cargoRep: this.frmRegistroEmpresa.get("cargoRep").value,
          cargoCon: this.frmRegistroEmpresa.get("cargoCon").value,
          correoRep: this.frmRegistroEmpresa.get("correoRep").value,
          correoCon: this.frmRegistroEmpresa.get("correoCon").value,
          ruc: this.frmRegistroEmpresa.get("ruc").value,
          sector: sectorSeleccionado.semCodigo
        };
        this._registroService.guardarRegistro(registro).subscribe((respuesta: any) => {
          this.spinner.hide();
          Swal.fire('Información guardada Empresa: ' + respuesta.codigoRespuesta, 'Se ha enviado correo a: '+this.frmRegistroEmpresa.get("correoCon").value, 'success');

          //se reinicia la pagina en 3500 ms. jbrito - 20211023
          setTimeout(() => { window.location.reload() }, 3500);

        }, (error) => {
          this.spinner.hide();
          Swal.fire('No se pudo almacenar la información', '', 'error');
        }

        );
      }
    } else {
      Swal.fire('La sede seleccionada no se encuentra registrada', '', 'error');
    }
  }

  limpiarFormulario() {
    this.frmRegistroEmpresa.reset();
  }

  moverDatosEmpresa(empresa: Empresa) {
    let sectorAux = "";
    for (var key in empresa.sbtSectorEmpresa) {
      //console.log(' name=' + key + ' value=' + empresa.sbtSectorEmpresa[key]);
      sectorAux = empresa.sbtSectorEmpresa[key];
    }

    this.empNombreEmp = empresa.empNombreEmp;
    this.empCodigo = empresa.empCodigo;

    this.frmRegistroEmpresa.patchValue({
      cedulaRep: empresa.empCedulaRep,
      cedulaCon: empresa.empCedulaCon,
      celularCon: empresa.empCelularCon,
      nombreRep: empresa.empNombreRep,
      nombreCon: empresa.empNombreCon,
      nombreEmp: empresa.empNombreEmp,
      correoRep: empresa.empCorreoRep,
      sector: sectorAux,
      direccionRep: empresa.empDireccionRep,
      direccionCon: empresa.empDireccionCon,
      ruc: empresa.empRuc,
      correoCon: empresa.empCorreoCon,
      cargoRep: empresa.empCargoRep,
      cargoCon: empresa.empCargoCon,
      telefonoRep: empresa.empTelefonoRep
    });
  }

  reiniciarPagina() {
    window.location.reload();
  };

}