import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { GooglemapsComponent } from "./googlemaps/googlemaps.component";
import { LeafletComponent } from "./leaflet/leaflet.component";
import { OpenstreetComponent } from "./openstreet/openstreet.component";

const routes: Routes = [
  {
    path: "",
    component: GooglemapsComponent,
  },
  {
    path: "openstreet",
    component: OpenstreetComponent,
  },
  {
    path: "leaflet",
    component: LeafletComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
