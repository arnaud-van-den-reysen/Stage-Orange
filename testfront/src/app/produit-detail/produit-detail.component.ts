import { Location } from '@angular/common';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DataFormulaireService } from '../data-formulaire.service';
import { DataFormulaire } from '../dataFormulaire';
import { Produit } from '../produit';
import { ProduitService } from '../produit.service';

@Component({
  selector: 'app-produit-detail',
  templateUrl: './produit-detail.component.html',
  styleUrls: ['./produit-detail.component.scss']
})
export class ProduitDetailComponent implements OnInit {
  @Input() produit?: Produit;
  @Input() dataFormulaire?: DataFormulaire;

  constructor(
    private route: ActivatedRoute,
    private produitService: ProduitService,
    private dataFormulaireService: DataFormulaireService,
    private location: Location,
  ) { 
    this.getProduit();
    this.getFormulaireDataFormulaire();
  }

  ngOnInit(): void {
  }

  getProduit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.produitService.getProduit(id)
      .subscribe(produit => this.produit = produit);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    if (this.produit && this.dataFormulaire) {
      this.dataFormulaireService.updateDataFormulaire(this.dataFormulaire)
        .subscribe();
      this.produitService.updateProduit(this.produit)
        .subscribe(() => this.goBack());
      
    }
  }

  getFormulaireDataFormulaire() {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.dataFormulaireService.getFormulaireDataFormulaire(id)
      .subscribe(dataFormulaire => this.dataFormulaire = dataFormulaire);
  }
  
}
