import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { ProduitsComponent } from "./components/produits/produits.component";
import { ClientsComponent } from "./components/clients/clients.component";
import { CommandesComponent } from "./components/commandes/commandes.component";

const routes: Routes = [
  { path: "produits", component: ProduitsComponent },
  { path: "clients", component: ClientsComponent },
  { path: "commandes", component: CommandesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
