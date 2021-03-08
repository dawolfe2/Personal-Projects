let playerPiece;

function start() {
    GameSpace.start();
    playerPiece = new block(50, 50, 210, 440, "purple");
    yellowPiece = new block(40, 40, 100, 50, "yellow");
    greenPiece = new block(50, 50, 400, 50, "green");
    bluePiece = new block(60, 60, 300, 300, "blue");
}

let GameSpace = {
    canvas : document.createElement("canvas"),
    start : function() {
        this.canvas.width = 500;
        this.canvas.height = 500;
        this.context = this.canvas.getContext("2d");
        document.body.insertBefore(this.canvas, document.body.childNodes[0]);
        this.interval = setInterval(movement, 15);
    },
    clear : function(){
        this.context.clearRect(0,0,this.canvas.width, this.canvas.height);
    }
}

function block(width, height, xcoord, ycoord, color) {
    this.width = width;
    this.height = height;
    this.xcoord = xcoord;
    this.ycoord = ycoord;

    this.move = function(){     
        ctx = GameSpace.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.xcoord, this.ycoord, this.width, this.height);
    }
}

function movement(){
    GameSpace.clear();

    playerPiece.xcoord = playerPiece.xcoord + 1;
    yellowPiece.xcoord = yellowPiece.xcoord + 1;
    greenPiece.ycoord = greenPiece.ycoord + 1;
    bluePiece.ycoord = bluePiece.ycoord - 1;

    playerPiece.move();
    yellowPiece.move();
    greenPiece.move();
    bluePiece.move();
}
