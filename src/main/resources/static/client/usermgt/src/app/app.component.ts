import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { User, Response} from './User';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'usermgt';
  users:User[] = [];
  usersUrl = 'user';
  editMode = false;
  userEdit;

  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.refresh();
  }

  refresh(){
    this.getUsers().subscribe(result => this.users = result._embedded.user);
  }

  getUsers(){
    return this.http.get<Response>(this.usersUrl);
  }

}
