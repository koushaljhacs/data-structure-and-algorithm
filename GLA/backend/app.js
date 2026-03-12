let express = require('express');
let app = express();
let path = require('path');
const methodOverride = require('method-override');

app.set('view engine', 'ejs');
app.set('views',path.join(__dirname, 'views'));
app.use(express.urlencoded({ extended: true }));
app.use(methodOverride('_method'));

// In-memory data store
let products = [
    { id: 1, name: 'Smart Phone' },
    { id: 2, name: 'Wireless Earbuds' },
    { id: 3, name: 'Smart Watch' }
];
let nextId = 4;

// Read: Display all products
app.get('/product', (req, res) => {
    res.render("show", {products})
});

// Show form to create a new product
app.get('/add', (req, res) => {
    res.render("add");
});

// Create: Add a new product to the list
app.post('/add', (req, res) => {
    const { product } = req.body;
    if (product) {
        products.push({ id: nextId++, name: product });
    }
    res.redirect('/product');
});


// Show form to edit a product
app.get('/product/:id/edit', (req, res) => {
    const { id } = req.params;
    const product = products.find(p => p.id === parseInt(id));
    if (product) {
        res.render('edit', { product });
    } else {
        res.redirect('/product');
    }
});

// Update: Update a product's name
app.put('/product/:id', (req, res) => {
    const { id } = req.params;
    const { product: newName } = req.body;
    const productToUpdate = products.find(p => p.id === parseInt(id));
    if (productToUpdate && newName) {
        productToUpdate.name = newName;
    }
    res.redirect('/product');
});

// Delete: Remove a product from the list
app.delete('/product/:id', (req, res) => {
    const { id } = req.params;
    products = products.filter(p => p.id !== parseInt(id));
    res.redirect('/product');
});


app.listen(4000, () => {
    console.log("server is running at port 4000: localhost:4000");
});