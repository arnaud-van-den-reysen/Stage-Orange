import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { tap } from 'rxjs/operators';
import { Jdoc, Product } from './product';

const httpOptions = {
  headers: new HttpHeaders({
    //'Access-Control-Allow-Origin': '*',
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  API_SERVER = 'http://localhost:9090/api';
  
  constructor(
    private http: HttpClient,
  ) { }

  get_jdoc(): Observable<Product[]> {
    return this.http.get<Product[]>(this.API_SERVER + '/test_json')
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched Products') }
      }));
  }

  get_jdoc_id(id: number): Observable<Product> {
    return this.http.get<Product>(this.API_SERVER + '/test_json/test_json/' + id)
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('fetched Product ' + id) }
      }));
  }

  add_jdoc(jdoc: Jdoc): Observable<Product>  {
    return this.http.post<Product>(this.API_SERVER + '/test_json/test_json',
      jdoc,
      httpOptions
    ).pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('post Product') }
    }));
  }
  
  delete_jdoc(id: number): Observable<Product> {
    return this.http.delete<Product>(this.API_SERVER + '/test_json/test_json/' + id,
      httpOptions
    ).pipe(
      tap({
        next: x => { console.log(x); },
        error: err => { console.error(err) },
        complete: () => { console.log('delete Product ' + id) }
    }));
  }

  update_jdoc(p: Product): Observable<Product> {
    return this.http.put<Product>(this.API_SERVER + '/test_json/test_json',p)
      .pipe(
        tap({
          next: x => { console.log(x); },
          error: err => { console.error(err) },
          complete: () => { console.log('update Product ' + p.id) }
      }));
  }

}
