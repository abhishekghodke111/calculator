import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Numbers } from './numbers';
import { CalcusService } from './calcus.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  numbers = new Numbers();
  nums: any;
  nu: any;
  msg = '';
  check = true;
  s = '';
  si = '';
  n: any;
  r = 0;
  resp2: any;

  constructor(private service: CalcusService, private router: Router) {}

  ngOnInit() {
    let resp = this.service.history();
    resp.subscribe((data) => (this.nu = data));
  }

  public getString(v: string) {
    console.log(v);
    if (this.check) {
      this.s = v;
      this.check = false;
    } else {
      this.s === '0' ? (this.s = v) : (this.s += v);
    }
  }
  public getSign(s: string) {
    this.si = s;
  }

  public CC() {
    this.s = '';
    this.n = null;
  }

  public CE() {
    this.s.slice(this.s.length - 1);
  }

  public back() {
    this.s = this.s.slice(0, -1);
  }

  Calculations(value: any) {
    this.numbers.inserted = this.s;
    this.numbers.sign = this.si;
    this.service.add(this.numbers).subscribe(
      (data) => {
        this.s = '';
        this.n = data.result;
        this.nu = data;
        console.log('response received');
        this.router.navigate(['/AppComponent']);
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Enter valid numbers!';
      }
    );
  }

  rrr(value: any) {
    this.service.drop(this.numbers).subscribe(
      (data) => {
        console.log('response received');
        this.router.navigate(['/AppComponent']);
      },
      (error) => {
        console.log('exception occured');
        this.msg = 'Invalid numbers';
      }
    );
  }
}
