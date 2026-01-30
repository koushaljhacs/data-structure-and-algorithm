// 1. We invite the 'http' helper to build our web server
let http = require('http');

// 2. We create the server (like a robot that waits for visitors)
let server = http.createServer((req, res) => {
    
    // 3. We look into the 'authorization' pocket of the visitor's request
    let header = req.headers.authorization;
    
    // 4. This is the secret password needed to enter
    let secret = "koushaljha";
    
    // 5. CHECK: Did the visitor forget to bring a key?
    if(!header) {
        /* Status 400 (Bad Request): 
           Think of this as "Mistake!". The visitor forgot to send the header.
        */
        res.statusCode = 400; 
        res.write("Kindly enter secret key first");
        return res.end(); // Stop here and send the message back
    }

    // 6. CHECK: Is the key they brought exactly the same as our secret?
    if(header == secret) {
        /* Status 200 (OK): 
           Think of this as "Thumbs Up!". Everything worked perfectly.
           
           Note on 201 (Created): 
           This is like "Thumbs Up + New Toy!". You use 201 when the 
           visitor successfully makes something new, like a new account.
        */
        res.statusCode = 200;
        res.write("Welcome user");
        return res.end(); // Door opens! Stop and send message.
    }
    
    // 7. FINAL OPTION: They brought a key, but it's the WRONG one.
    else {
        /* Status 400 (Bad Request): 
           The visitor sent a key, but it doesn't match our rules.
        */
        res.statusCode = 400;
        res.write("Invalid! user...");
        return res.end(); // Wrong key! Stop and send message.
    }
})

// 8. Tell the server to start listening at the "Address Number" 3001
server.listen(3001, () => {
    console.log("server is running at port 3001");
})