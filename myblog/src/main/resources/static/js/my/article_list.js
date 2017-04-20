/**
 * Created by root on 17-4-20.
 */

var text = document.getElementsByClassName('article-text');
for (var i = 0; i < text.length; i++) {
    var string = text[i].innerHTML.trim();
    if (string.length > 270) {
        string = string.slice(0, 269);
        console.log(string);
        text[i].innerHTML = string + " . . .";
    }
}