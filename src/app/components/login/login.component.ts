import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 
  credentials={ username:'', password:''} ;

      

  constructor(private loginService:LoginService) { }

  ngOnInit(): void {
  }

  onsubmit(){
    console.log("form submitted") ;
    if((this.credentials.username!='' && this.credentials.password!='') && (this.credentials.username!=null &&this.credentials.password!=null))
    {
      console.log("Login user on server") ;
      this.loginService.generateToken(this.credentials).subscribe(
        (response:any)=>{
          console.log(response.token) ;
          this.loginService.loginUser(response.token) ;
          window.location.href=("/search") ;
        },
        error=>{
          console.log(error) ;
        }
      )
    }
        
  }

}
