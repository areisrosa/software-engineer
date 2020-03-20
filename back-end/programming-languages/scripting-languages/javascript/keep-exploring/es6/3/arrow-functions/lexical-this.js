// ECMAScript 6 - systactic sugar: reduced
this.nums.forEach((v) => { 
    if (v % 5 === 0) 
        this.fives.push(v) })

// ECMAScript 5 - systactic sugar: traditional
//  variant 1
var self = this;
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        self.fives.push(v);
});

//  variant 2
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        this.fives.push(v);
}, this);

//  variant 3 (since ECMAScript 5.1 only)
this.nums.forEach(function (v) {
    if (v % 5 === 0)
        this.fives.push(v);
}.bind(this));
