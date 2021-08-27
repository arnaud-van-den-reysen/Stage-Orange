import { Component, Injectable, OnInit } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';

import { JSON_PLACEHOLDER } from './json_placeholder';
import { Hello_world } from './hello_world';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

@Injectable()
export class AppComponent implements OnInit {
  title = 'testfront';
  API_SERVER = 'http://localhost:9090/api';
  API_JSON_PLACEHOLDER = 'https://jsonplaceholder.typicode.com/posts';

  hello: Hello_world;

  constructor(private httpClient: HttpClient) {
    this.hello = {'title':''};
  }

  ngOnInit() {

    this.get_post_1().subscribe((data: JSON_PLACEHOLDER) => {
      console.log("JSON PLACEHOLDER => " + data.id);
      console.log(data.userId);
      console.log(data.title);
      console.log(data.body);
    });

    this.get_hello_world().subscribe((data: Hello_world) => {
      console.log("hello world = "+data.title);
      this.hello = {'title':data.title};
    });
  }

  get_post_1() {
    return this.httpClient.get<JSON_PLACEHOLDER>(this.API_JSON_PLACEHOLDER + "/1");
  }

  get_hello_world() {
    return this.httpClient.get<Hello_world>(this.API_SERVER + '/myresource');
  }
}
