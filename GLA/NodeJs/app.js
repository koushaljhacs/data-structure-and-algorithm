let express = require('express')
let app = express();
let path = require('path');

let bodyParser = require('body-parser');

app.use(bodyParser.urlencoded({ extended: true }));

app.set('view engine', "ejs");
app.set("views", path.join(__dirname, 'views'));

let obj = {
    id : 1212
}

let todo = [
    "coding",
    "reading books",
    "go to market"
]

app.get('/todos', (req, res) => {
    res.render('todos', {todo});
})

app.get('/', (req, res) => {
    res.render('index', {obj});
})

app.get('/register', (req, res) => {
    res.render('register')
})


app.post('/register', (req, res) => {
    const { name, age, phone, gender, email, password, address, terms } = req.body;
    
    console.log('Registration Data Received:');
    console.log('Name:', name);
    console.log('Age:', age);
    console.log('Phone:', phone);
    console.log('Gender:', gender);
    console.log('Email:', email);

    res.send(`
        <h1>Registration Successful!</h1>
        <h2>User Details:</h2>
        <p><strong>Name:</strong> ${name || 'Not provided'}</p>
        <p><strong>Age:</strong> ${age || 'Not provided'}</p>
        <p><strong>Phone:</strong> ${phone || 'Not provided'}</p>
        <p><strong>Gender:</strong> ${gender || 'Not provided'}</p>
        <p><strong>Email:</strong> ${email || 'Not provided'}</p>
        <p><strong>Address:</strong> ${address || 'Not provided'}</p>
        <br>
        <a href="/">Go to Home</a> | 
        <a href="/register">Register Another</a>
    `);
});

app.listen(3000, () => {
    console.log("App is running at the port 3000...");
});