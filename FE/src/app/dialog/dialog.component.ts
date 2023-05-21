import { Component, Inject } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { AppService } from '../app.service';

@Component({
  selector: 'app-dialog',
  templateUrl: './dialog.component.html',
  styleUrls: ['./dialog.component.scss'],
})
export class DialogComponent {
  activityForm!: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private appService: AppService,
    private dialogRef: MatDialogRef<DialogComponent>,
    @Inject(MAT_DIALOG_DATA) public dayId: any
  ) {}

  ngOnInit() {
    this.initializeForm();
  }

  initializeForm() {
    this.activityForm = this.formBuilder.group({
      description: ['', Validators.required],
      day: this.formBuilder.group({
        id: [this.dayId],
      }),
    });
  }

  createActivity() {
    this.appService.createActivity(this.activityForm.value).subscribe({
      next: () => {
        this.dialogRef.close()
      }
    })
  }
}
