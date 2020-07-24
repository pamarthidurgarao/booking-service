import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: "root",
})
export class LocationsService {
  constructor(private http: HttpClient) {}

  getLocations(lat, lang, distance) {
    return this.http.get(
      "/api/v1/table/search?lat=" +
        lat +
        "&lang=" +
        lang +
        "&distance=" +
        distance
    );
  }

  addLocations(data: any) {
    return this.http.post("/api/v1/table", data);
  }
}
