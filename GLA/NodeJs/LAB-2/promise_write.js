let fs = require('fs/promises');
let path = __dirname + 'data.txt';
fs.writeFile(path, "learning fs system writefile fn using promises")
.then(() => {
    console.log("done successfully..." + __dirname);
})
.catch ((err) => {
    console.log(err);
})

