import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs-compat/Observable';
import { Numbers } from './numbers';

@Injectable({
  providedIn: 'root',
})
export class CalcusService {
  private url: string = '';
  private status: string = '';
  constructor(private http: HttpClient) {
    this.url = 'http://localhost:81/userapi';
  }

  public add(numbers: Numbers): Observable<any> {
    return this.http.post('http://localhost:81/userapi/add', numbers);
  }

  public sub(numbers: Numbers): Observable<any> {
    return this.http.post('http://localhost:81/userapi/sub', numbers);
  }

  public test(numbers: Numbers): Observable<any> {
    return this.http.post('http://localhost:81/userapi/test', numbers);
  }

  public drop(numbers: Numbers): Observable<any> {
    return this.http.post('http://localhost:81/userapi/drop', numbers);
  }

  public history(): Observable<Numbers[]> {
    return this.http.get<Numbers[]>(this.url + '/history');
  }
}
