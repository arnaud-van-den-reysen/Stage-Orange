import { TestBed } from '@angular/core/testing';
import { Product, Jdoc } from './product';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing';

import { ProductService } from './product.service';
import { HttpClient } from '@angular/common/http';

describe('ProductService', () => {
  let service: ProductService;
  let httpTestingController: HttpTestingController;
  let httpClient: HttpClient;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [ HttpClientTestingModule ],
      providers: [ ProductService ]
    });
    service = TestBed.inject(ProductService);
    httpTestingController = TestBed.inject(HttpTestingController);
    httpClient = TestBed.inject(HttpClient);
  });

  afterEach(() => {
    httpTestingController.verify();
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });

  it('#getValue id = 4 should return value JSON = {1,"test","book"}',(done: DoneFn) => {
    const json: Jdoc = {
      idprod: 1,
      nameprod: 'test',
      description: 'book',
    };
    const product: Product = {
      id: 4,
      jdoc: json
    };
    
    service.get_jdoc_id(4).subscribe(value => {
      expect(value).toEqual(product);
      done();
    });

    // attention, il faut mettre le lien en entier
    const req = httpTestingController.expectOne('http://localhost:9090/api/test_json/test_json/4');

    expect(req.request.method).toEqual("GET");

    req.flush(product);
  });

  it('#addValue should add value on next id available',(done: DoneFn) => {
    const json: Jdoc = {
      idprod: 666,
      nameprod: 'test',
      description: 'testing',
    };

    service.add_jdoc(json).subscribe(value => {
      expect(value).toEqual(json as unknown as Product);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/test_json/test_json');

    expect(req.request.method).toEqual("POST");

    req.flush(json);
  });

  it('#deleteValue should delete value id = 8',(done: DoneFn) => {
    const json: Jdoc = {
      idprod: 2,
      nameprod: 'essai',
      description: 'livre',
    };
    const product: Product = {
      id: 8,
      jdoc: json
    };

    service.delete_jdoc(8).subscribe(value => {
      expect(value).toEqual(product);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/test_json/test_json/8');

    expect(req.request.method).toEqual("DELETE");

    req.flush(product);
  });

  it('#updateValue should change value id = 12',(done: DoneFn) => {
    const json: Jdoc = {
      idprod: 3,
      nameprod: 'Mesure de performance',
      description: 'Mesure de performance',
    };
    const product: Product = {
      id: 12,
      jdoc: json
    };

    service.update_jdoc(product).subscribe(value => {
      expect(value).toEqual(product);
      done();
    });

    const req = httpTestingController.expectOne('http://localhost:9090/api/test_json/test_json');

    expect(req.request.method).toEqual("PUT");

    req.flush(product);
  });
});
