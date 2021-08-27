import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule, HttpTestingController } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { Formulaire, Produit } from './produit';

import { ProduitService } from './produit.service';

describe('ProduitService', () => {
  let service: ProduitService;
  let httpTestingController: HttpTestingController;
  let httpClient: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ ProduitService ]
    });
    service = TestBed.inject(ProduitService);
    httpTestingController = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('#getValue id = 1 should return value',(done: DoneFn) => {
    const form: Formulaire = {
      id: 1,
      name: 'test',
      formulaire: [
        "source",
        "enrichment",
        "destination"
      ],
    };
    const produit: Produit = {
      id: 1,
      formulaireJSON: form
    };
    
    service.getProduit(1).subscribe(value => {
      expect(value).toEqual(produit);
      done();
    });

    // attention, il faut mettre le lien en entier
    const req = httpTestingController.expectOne('http://localhost:9090/api/produits/1');

    expect(req.request.method).toEqual("GET");

    req.flush(produit);
  });

  it('#addValue should add value on next id available',(done: DoneFn) => {
    const form: Formulaire = {
      id: 1,
      name: 'test',
      formulaire: [
        "source",
        "enrichment",
        "destination"
      ],
    };

    service.addProduit(form).subscribe(value => {
      expect(value).toEqual(form as unknown as Produit);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/produits');

    expect(req.request.method).toEqual("POST");

    req.flush(form);
  });

  it('#deleteValue should delete value id = 1',(done: DoneFn) => {
    const form: Formulaire = {
      id: 1,
      name: 'test',
      formulaire: [
        "source",
        "enrichment",
        "destination"
      ],
    };
    const produit: Produit = {
      id: 1,
      formulaireJSON: form
    };

    service.deleteProduit(1).subscribe(value => {
      expect(value).toEqual(produit);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/produits/1');

    expect(req.request.method).toEqual("DELETE");

    req.flush(produit);
  });

  it('#updateValue should change value id = 1',(done: DoneFn) => {
    const form: Formulaire = {
      id: 1,
      name: 'test',
      formulaire: [
        "source",
        "enrichment",
        "destination"
      ],
    };
    const produit: Produit = {
      id: 1,
      formulaireJSON: form
    };

    service.updateProduit(produit).subscribe(value => {
      expect(value).toEqual(produit);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/produits/1');

    expect(req.request.method).toEqual("PUT");

    req.flush(produit);
  });
});
