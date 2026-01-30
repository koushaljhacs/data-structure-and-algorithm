let fs = require('fs');
//C:\Users\koush\OneDrive\OctNov\GLA\LAB-2
// console.log(__dirname + '/data.txt');

let path = __dirname + '/data.txt';
fs.writeFile(path, "hello learning filesystem", (err) => {
    if(err) {
        console.log(err);
    } else {
        console.log("done successfully...");
    }
})