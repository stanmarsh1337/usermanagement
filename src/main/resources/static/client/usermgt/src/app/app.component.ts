import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Users, User, Response} from './User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'usermgt';
  users:User[] = [];
  usersUrl = 'user';

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.getUsers().subscribe(result => this.users = result._embedded.user);
  }

  getUsers(){
    return this.http.get<Response>(this.usersUrl);
  }
}
