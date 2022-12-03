import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DbService {

  private baseUrl = "http://localhost:8080/api"

  constructor(private http: HttpClient) {

   }

   getPersons(): Observable<any> {
    return this.http.get(`${this.baseUrl}/persons`)
   }

   deletePerson(cpr: String) {
    this.http.delete(`${this.baseUrl}/persons/${cpr}`).subscribe()
   }

   addPerson(postData: Object){
    this.http.post(`${this.baseUrl}/persons`, postData).subscribe()
   }

   updatePerson(postData: any){
    this.http.patch(`${this.baseUrl}/persons`, postData).subscribe()
   }

   getPerson(cpr: String) {
    return this.http.get<any>(`${this.baseUrl}/persons/${cpr}`)
   }

   
}
