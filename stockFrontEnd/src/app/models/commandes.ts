import { Clients } from "./clients";
import { Produits } from "./produits";
export class Commandes {
  id: number;
  prixTotal: number;
  client: Clients;
  produits: Produits[];

  constructor(
    id: number,
    prixTotal: number,
    client: Clients,
    produits: Produits[]
  ) {
    this.id = id;
    this.prixTotal = prixTotal;
    this.client = client;
    this.produits = this.produits;
  }
}
