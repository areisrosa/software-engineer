// Block-scoped variables(and constants) without hoisting.

let a = []

for (let i = 0; i < a.length; i++) {
    let x = a[i]
}

let b = []

for (let i = 0; i < b.length; i++) {
    let y = b[i]
}

let callbacks = []

for (let i = 0; i <= 2; i++) {
    callbacks[i] = function () { 
        return i * 2
    }
}

console.log(callbacks[0]())
console.log(callbacks[1]() === 2)
console.log(callbacks[2]() === 4)
