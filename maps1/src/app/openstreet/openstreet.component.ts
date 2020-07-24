import { Component, OnInit } from "@angular/core";
import Draw from "ol/interaction/Draw";
import { Vector } from "ol/layer";
import TileLayer from "ol/layer/Tile";
import Map from "ol/Map";
import { Vector as VectorSource } from "ol/source";
import OSM from "ol/source/OSM";
import View from "ol/View";

@Component({
  selector: "app-openstreet",
  templateUrl: "./openstreet.component.html",
  styleUrls: ["./openstreet.component.scss"],
})
export class OpenstreetComponent implements OnInit {
  map: any;

  ngOnInit() {
    var raster = new TileLayer({
      source: new OSM(),
    });

    var source = new VectorSource({ wrapX: false });

    var vector = new Vector({
      source: source,
    });

    this.map = new Map({
      target: "hotel_map",
      layers: [raster, vector],
      view: new View({
        center: [80.8528, 16.8179],
        zoom: 7,
      }),
    });

    let draw = new Draw({
      source: source,
      type: "Circle",
    });
    this.map.addInteraction(draw);
  }
}
