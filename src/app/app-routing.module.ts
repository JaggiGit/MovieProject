import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { MovieSearchComponent } from './movie-search/movie-search.component';

const routes: Routes = [{path:'',component:HomeComponent,pathMatch:'full'},
{path:'login',component:LoginComponent,pathMatch:'full'},
{path:'search',component:MovieSearchComponent,pathMatch:'full'},
{path:'register',component:RegisterComponent,pathMatch:'full'}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
