// More expressive closure syntax.

// ECMAScript 6
odds  = evens.map(v => v + 1)
pairs = evens.map(v => ({ even: v, odd: v + 1 }))
nums  = evens.map((v, i) => v + i)

// ECMAScript 5
odds  = evens.map(function (v) { return v + 1; }); 
pairs = evens.map(function (v) { return { even: v, odd: v + 1 }; }); 
nums  = evens.map(function (v, i) { return v + i; });
