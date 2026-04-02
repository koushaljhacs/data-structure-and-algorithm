let express = require('express');
let mongoose = require('mongoose');
let bcrypt = require('bcrypt');
let path = require('path');
let Emp = require('./model/employee');
let app = express();
app.set('view engine', 'ejs');
app.set('views',path.join(__dirname, 'views'));



app.use(express.urlencoded({ extended: true }));
app.get('/register', (req, res) => {
    res.render('register');
});

app.post("/register", (req, res) => {
    let {username, password} = req.body;
    bcrypt.hash(password, 10, async (err, hash) => {
        let emp = new Emp({
            empName: username,
            empPass: hash
        });
        await emp.save();
        console.log("employee register successfully...")
    });
    res.send("registered successfully...");
});

mongoose.connect("mongodb://localhost:27017/3Q")
.then(() => {
    console.log("connected to db");
})
.catch((err) => {
    console.log(err);
});


app.listen(4000, () => {
    console.log("server is running at port 4000: http://localhost:4000");
});