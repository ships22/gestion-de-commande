import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ProduitsComponent } from "./components/produits/produits.component";
import { ClientsComponent } from "./components/clients/clients.component";
import { CommandesComponent } from "./components/commandes/commandes.component";
import { EditProduitsComponent } from "./components/produits/edit-produits/edit-produits.component";

const routes: Routes = [
  { path: "produits", component: ProduitsComponent },
  { path: "edit-produit/:id", component: EditProduitsComponent },
  { path: "clients", component: ClientsComponent },
  { path: "commandes", component: CommandesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
