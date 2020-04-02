import { Component, OnInit } from "@angular/core";
import { Clients } from "../../models/clients";
import { AllService } from "../../services/all.service";
import { Produits } from "../../models/produits";
import { Commandes } from "src/app/models/commandes";

@Component({
  selector: "app-clients",
  templateUrl: "./clients.component.html",
  styleUrls: ["./clients.component.css"]
})
export class ClientsComponent implements OnInit {
  clients: Clients[];
  produits: Produits[];
  commande = {} as Commandes;
  cart: any = [];
  t: number = 0;

  constructor(private httpService: AllService) {}

  ngOnInit() {
    // this.getAllClient();
    this.getAllProduit();
  }
  getAllProduit() {
    this.httpService.getAllProduits().subscribe(res => {
      this.produits = res;
    });
  }
  addToCart(item) {
    let exist = this.cart.find(data => data.id == item.id);
    if (!exist) {
      item.qty = 1;
      item.added = true;
      this.cart.push(item);
    } else {
      exist.qty++;
    }
    this.getTotal();
  }
  addItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].qty++;
    this.getTotal();
  }
  removeItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].qty--;
    if (this.cart[itemIndex].qty == 0) {
      this.cart[itemIndex].added = false;
      this.cart.splice(itemIndex, 1);
    }
    this.getTotal();
  }
  cancelItem(id) {
    let itemIndex = this.cart.findIndex(element => element.id === id);
    this.cart[itemIndex].added = false;
    this.cart.splice(itemIndex, 1);
    this.getTotal();
  }

  getTotal() {
    this.t = 0;
    for (let i = 0; i < this.cart.length; i++) {
      let q = this.cart[i].qty;
      let p = this.cart[i].prix;
      this.t += q * p;
    }
  }

  valider() {
    console.log("valider clicked...");
    // this.route.navigate(["/confirmation"]);
    this.cart = [];
    localStorage.clear();
  }
  validateOrder(clientDetails) {
    console.log("client added : ", clientDetails);
    this.httpService.ajouterClient(clientDetails).subscribe(res => {
      this.commande.client = res;
      this.commande.prixTotal = this.t;
      this.commande.produits = this.cart;
      this.httpService.ajouterCommande(this.commande).subscribe(res => {
        console.log("test commande : ", res);
      });
    });
    // this.commande.prixTotal = this.t;
    // this.commande.produits = this.cart;

    // this.commande.client = clientDetails;
    // console.log("test commande : ", this.commande);
  }
}
