// What is the object type? 
// The object type refers to a compound value where you can set properties //
// (named locations) that each hold their own values of any type. 

var obj = { a: "hello world", // property
            b: 42,
            c: true
};

// Accessed object type with doted notation
console.log(obj.a);
console.log(obj.b);
console.log(obj.c);

// Accessed object type with bracket notation
console.log(obj["a"]);
console.log(obj["b"]);
console.log(obj["c"]);
