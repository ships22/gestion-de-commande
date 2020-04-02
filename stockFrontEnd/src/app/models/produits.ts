export class Produits {
  id: number;
  nom: string;
  prix: number;
  quantite: number;

  constructor(id: number, nom: string, prix: number, quantite: number) {
    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.quantite = quantite;
  }
}
