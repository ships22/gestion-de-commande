import { Component, OnInit } from "@angular/core";
import { Produits } from "../../models/produits";
import { AllService } from "src/app/services/all.service";

@Component({
  selector: "app-produits",
  templateUrl: "./produits.component.html",
  styleUrls: ["./produits.component.css"]
})
export class ProduitsComponent implements OnInit {
  produitsList: Produits[];
  constructor(private httService: AllService) {}

  ngOnInit() {
    this.getAllProduit();
  }

  getAllProduit() {
    this.httService.getAllProduits().subscribe(res => {
      this.produitsList = res;
    });
  }
  submit(form) {
    this.httService
      .ajouterProduit(form.value)
      .subscribe(res => this.produitsList.push(res));
    console.log("test submit :", form.value);
  }
}
