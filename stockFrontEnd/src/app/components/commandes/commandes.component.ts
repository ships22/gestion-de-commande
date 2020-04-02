import { Component, OnInit } from "@angular/core";
import { Commandes } from "../../models/commandes";
import { AllService } from "../../services/all.service";

@Component({
  selector: "app-commandes",
  templateUrl: "./commandes.component.html",
  styleUrls: ["./commandes.component.css"]
})
export class CommandesComponent implements OnInit {
  commandes: Commandes[];

  constructor(private httpService: AllService) {}

  ngOnInit() {
    this.getAllCommande();
  }

  getAllCommande() {
    this.httpService.getAllCommande().subscribe(res => {
      this.commandes = res;
    });
  }
}
