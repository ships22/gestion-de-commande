export class Clients {
  id: number;
  nom: string;
  email: string;

  constructor(id: number, nom: string, email: string) {
    this.id = id;
    this.nom = nom;
    this.email = email;
  }
}
