import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { DataFormulaire } from './dataFormulaire';

@Injectable({
  providedIn: 'root'
})
export class DataFormulaireService {

  API_SERVER = 'http://localhost:9090/api';

  /*
  GET /dataFormulaire/:id -> OK
  PUT /dataFormulaire/:id -> OK
  */

  constructor(
    private http: HttpClient,
  ) { }

  /**
   * GET -> /dataFormulaire/:id
   * @returns DataFormulaire
   */
  getDataFormulaire(id: number): Observable<DataFormulaire> {
    return this.http.get<DataFormulaire>(this.API_SERVER + '/dataFormulaire/' + id)
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched dataFormulaire ' + id) }
      }));
  }

  /**
   * GET -> /dataFormulaire/formulaire/:id
   * @param id 
   * @returns 
   */
  getFormulaireDataFormulaire(id: number): Observable<DataFormulaire> {
    return this.http.get<DataFormulaire>(this.API_SERVER + '/dataFormulaire/formulaire/' + id)
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched dataFormulaire ' + id) }
      }));
  }

  /**
   * PUT -> /dataFormulaire/:id
   * @param DataFormulaire 
   * @returns 
   */
   updateDataFormulaire(dataFormulaire: DataFormulaire): Observable<DataFormulaire> {
    return this.http.put<DataFormulaire>(this.API_SERVER + '/dataFormulaire/' + dataFormulaire.id,
      dataFormulaire
    ).pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('update dataFormulaire ' + dataFormulaire.id) }
    }));
  }

}
