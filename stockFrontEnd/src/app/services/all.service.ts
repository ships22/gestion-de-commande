import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Produits } from "../models/produits";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root"
})
export class AllService {
  constructor(private httpClient: HttpClient) {}
  private url = environment.url;

  //produits -
  getAllProduits(): Observable<Produits[]> {
    return this.httpClient.get<Produits[]>(this.url + "produits");
  }
  ajouterProduit(produit: any): Observable<any> {
    return this.httpClient.post(this.url + "ajouter-produit", produit);
  }
  // createDvd(dvd) {
  //   this.httpClient.post(this.url + 'new/', dvd.value).subscribe(response => {
  //     console.log(dvd.value + ": from subs...");
  //   });
  // }
}
