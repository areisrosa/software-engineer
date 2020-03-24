// In JavaScript conversion between different two build-in types 
// called coercion. Coercion comes in two forms in JavaScript: explicit
// and implicit

// Here's an exemple of explicit coercion:

var a = '42';
var b = Number(a);

console.log(a + " is a string"); // "42"
console.log(b + " is a number"); // 42 -- the number!


// Here's an exemple of implicit coercion:

var b = a * 1; // "42" implicitly coerced to 42 here

console.log(a + " is a string"); // "42"
console.log(b + " is a number"); // 42 -- the number!
