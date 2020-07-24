import { AgmCoreModule } from "@agm/core";
import { HttpClientModule } from "@angular/common/http";
import { NgModule } from "@angular/core";
import { FormsModule } from "@angular/forms";
import { BrowserModule } from "@angular/platform-browser";
import { LeafletMarkerClusterModule } from "@asymmetrik//ngx-leaflet-markercluster";
import { LeafletModule } from "@asymmetrik/ngx-leaflet";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { GooglemapsComponent } from "./googlemaps/googlemaps.component";
import { LeafletComponent } from "./leaflet/leaflet.component";
import { OpenstreetComponent } from "./openstreet/openstreet.component";

@NgModule({
  declarations: [
    AppComponent,
    OpenstreetComponent,
    GooglemapsComponent,
    LeafletComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    LeafletModule,
    LeafletMarkerClusterModule,
    AgmCoreModule.forRoot({
      apiKey: "",
    }),
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}

// "target": "https://freetable.herokuapp.com",
