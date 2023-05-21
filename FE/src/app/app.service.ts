import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class AppService {
  baseUrl!: string;

  constructor(private http: HttpClient) {
    this.baseUrl = 'http://localhost:8080/api/v1';
  }

  getWeeks(): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/weeks`);
  }

  createWeek(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/weeks`, body);
  }

  getWeek(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/weeks/${id}`);
  }

  createActivity(body: any): Observable<any> {
    return this.http.post<any>(`${this.baseUrl}/activity`, body);
  }

  getActivitiesForTheDay(id: number): Observable<any> {
    return this.http.get<any>(`${this.baseUrl}/weeks/${id}`);
  }
}
