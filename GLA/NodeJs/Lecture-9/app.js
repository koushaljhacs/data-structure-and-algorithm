let express = require('express');
let ejs = require('ejs');

let app = express();
app.set("view engine", "ejs");
app.set(path.join(__dirname, views));
app.listen(() => {
    console.log("app is running at port 3000");
})
app.get('/', (req, res) => {
    res.send("this")
})