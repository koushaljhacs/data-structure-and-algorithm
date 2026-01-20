let fs = require('fs');
let path = __dirname + '/path.txt';
fs.writeFile(path, "Learning node js fs writeFile", (err) => {
    if(err) {
        console.log(err)
    } else {
        console.log("Done")
    }
})
//console.log(__dirname); // C:\Users\koush\OneDrive\OctNov\GLA\lecture-5