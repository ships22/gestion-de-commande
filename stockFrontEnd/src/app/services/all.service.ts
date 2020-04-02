import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { environment } from "src/environments/environment";
import { Produits } from "../models/produits";
import { Observable } from "rxjs";
import { Clients } from "../models/clients";
import { Commandes } from "../models/commandes";

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
  editProduit(item) {
    return this.httpClient.put(this.url + "modifier-produit", item);
  }
  getProduitById(id): Observable<Produits> {
    return this.httpClient.get<Produits>(this.url + "produitById/" + id);
  }
  deleteItem(item: any): Observable<any> {
    return this.httpClient.delete<any>(
      this.url + "suprimer-produit/" + `${item.id}`
    );
  }

  //client -
  getAllClient(): Observable<Clients[]> {
    return this.httpClient.get<Clients[]>(this.url + "client");
  }
  ajouterClient(client: any): Observable<any> {
    return this.httpClient.post(this.url + "ajouter-client", client);
  }
  editClient(client) {
    return this.httpClient.put(this.url + "modifier-client", client);
  }
  getClientById(id): Observable<Clients> {
    return this.httpClient.get<Clients>(this.url + "clientById/" + id);
  }
  deleteCleint(client: any): Observable<any> {
    return this.httpClient.delete<any>(
      this.url + "suprimer-client/" + `${client.id}`
    );
  }

  //commande -
  getAllCommande(): Observable<Commandes[]> {
    return this.httpClient.get<Commandes[]>(this.url + "commandes");
  }
  ajouterCommande(commande: any): Observable<any> {
    return this.httpClient.post(this.url + "ajouter-commande", commande);
  }
  editCommande(commande) {
    return this.httpClient.put(this.url + "modifier-commande", commande);
  }
  getCommandeById(id): Observable<Commandes> {
    return this.httpClient.get<Commandes>(this.url + "clientById/" + id);
  }
  deleteCommande(commande: any): Observable<any> {
    return this.httpClient.delete<any>(
      this.url + "suprimer-commande/" + `${commande.id}`
    );
  }
}
