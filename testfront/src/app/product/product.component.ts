import { Component, OnInit } from '@angular/core';

import { ProductService } from '../product.service';
import { Jdoc, Product } from '../product';
import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
   
  productForm: FormGroup = this.formBuilder.group({
    idprod: [''],
    nameprod: [''],
    description: [''],
  });

  constructor(
    private productService: ProductService,
    private formBuilder: FormBuilder,
  ) {
    this.getProducts();
  }

  ngOnInit() {
    
  }

  getProducts(): void {
    this.productService.get_jdoc()
      .subscribe(products => this.products = products);
  }

  delete_jdoc(product: Product): void {
    this.products =  this.products.filter(h => h !== product);
    this.productService.delete_jdoc(product.id).subscribe();
  }

  onSubmit(jdoc: Jdoc) {
    if (!jdoc) { return; }
    this.productService.add_jdoc(jdoc)
      .subscribe(product => {
        this.products.push(product);
      });
  }
}
