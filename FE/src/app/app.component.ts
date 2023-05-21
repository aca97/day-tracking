import { Component } from '@angular/core';
import { AppService } from './app.service';
import { MatDialog } from '@angular/material/dialog';
import { DialogComponent } from './dialog/dialog.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'FE';
  weekNumber!: number;
  weekData: any[] = [];
  selectedOption: any;
  selectedWeekDaysData: any[] = [];
  activities: any[] = [];

  constructor(private appService: AppService, private dialog: MatDialog) {}

  ngOnInit() {
    this.getWeeks();
  }

  openDialog(id: number) {
    this.dialog
      .open(DialogComponent, {
        width: '38%',
        data: id,
      })
      .afterClosed()
      .subscribe(() => {
        this.getActivitiesForTheDay(id);
        location.reload();
      });
  }

  getActivitiesForTheDay(id: number) {
    this.appService.getActivitiesForTheDay(id).subscribe({
      next: (res) => {
        this.selectedWeekDaysData = res.days;
      },
    });
  }

  createNewWeek() {
    this.appService.createWeek(this.weekData.length + 1).subscribe({
      next: () => {
        location.reload();
      },
      error: () => {},
      complete: () => {},
    });
  }

  onOptionChange() {
    this.getWeekByNumber(this.selectedOption.number);
  }

  getWeekByNumber(weekNumber: number) {
    this.appService.getWeek(weekNumber).subscribe({
      next: (res) => {
        this.selectedWeekDaysData = res.days;
      },
    });
  }

  getWeeks() {
    this.appService.getWeeks().subscribe({
      next: (res) => {
        this.weekData = res;
        this.selectedOption = this.weekData[this.weekData.length - 1];
        this.getWeekByNumber(this.selectedOption.number);
      },
    });
  }
}
