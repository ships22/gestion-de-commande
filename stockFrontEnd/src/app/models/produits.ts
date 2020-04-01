export class Produits {
  private id: number;
  private nom: string;
  private prix: number;
  private quantite: number;

  constructor(id: number, nom: string, prix: number, quantite: number) {
    this.id = id;
    this.nom = nom;
    this.prix = prix;
    this.quantite = quantite;
  }
}
