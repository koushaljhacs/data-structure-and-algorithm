let express = require('express')
let path = require('path')
let bodyParser = require('body-parser')

let app = express()

app.use(bodyParser.urlencoded({ extended: true }))

app.set('view engine', 'ejs')
app.set('views', path.join(__dirname, 'views'))

app.get('/', (req, res) => {
    console.log('GET /')
    res.send('<a href="/postRegister">Open Register Form</a>')
})

app.get('/postRegister', (req, res) => {
    console.log('GET /postRegister')
    res.render('postRegister', { error: null, data: {} })
})

app.post('/postRegister', (req, res, next) => {
    try {
        console.log('POST /postRegister')
        let name = req.body.name
        let field = req.body.field
        let password = req.body.password
        let confirmPassword = req.body.confirmPassword

        console.log('Name:', name)
        console.log('Field:', field)
        console.log('Password length:', password ? password.length : 0)
        console.log('Confirm length:', confirmPassword ? confirmPassword.length : 0)

        if (!name || !field || !password || !confirmPassword) {
            throw new Error('Please fill all fields')
        }

        if (password !== confirmPassword) {
            console.log('Password not matched')
            throw new Error('Confirm password not matched')
        }

        console.log('Registration success')
        res.send(`<h2>Registered</h2><p>Name: ${name}</p><p>Field: ${field}</p>`)
    } catch (err) {
        next(err)
    }
})

app.use((err, req, res, next) => {
    console.log('Error:', err.message)
    res.status(400).render('postRegister', {
        error: err.message,
        data: {
            name: req.body.name || '',
            field: req.body.field || ''
        }
    })
})

app.listen(3000, () => {
    console.log('server is running at port 3000')
})
