// This file can be replaced during build by using the `fileReplacements` array.
// `ng build --prod` replaces `environment.ts` with `environment.prod.ts`.
// The list of file replacements can be found in `angular.json`.

export const environment = {
    production: true,
    url_back_end: 'http://localhost:8080/SelloBt',
    //url_back_end: 'http://10.200.10.15/SelloBt',
    //url_back_end: 'https://pre-academico.educacion.gob.ec/SelloBt' //preproduccion
    //url_back_end: 'https://aplicaciones.educacion.gob.ec/SelloBt' //
    
    //Para utilizar el servicio de cedulado desde Puntos de Encuentro
    url_back_end_pen: 'http://10.200.10.15/PuntosdeReencuentro', //desarrollo punto de encuentro 
    //url_back_end: 'https://pre-academico.educacion.gob.ec/PuntosdeReencuentro' //preproduccion
    //url_back_end: 'https://aplicaciones.educacion.gob.ec/PuntosdeReencuentro' //
};

/*
 * For easier debugging in development mode, you can import the following file
 * to ignore zone related error stack frames such as `zone.run`, `zoneDelegate.invokeTask`.
 *
 * This import should be commented out in production mode because it will have a negative impact
 * on performance if an error is thrown.
 */
// import 'zone.js/dist/zone-error';  // Included with Angular CLI.
