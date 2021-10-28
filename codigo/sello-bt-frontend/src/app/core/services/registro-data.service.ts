import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Registro } from '../models/interfaces/registro.model';
import { catchError } from 'rxjs/operators';
import { throwError, Observable } from 'rxjs';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/core/services/authService';
import { Sector } from '../models/interfaces/sector.model';
@Injectable({
  providedIn: 'root'
})
export class RegistroDataService {
  url: string = environment.url_back_end;
  
  //Para utilizar el servicio de cedulado desde Puntos de Encuentro
  url_pen: string = environment.url_back_end_pen;
  header = {
    headers: new HttpHeaders().set(
      'Authorization',
      localStorage.getItem('token')
    ),
  };
  constructor(
    public http: HttpClient,
    private authService: AuthService,
    private router: Router

  ) { }
  private isNoAutorizado(e): boolean {
    if (e.status === 401) {
      if (this.authService.isAuthenticated()) {
        this.authService.logout();
      }
      this.router.navigate(['/login']);
      return true;
    }
    if (e.status === 403) {
      this.authService.logout();
      this.router.navigate(['/login']);
      return true;
    }
    return false;
  }

  consultarCedula(cedula: string) {
    //NO FUNCIONA
    //Para utilizar el servicio de cedulado desde Puntos de Encuentro
    //let url_ws = `${this.url_pen}/private/buscarPorCedula/${cedula}`;
    //console.log("url_ws", url_ws);
    //La consola muestra esto = http://10.200.10.15/PuntosdeReencuentro/private/buscarPorCedula/1707025746
    
    //SI FUNCIONA
    let url_ws = `${this.url}/private/buscarPorCedula/${cedula}`;
    console.log("url_ws", url_ws);
    //La consola muestra esto = http://localhost:8080/SelloBt/private/buscarPorCedula/1707025746
    return this.http.get(url_ws, this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  consultarEmpresaPorCedulaRep(cedula: string) {
    let url_ws = `${this.url}/private/buscarEmpresaPorCedulaRep/${cedula}`;
    return this.http.get(url_ws, this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  consultarEmpresaPorCedulaCon(cedula: string) {
    let url_ws = `${this.url}/private/buscarEmpresaPorCedulaRep/${123}`;
    return this.http.get(url_ws, this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  consultarSectores() {
    let url_ws = `${this.url}/private/sector`;
    return this.http.get<Sector[]>(url_ws, this.header).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  guardarRegistro(formulario: Registro) {
    let url_ws = `${this.url}/private/guardarEmpresa`;
    let jsonEnvio = {
      "empCodigo": formulario.codigo,
      "empCedulaRep": formulario.cedulaRep,
      "empCedulaCon": formulario.cedulaCon,
      "empCelularCon": formulario.celularCon,
      "empNombreRep": formulario.nombreRep,
      "empNombreCon": formulario.nombreCon,
      "empNombreEmp": formulario.nombreEmp,
      "empCorreoRep": formulario.correoRep,
      "semCodigo": formulario.sector,
      "empDireccionRep": formulario.direccionRep,
      "empDireccionCon": formulario.direccionCon,
      "empRuc": formulario.ruc,
      "empCorreoCon": formulario.correoCon,
      "empCargoRep": formulario.cargoRep,
      "empCargoCon": formulario.cargoCon,
      "empTelefonoRep": formulario.telefonoRep,
    }
    return this.http.post(url_ws, jsonEnvio, {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': localStorage.getItem('token')
      })
    }).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }

  guardarRegistroExcel(formulario: Registro) {
    let url_ws = `${this.url}/private/guardarEstudianteExcel`;
    let jsonEnvio = {
      "empCedulaRep": formulario.cedulaRep,
      "estMovil": formulario.celularCon,
      "empNombreRep": formulario.nombreRep,
      "usuCodigo": localStorage.getItem('codUsuario'),
      "codigoSede": formulario.sector,
      "empDireccionRep": formulario.direccionRep,
    }
    return this.http.post(url_ws, jsonEnvio, {
      headers: new HttpHeaders({
        'Content-type': 'application/json',
        'Authorization': localStorage.getItem('token')
      })
    }).pipe(
      catchError((e) => {
        this.isNoAutorizado(e);
        return throwError(e);
      })
    );
  }
}
