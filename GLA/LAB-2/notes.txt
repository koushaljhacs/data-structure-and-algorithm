// let math = require('./math');



// console.log(math.sum(5,10));
// console.log(math.product(5,10));

let {sum, product} = require('./math');
console.log(sum(5,10));
console.log(product(5,10));

let person = {
    name: "koushal"
}
let {name} = person;
console.log(name);

