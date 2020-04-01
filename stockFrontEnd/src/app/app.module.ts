import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";
import { AppRoutingModule } from "./app-routing.module";
import { FormsModule } from "@angular/forms";

import { AppComponent } from "./app.component";
import { HeaderComponent } from "./components/header/header.component";
import { ProduitsComponent } from "./components/produits/produits.component";
import { ClientsComponent } from "./components/clients/clients.component";
import { CommandesComponent } from "./components/commandes/commandes.component";
import { AllService } from "./services/all.service";

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    ProduitsComponent,
    ClientsComponent,
    CommandesComponent
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [AllService],
  bootstrap: [AppComponent]
})
export class AppModule {}
