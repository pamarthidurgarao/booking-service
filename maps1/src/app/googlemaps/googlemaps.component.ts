import { MouseEvent } from "@agm/core";
import { Component, OnInit } from "@angular/core";
import { LocationsService } from "../services/locations.service";

@Component({
  selector: "app-googlemaps",
  templateUrl: "./googlemaps.component.html",
  styleUrls: ["./googlemaps.component.scss"],
})
export class GooglemapsComponent implements OnInit {
  // google maps zoom level
  zoom: number = 2;

  // initial center position for the map
  lat: number = 16.8248092;
  lng: number = 80.8308575;
  distance: number = 5000;
  skipAdd = true;
  styles = [
    {
      featureType: "all",
      elementType: "geometry.fill",
      stylers: [
        {
          weight: "2.00",
        },
      ],
    },
    {
      featureType: "all",
      elementType: "geometry.stroke",
      stylers: [
        {
          color: "#9c9c9c",
        },
      ],
    },
    {
      featureType: "all",
      elementType: "labels.text",
      stylers: [
        {
          visibility: "on",
        },
      ],
    },
    {
      featureType: "landscape",
      elementType: "all",
      stylers: [
        {
          color: "#f2f2f2",
        },
      ],
    },
    {
      featureType: "landscape",
      elementType: "geometry.fill",
      stylers: [
        {
          color: "#ffffff",
        },
      ],
    },
    {
      featureType: "landscape.man_made",
      elementType: "geometry.fill",
      stylers: [
        {
          color: "#ffffff",
        },
      ],
    },
    {
      featureType: "poi",
      elementType: "all",
      stylers: [
        {
          visibility: "off",
        },
      ],
    },
    {
      featureType: "road",
      elementType: "all",
      stylers: [
        {
          saturation: -100,
        },
        {
          lightness: 45,
        },
      ],
    },
    {
      featureType: "road",
      elementType: "geometry.fill",
      stylers: [
        {
          color: "#eeeeee",
        },
      ],
    },
    {
      featureType: "road",
      elementType: "labels.text.fill",
      stylers: [
        {
          color: "#7b7b7b",
        },
      ],
    },
    {
      featureType: "road",
      elementType: "labels.text.stroke",
      stylers: [
        {
          color: "#ffffff",
        },
      ],
    },
    {
      featureType: "road.highway",
      elementType: "all",
      stylers: [
        {
          visibility: "simplified",
        },
      ],
    },
    {
      featureType: "road.arterial",
      elementType: "labels.icon",
      stylers: [
        {
          visibility: "off",
        },
      ],
    },
    {
      featureType: "transit",
      elementType: "all",
      stylers: [
        {
          visibility: "off",
        },
      ],
    },
    {
      featureType: "water",
      elementType: "all",
      stylers: [
        {
          color: "#46bcec",
        },
        {
          visibility: "on",
        },
      ],
    },
    {
      featureType: "water",
      elementType: "geometry.fill",
      stylers: [
        {
          color: "#c8d7d4",
        },
      ],
    },
    {
      featureType: "water",
      elementType: "labels.text.fill",
      stylers: [
        {
          color: "#070707",
        },
      ],
    },
    {
      featureType: "water",
      elementType: "labels.text.stroke",
      stylers: [
        {
          color: "#ffffff",
        },
      ],
    },
  ];
  clickedMarker(label: string, index: number) {
    console.log(`clicked the marker: ${label || index}`);
  }

  ngOnInit() {
    navigator.geolocation.getCurrentPosition((position) => {
      this.lat = position.coords.latitude;
      this.lng = position.coords.longitude;
    });
  }

  constructor(private locationService: LocationsService) {
    this.getLocations();
  }

  getLocations() {
    let dis = this.distance / 1000 / 111;
    this.locationService
      .getLocations(this.lat, this.lng, dis)
      .subscribe((resp: any) => {
        this.markers = resp;
      });
  }
  mapClicked($event: MouseEvent) {
    debugger;
    if (this.skipAdd) return;
    let data: any = {};

    data.restId = Math.random().toString(36).substr(2, 5);
    data.createdAt = new Date();
    let position: any = {};
    (position.type = "Point"),
      (position.coordinates = [$event.coords.lat, $event.coords.lng]);

    data.position = position;
    data.restName = Math.random().toString(36).substr(2, 5);
    data.tableId = "1";
    data.tableFor = 2;
    data.cuisine = "";
    data.pushedBy = "";

    this.locationService.addLocations(data).subscribe((reps) => {
      this.getLocations();
    });
  }

  markerDragEnd(m: any, $event: MouseEvent) {
    console.log("dragEnd", m, $event);
  }

  markers: any[] = [];
}
