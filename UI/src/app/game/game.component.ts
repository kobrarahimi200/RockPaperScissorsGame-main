import { Component, OnInit } from '@angular/core';
import { Symbols } from '../symbols';
import { UserScoresService } from '../user-scores.service';
import { Winner } from '../Winner';

@Component({
  selector: 'app-game',
  templateUrl: './game.component.html',
  styleUrls: ['./game.component.css']
})
export class GameComponent implements OnInit {

  winnerName: String = '';
  botChoice: string[] = Object.keys(Symbols);

  title = 'anularscissorsproject';
  humanChoice: any;
  computer: boolean = false;
  person: boolean = false;
  message: String = "";
  winner: any;

  constructor(private service: UserScoresService) { }

  ngOnInit() {
    this.winner = new Winner("", "", 0, 0);
    this.humanChoice = "";
  }

  /**
   *
   * @param id called when player choose his weapon and the id of the selected weapon sent to the
   * backend.
   */
  async playNow(choiceName: String) {
    this.computer = true;
    this.person = true;
    this.getHumanChoice(choiceName);
    let resp = this.service.doPlay(choiceName); //passed to restAPI
    resp.subscribe((data) => (this.winner = data));
    console.log("botchoise is " + this.winner.botChoice);
  }

  getHumanChoice(choiceName: String) {
    // if (id == 2) {
    //   this.humanChoice = "scissors";
    // } else if (id == 1) {
    //   this.humanChoice = "paper";
    // } else {
    //   this.humanChoice = "rock";
    // }
    this.humanChoice = choiceName;
  }
  
  reset(): void {
    console.log("reset");
    this.winner.humanWins=0;
    this.winner.botWins =0;
    this.service.reset();
  }
}
