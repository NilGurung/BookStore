import { Injectable } from '@angular/core';
import any = jasmine.any;

@Injectable({
  providedIn: 'root'
})
export class UploadImageService {

  constructor() {
    this.filesToUpload = [];
  }

  filesToUpload: Array<File>;


  uploadImage(bookId: number) {
    this.makeFileRequest("http://localhost:8181/book/add/imag?id="+ bookId, [], this.filesToUpload).then(
      console.log(result);
    ),
    (error) => {
      console.log(error);
    });

  }


  fileChangeEvent(fileInput: any) {
    this.filesToUpload = <Array<File>> fileInput.target.files;
  }

  makeFileRequest(url:string, params: Array<string>, files: Array<File>) {
    return new Promise((resolve, reject) => {
      var formData:any = new FormData();
      var xhr = new XMLHttpRequest();
      for(var i=0; i<files.length;i++) {
        formData.append("uploads[]", files[i], files[i].name);
      }
      xhr.onreadystatechange = function() {
        if(xhr.readyState == 4) {
          if(xhr.status == 2) {
            console.log("Image Uploaded Successfully");
          } else {
            reject(xhr.response);
          }
        }
      }
      xhr.open("POST", url, true);
      xhr.sendRequestHeader("x-auth-token", localStorage.getItem("xAuthToken"));
      xhr.send(formData);
    });
  }



}
