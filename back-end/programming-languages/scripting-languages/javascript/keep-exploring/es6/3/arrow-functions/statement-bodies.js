// ECMAScript 6 - systactic sugar: reduced
nums.forEach(v => {
    if (v % 5 === 0)
        fives.push(v)
})

// ECMAScript 5 - systactic sugar: traditional
nums.forEach(function (v) { 
    if (v % 5 === 0) 
        fives.push(v); 
});
