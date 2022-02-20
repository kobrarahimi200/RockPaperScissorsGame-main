
export class PlayerChoose{
    
    constructor(
        private choose: number,
    ){}
    public setChoose(val :any){
        this.choose = val;
    }
    public getChoose(){
        return this.choose;
    }
}