import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MenuUserComponent } from './menu-user/menu-user.component';
import { ProductDetailComponent } from './product-detail/product-detail.component';
import { ProductComponent } from './product/product.component';
import { ProduitDetailComponent } from './produit-detail/produit-detail.component';


const routes: Routes = [
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },
  { path: 'product', component: ProductComponent },
  { path: 'dashboard', component: DashboardComponent},
  { path: 'detail/:id', component: ProductDetailComponent},
  { path: 'menu-user', component: MenuUserComponent},
  { path: 'detailProduit/:id', component: ProduitDetailComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
