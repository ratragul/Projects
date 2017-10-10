var input = $("input");
var delbtn = $(".delete")
var item = $("li");

// Code for adding a new todo (when a user presses 'enter' key)
input.keypress(function(event) {
	if (event.which === 13 && input.val()!= "") {
		var text = input.val();
		$("ul").append("<li><span><i class=\"fa fa-trash\"></i></span> " + text + "</li>");
		input.val("");
	}
});

$(".fa-plus-square").click(200, function() {
	input.fadeToggle();
});

// For deleting an item
$("ul").on("click", "span", function(event) {
	$(this).parent().fadeOut(300, function() {
		this.remove();
	});
	event.stopPropagation();
});

// Check off todos by clicking
$("ul").on("click", "li", function() {
	$(this).toggleClass("completed");
});