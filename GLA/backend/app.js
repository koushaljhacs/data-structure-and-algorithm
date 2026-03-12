let express = require('express');
let app = express();
let path = require('path');

app.set('view engine', 'ejs');
app.set('views',path.join(__dirname, 'views'));

let products = ["phone", "watch", "earbuds"];

app.get('/product', (req, res) => {
    res.render("show", {products})
})
app.listen(4000, () => {
    console.log("server is running at port 4000: localhost:4000");
});