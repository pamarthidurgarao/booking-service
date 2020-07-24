import { Component, OnInit } from "@angular/core";
import {
  circle,
  Circle,
  icon,
  latLng,
  LatLng,
  Layer,
  Map,
  marker,
  tileLayer,
} from "leaflet";
import { LocationsService } from "../services/locations.service";

@Component({
  selector: "app-leaflet",
  templateUrl: "./leaflet.component.html",
  styleUrls: ["./leaflet.component.scss"],
})
export class LeafletComponent implements OnInit {
  lat: number = 16.8248092;
  lng: number = 80.8308575;
  distance: number = 1000;
  markers: Layer[] = [];
  map: Map;
  cir: Circle;
  // Define our base layers so we can reference them multiple times
  streetMaps = tileLayer("https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png", {
    detectRetina: true,
    attribution:
      '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
  });
  wMaps = tileLayer("http://maps.wikimedia.org/osm-intl/{z}/{x}/{y}.png", {
    detectRetina: true,
    attribution:
      '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
  });

  cycle = tileLayer("http://tile.thunderforest.com/cycle/${z}/${x}/${y}.png", {
    detectRetina: true,
    attribution:
      '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
  });

  // Layers control object with our two base layers and the three overlay layers
  layersControl = {
    baseLayers: {
      "Street Maps": this.streetMaps,
      "Wikimedia Maps": this.wMaps,
      "Cycle Maps": this.cycle,
    },
    overlays: {},
  };

  // Set the initial set of displayed layers (we could also use the leafletLayers input binding for this)
  options = {
    layers: [this.streetMaps],
    zoom: 13,
    center: latLng([this.lat, this.lng]),
  };
  onMapReady(map: Map) {
    this.map = map;
  }
  constructor(private locationService: LocationsService) {}

  ngOnInit(): void {
    navigator.geolocation.getCurrentPosition((position) => {
      this.lat = position.coords.latitude;
      this.lng = position.coords.longitude;
      this.cir = circle([this.lat, this.lng], {
        radius: this.distance,
        color: "red",
        fillColor: "#f03",
        fillOpacity: 0.5,
      });
      this.map.panTo(new LatLng(this.lat, this.lng));
      this.getLocations();
      this.markers.push(this.cir);
    });
  }

  getLocations() {
    let dis = this.distance / 1000 / 111;
    this.locationService
      .getLocations(this.lat, this.lng, dis)
      .subscribe((resp: any) => {
        resp.forEach((element) => {
          let marcker: any = marker([element.position.x, element.position.y], {
            icon: icon({
              iconSize: [25, 41],
              iconAnchor: [13, 41],
              iconUrl: "leaflet/marker-icon.png",
              iconRetinaUrl: "leaflet/marker-icon-2x.png",
              shadowUrl: "leaflet/marker-shadow.png",
            }),
          });
          marcker.bindPopup(
            `<strong>Hello world!</strong>
            <div class="row">
              <div class="col-sm">
                Distance
              </div>
              <div class="col-sm">
                400M
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                Tables
              </div>
              <div class="col-sm">
                4
              </div>
            </div>
            <div class="row">
              <div class="col-sm">
                <button type="button" class="btn btn-primary btn-sm">Book Now</button>
              </div>
            </div>
          
          `,
            { maxWidth: 500 }
          );
          this.markers.push(marcker);
        });
      });
  }

  onchange() {
    this.markers = [];
    this.markers.push(this.cir);
    this.cir.setRadius(this.distance);
    this.getLocations();
  }
}
