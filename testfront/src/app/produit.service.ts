import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Formulaire, Produit } from './produit';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProduitService {

  API_SERVER = 'http://localhost:9090/api';

  /*
  GET /produits -> OK
  GET /produits/:id -> OK
  POST /produits -> OK?
  PUT /produits/:id -> OK
  DELETE /produits/:id -> OK
  PATCH /produits/:id -> NOK (Some browsers, servers and web app do not support it)
  */

  constructor(
    private http: HttpClient,
  ) { }

  /**
   * GET -> /produits
   * @returns 
   */
  getProduits(): Observable<Produit[]> {
    return this.http.get<Produit[]>(this.API_SERVER + '/produits')
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched Produits') }
      }));
  }

  /**
   * GET -> /produits/:id
   * @param id 
   * @returns 
   */
  getProduit(id: number): Observable<Produit> {
    return this.http.get<Produit>(this.API_SERVER + '/produits/' + id)
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched Produits ' + id) }
      }));
  }

  /**
   * POST -> /produits
   * @param form 
   * @returns 
   */
  addProduit(form: Formulaire): Observable<Produit>  {
    console.log("3: " + form);
    return this.http.post<Produit>(this.API_SERVER + '/produits',
      form,
      httpOptions
    ).pipe(
        tap({
          next: (x: Produit) => { console.log(x.formulaireJSON.id); },
          error: err => { console.error(err) },
          complete: () => { console.log('create Produit') }
    }));
  }

  /**
   * PUT -> /produits/:id
   * @param produit 
   * @returns 
   */
  updateProduit(produit: Produit): Observable<Produit> {
    return this.http.put<Produit>(this.API_SERVER + '/produits/' + produit.id,
      produit
    ).pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('update Produit ' + produit.id) }
    }));
  }

  /**
   * DELETE -> /produits/:id
   * @param id 
   * @returns 
   */
  deleteProduit(id: number): Observable<Produit> {
    return this.http.delete<Produit>(this.API_SERVER + '/produits/' + id,
      httpOptions
    ).pipe(
      tap({
        next: x => { console.log(x); },
        error: err => { console.error(err) },
        complete: () => { console.log('delete Produit ' + id) }
    }));
  }
}