let num = [5, 8, 2, 9, 3]
// num.push()
// num.push(1)
// console.log(num)
// console.log(`The value has ${num.length} position`)
// console.log(`The first valeu vector is ${num[0]}`)
//

// for(let pos=0; pos < num.length; pos++) {
//     console.log(`The position ${pos} has the valeu ${num[pos]}`)
// }
// or
for(let pos in num) {
    console.log(`The position ${pos} has the valeu ${num[pos]}`)
}
