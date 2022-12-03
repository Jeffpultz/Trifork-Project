import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { DbService } from './services/db.service';
import { Validators, FormGroup, FormControl } from '@angular/forms';
import { EMPTY, Observable } from 'rxjs';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'triforkAngular';
  persons: Observable<any> = EMPTY
  foundPerson: any = null
  whenEdit: boolean = false;
  doIEdit: boolean = false;


  personForm = new FormGroup({
    cpr: new FormControl('', [
      Validators.required,
      Validators.minLength(10),
      Validators.maxLength(10)
    ]),
    name: new FormControl('', [
      Validators.required
    ]),
    blood_type: new FormControl('', [

    ]),
    age: new FormControl('',[

    ])
  });

  findPersonForm = new FormGroup({
    searchTerm: new FormControl('',[
      Validators.required,
      Validators.minLength(11),
      Validators.maxLength(11)
    ])
  });

  formError: string = '';

  constructor(private services: DbService){
    this.persons = services.getPersons()
    
  }
  ngOnInit(): void {
  }

  deletePerson(cpr: String) {
    this.services.deletePerson(cpr)
  }

  editPerson(person: any){
    this.doIEdit = !this.doIEdit;
    if(this.doIEdit){
      this.personForm.setValue(person);
      this.personForm.controls.cpr.disable();
    } else {
      this.personForm.controls.cpr.enable();
      this.personForm.reset();
    }
  }

  addPerson(){
    if(!this.personForm.value.cpr && !this.personForm.value.name && !this.personForm.value.blood_type && !this.personForm.value.age) {
      //Add a formError saying need to fill it all out
      return;
      
    }

    let postData = this.personForm.getRawValue();

    console.log(postData)
    if(this.doIEdit){
      this.services.updatePerson(postData)
      this.doIEdit = false;
    } else {
      this.services.addPerson(postData)

    }
  }

  getCPR(cpr: String){
    let firstPart = cpr.slice(0,6)
    let secondPart = cpr.slice(6)
    let finishedCPR = firstPart +"-"+ secondPart
    return finishedCPR;
  }


  findPerson(){
    if(!this.findPersonForm.value.searchTerm){
      //Add a formError saying you need to fill it here.
      return;
    }

    if(this.findPersonForm.value.searchTerm.length != 11)
    {
      //Add a formError saying you the cpr needs to be atleast 10 numbers and with -
      return;
    }

    let searchInput = this.findPersonForm.value.searchTerm
    let firstCPRPart = searchInput.slice(0,6)
    let secondPart = searchInput.slice(7)
    let cprMerge = firstCPRPart+secondPart
    console.log(cprMerge)
    
    this.services.getPerson(cprMerge).subscribe(p => {
        this.foundPerson = p[0];
        console.log(this.foundPerson)
      });

  }


}

