let math = require('./Math');
console.log(math.Pi);
console.log(math.sum(2,4));
console.log(math.product(5,7));

let {pi, sum, product} = require('./Math');
console.log(pi);
console.log(sum(3,6));
console.log(product(13,36));