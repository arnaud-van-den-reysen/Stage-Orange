import { Component, Input, OnInit, HostBinding } from '@angular/core';
import { FormArray, FormBuilder, FormGroup } from '@angular/forms';
import { Formulaire, Produit } from '../produit';
import { ProduitService } from '../produit.service';

@Component({
  selector: 'app-menu-user',
  templateUrl: './menu-user.component.html',
  styleUrls: ['./menu-user.component.scss']
})
export class MenuUserComponent implements OnInit {

  produits: Produit[] = [];

  produitForm: FormGroup = this.formBuilder.group({
    id: [''],
    name: [''],
    formulaire: this.formBuilder.array([
      this.formBuilder.control('')
    ])
  });

  constructor(
    private formBuilder: FormBuilder,
    private produitService: ProduitService,
  ) {
    this.getProduits();
  }

  ngOnInit(): void {
  }

  /**
   * récupère grâce au service Produit l'ensemble des produits dans la BDD
   */
  getProduits(): void {
    this.produitService.getProduits()
      .subscribe(produits => this.produits = produits);
  }

  /**
   * Supprime un produit de la BDD
   * @param produit 
   */
  deleteProduit(produit: Produit): void {
    this.produits =  this.produits.filter(h => h !== produit);
    this.produitService.deleteProduit(produit.id).subscribe();
  }

  /**
   * addProduit() ajoute le param dans la BDD 
   * .subscribe() permet de récupérer cette valeur avec le return du back
   * .push() envoi cette valeur dans le tableau et permet l'update du front en direct
   * @param form 
   * @returns addProduit(form)
   */
  onSubmit(form: Formulaire) {
    if (!form) { return; }
    console.log("1: " + form);
    this.produitService.addProduit(form)
      .subscribe((produit: Produit) => {
        this.produits.push(produit);
        console.log("2: " + produit);
      });
  }

  get formulaire() {
    return this.produitForm.get('formulaire') as FormArray;
  }

  addInputFormulaire() {
    this.formulaire.push(this.formBuilder.control(''));
  }

  // what a player! 
  removeInputFormulaire(index: number) {
    this.formulaire.removeAt(index);
  }

}
