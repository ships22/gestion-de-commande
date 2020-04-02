import { Component, OnInit } from "@angular/core";
import { Router, ActivatedRoute } from "@angular/router";
import { AllService } from "../../../services/all.service";
import { Produits } from "../../../models/produits";

@Component({
  selector: "app-edit-produits",
  templateUrl: "./edit-produits.component.html",
  styleUrls: ["./edit-produits.component.css"]
})
export class EditProduitsComponent implements OnInit {
  private id: number;
  private produit: Produits;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private httpClientService: AllService
  ) {}

  ngOnInit() {
    this.activatedRoute.paramMap.subscribe(parametarMap => {
      this.id = +parametarMap.get("id");
    });
    this.getSelectedProduit(this.id);
  }

  getSelectedProduit(id) {
    this.httpClientService.getProduitById(id).subscribe(res => {
      this.produit = res;
    });
  }
  modifierProduit(item) {
    this.httpClientService.editProduit(item).subscribe(res => {
      this.router.navigate(["/produits"]);
    });
  }
}
