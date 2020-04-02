import { Component, OnInit } from "@angular/core";
import { Produits } from "../../models/produits";
import { AllService } from "src/app/services/all.service";
import { Router } from "@angular/router";

@Component({
  selector: "app-produits",
  templateUrl: "./produits.component.html",
  styleUrls: ["./produits.component.css"]
})
export class ProduitsComponent implements OnInit {
  produitsList: Produits[];
  constructor(private httpService: AllService, private router: Router) {}

  ngOnInit() {
    this.getAllProduit();
  }
  getAllProduit() {
    this.httpService.getAllProduits().subscribe(res => {
      this.produitsList = res;
    });
  }
  addProduit(item) {
    this.httpService
      .ajouterProduit(item.value)
      .subscribe(res => this.produitsList.push(res));
  }
  editProduit(id) {
    this.router.navigate(["/edit-produit", id]);
  }
  delete(item) {
    this.httpService
      .deleteItem(item)
      .subscribe(
        res =>
          (this.produitsList = this.produitsList.filter(data => data.id != res))
      );
  }
}
