// --------- Variable set-up -----------
var gameOver = false;
var NCBtn = document.querySelector("a");
var header = document.querySelector("#header");
var blocks = document.querySelectorAll(".block");
var h1 = document.querySelector("h1");
var easyBtn = document.querySelector("#easyBtn");
var harBtn = document.getElementById("hardBtn");
var length = 6;
var comment = document.querySelector("span");


var rightColor = randomColor();
var rightBlock = blocks[getRandomInt(0,5)];

// ======== Setting up the right block =========
modeMaker(length);


// ========== Events ===========

// Adding events to every block
for (var i = 0; i < blocks.length; i++) {
 	blocks[i].addEventListener("click", function() {
 		// Runs only if game is not over
 		if (!gameOver) {
 			// If incorrect block
 			if (!this.classList.contains("rightBlock")) {
 				// Remove the block
 				this.classList.remove("block");
 				comment.textContent = "Try Again";
 			} else {
 				// Remove rightBlock class from block
 				this.classList.remove("rightBlock");
 				// change header BG to right color
 				header.style.backgroundColor = rightColor;
				for (var i = length - 1; i >= 0; i--) {
					// Make all blocks appear again
					blocks[i].classList.add("block");
					// Change their color to the correct color
					blocks[i].style.backgroundColor = rightColor;
				}
				comment.textContent = "Correct!";
				gameOver = true;
 			}
 		}
 	});
}

// New Color button click event
NCBtn.addEventListener("click", function() {
	modeMaker(length);
});

// Easy Button click event
easyBtn.addEventListener("click", function() {
	easyBtn.classList.add("selected");
	hardBtn.classList.remove("selected")
	length = 3;
	for (var i = 0; i < blocks.length; i++) {
		if (!blocks[i].classList.contains("easy")){
			blocks[i].classList.remove("block");
		}
	}
	modeMaker(3);
});

// Hard Button click event
hardBtn.addEventListener("click", function() {
	hardBtn.classList.add("selected");
	easyBtn.classList.remove("selected")
	length = 6;
	modeMaker(length);
});


// ============ Helper Functions ==============

function modeMaker(length) {
	rightBlock.classList.remove("rightBlock");
	header.style.backgroundColor = "rgb(40, 85, 160)";
	comment.textContent = ""

	for (var i = length-1; i >= 0; i--) {
		// Make all blocks appear again
		blocks[i].classList.add("block");
		blocks[i].style.backgroundColor = randomColor();
	}
	rightColor = "rgb(" + getRandomInt(0,255) + "," + getRandomInt(0,255) + "," + getRandomInt(0,255) + ")";
	rightBlock = document.querySelectorAll(".block")[getRandomInt(0,length-1)];
	// Add class rightBlock to the correct block
	rightBlock.classList.add("rightBlock");
	rightBlock.style.backgroundColor = rightColor;
	h1.textContent = rightColor;
	gameOver = false;
}

function randomColor() {
	return "rgb(" + getRandomInt(0,244) + "," + getRandomInt(0,244) + "," + getRandomInt(0,244) + ")";
}

function getRandomInt(min, max) {
  min = Math.ceil(min);
  max = Math.floor(max);
  return Math.floor(Math.random() * (max - min + 1)) + min;
}