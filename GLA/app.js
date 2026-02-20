const fs = require('fs');
const http = require('http');

const LOG_FILE_PATH = __dirname + '/user-log.txt';

fs.writeFile(LOG_FILE_PATH, "=== User Hit Log ===\n", (err) => {
    if(err) {
        console.log("Error creating log file:", err);
    } else {
        console.log("Log file initialized");
    }
});

const server = http.createServer((req, res) => {
    if (req.url === '/favicon.ico') {
        res.writeHead(204);
        res.end();
        return;
    }
    
    const timestamp = new Date().toISOString();
    const logEntry = `[${timestamp}] User hit: ${req.url}\n`;
    
    fs.appendFile(LOG_FILE_PATH, logEntry, (err) => {
        if(err) {
            console.log("Error writing to log:", err);
        } else {
            console.log("User hit logged:", req.url);
        }
    });
    
    fs.readFile(LOG_FILE_PATH, 'utf8', (err, data) => {
        if(err) {
            res.write("Error reading log file");
        } else {
            res.write(data);
        }
        res.end();
    });
});

const PORT = 3000;
server.listen(PORT, () => {
    console.log(`Server running at port ${PORT}`);
});