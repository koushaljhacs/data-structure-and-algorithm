const express = require('express');
const app = express();

__dirname
app.get('/', (req, res) => {
    res.send("this is / routes");
});

app.get("/login", (req, res) => {
    res.send("this is / login route");
});

app.get("/register", (req, res) => {
    res.send("this is / register route");
});


app.get('/signup',(req, res) => {
    res.render("index");
})

// THIS REPLACES THE WILDCARD ROUTE TO AVOID THE PATH-TO-REGEXP ERROR
app.use((req, res) => {
    res.send("something went wrong !! invalid url");
});



app.listen(8000, () => {
    console.log("app is running at port 8000");
});