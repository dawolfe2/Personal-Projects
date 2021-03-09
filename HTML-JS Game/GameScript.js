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
        window.addEventListener('keydown', function (e) {
            GameSpace.keys = (GameSpace.keys || []);
            GameSpace.keys[e.keyCode] = true;
          })
          window.addEventListener('keyup', function (e) {
            GameSpace.keys[e.keyCode] = false;
          })
    },
    clear : function(){
        this.context.clearRect(0,0,this.canvas.width, this.canvas.height);
    }
}

function block(width, height, xcoord, ycoord, color) {
    this.GameSpace = GameSpace;
    this.width = width;
    this.height = height;
    this.xcoord = xcoord;
    this.ycoord = ycoord;
    this.movex = 0;
    this.movey = 0;

    this.move = function(){     
        ctx = GameSpace.context;
        ctx.fillStyle = color;
        ctx.fillRect(this.xcoord, this.ycoord, this.width, this.height);
    }
    this.playerMove = function(){
        this.xcoord += this.movex;
        this.ycoord += this.movey;
    }
}

function movement(){
    GameSpace.clear();

    yellowPiece.xcoord = yellowPiece.xcoord + 1;
    greenPiece.ycoord = greenPiece.ycoord + 1;
    bluePiece.ycoord = bluePiece.ycoord - 1;

    playerPiece.movex = 0;
    playerPiece.movey = 0;
    
    if (GameSpace.keys && GameSpace.keys[37]){
        playerPiece.movex = -1; 
    }
    if (GameSpace.keys && GameSpace.keys[39]) {
        playerPiece.movex = 1; 
    }
    if (GameSpace.keys && GameSpace.keys[38]) {
        playerPiece.movey = -1; 
    }
    if (GameSpace.keys && GameSpace.keys[40]) {
        playerPiece.movey = 1; 
    }

    playerPiece.playerMove();
    playerPiece.move();
    
    yellowPiece.move();
    greenPiece.move();
    bluePiece.move();
}

function ButtonUp(){
    playerPiece.movey -= 1
}

function ButtonLeft(){
    playerPiece.movex -= 1
}

function ButtonRight(){
    playerPiece.movex += 1
}

function ButtonDown(){
    playerPiece.movey += 1
}

function Stop(){
    playerPiece.movex = 0;
    playerPiece.movey = 0;
}
